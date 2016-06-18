/**
 *
 */
package com.github.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.MapEventListener;
import com.apixandru.pokemon.model.PokemonMap;
import com.apixandru.pokemon.model.PokemonMapImpl;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * This class only exists because we didn't have direct access
 * to the objects from inside tiled map, whatever
 *
 * @author Alexandru Bledea
 * @since Jun 10, 2015
 */
public class PokemonTiledMap extends TiledMap {

    private final PokemonMapImpl model;

    public PokemonTiledMap(final String ref, final MapEventListener eventListener) throws SlickException {
        super(ref);

        this.model = new PokemonMapImpl(getWidth(), getHeight(), eventListener);

        parseObjects();
        initializeBlocked();

    }

    private static int getRequiredInt(final GroupObject obj, final String name) {
        return Integer.parseInt(getRequiredString(obj, name));
    }

    private static String getRequiredString(final GroupObject obj, final String name) {
        final Object property = obj.props.get(name);
        if (property instanceof String) {
            return (String) property;
        }
        throw new IllegalArgumentException(String.format("Expecting object %s to have %s", obj.index, name));
    }

    private void parseObjects() {
        final int objectGroupCount = getObjectGroupCount();
        for (int layer = 0; layer < objectGroupCount; layer++) {
            final ObjectGroup group = (ObjectGroup) objectGroups.get(layer);

            switch (group.name) {
                case "spawn points":
                    parseSpawnPoints(group);
                    break;
                case "warp points":
                    parseWarpPoints(group);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown group name: " + group.name);
            }
        }
    }

    private void parseSpawnPoints(final ObjectGroup group) {
        for (final Object object : group.objects) {
            final GroupObject obj = (GroupObject) object;
            final int index = getRequiredInt(obj, "index");
            model.addSpawnPoint(obj.x / obj.width, obj.y / obj.height, index);
        }
    }

    private void parseWarpPoints(final ObjectGroup group) {
        for (final Object object : group.objects) {
            final GroupObject obj = (GroupObject) object;
            final int spawnIndex = getRequiredInt(obj, "spawn_index");
            final String destName = getRequiredString(obj, "destination");
            model.addWarpPoint(obj.x / obj.width, obj.y / obj.height, destName, spawnIndex);
        }
    }

    private void initializeBlocked() {
        final int layerId = getLayerIndex("stuff");
        if (-1 == layerId) {
            return;
        }
        for (int x = 0, xTo = getWidth(); x < xTo; x++) {
            for (int y = 0, yTo = getHeight(); y < yTo; y++) {
                if (getTileId(x, y, layerId) != 0) {
                    model.block(x, y);
                }
            }
        }
    }

    public PokemonMap getModel() {
        return model;
    }

}
