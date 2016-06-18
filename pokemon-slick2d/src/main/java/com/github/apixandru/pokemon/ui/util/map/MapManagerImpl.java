/**
 *
 */
package com.github.apixandru.pokemon.ui.util.map;

import com.apixandru.pokemon.model.MapEventListener;
import com.apixandru.pokemon.model.PokemonMapImpl;
import com.apixandru.pokemon.model.object.SpawnPoint;
import com.apixandru.pokemon.model.object.WarpPoint;
import com.github.apixandru.pokemon.ui.PokemonTiledMap;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public final class MapManagerImpl implements MapManager {

    private final Map<String, PokemonTiledMap> maps = new HashMap<>();
    private final MapEventListener listener;

    public MapManagerImpl(final MapEventListener listener) throws SlickException {
        this.listener = listener;
        loadMap("pallet_town/ash_house_level1");
        loadMap("pallet_town/ash_house_level0");
        validateLinks();
    }

    private void validateLinks() {
        for (final Entry<String, PokemonTiledMap> entry : maps.entrySet()) {
            final PokemonTiledMap map = entry.getValue();
            final PokemonMapImpl model = (PokemonMapImpl) map.getModel();
            for (final WarpPoint warp : model.getWarpPoints()) {
                if (!maps.containsKey(warp.destName)) {
                    throw new IllegalStateException(String.format("Map '%s' references '%s', but no such map loaded", entry.getKey(), warp.destName));
                }
                final PokemonTiledMap destMap = maps.get(warp.destName);
                final PokemonMapImpl destMapModel = (PokemonMapImpl) destMap.getModel();
                final SpawnPoint spawnPoint = destMapModel.getSpawnPoint(warp.spawnIndex);
                if (null == spawnPoint) {
                    throw new IllegalStateException(String.format("Map '%s' references '%s' spawn index '%s', but no such index exists!",
                            entry.getKey(), warp.destName, warp.spawnIndex));
                }
            }
        }
    }


    private void loadMap(final String filename) throws SlickException {
        maps.put(filename.split("/")[1], new PokemonTiledMap("resources/maps/" + filename + ".tmx", listener));
    }

    @Override
    public PokemonTiledMap getMap(final String name) {
        return maps.get(name);
    }

    @Override
    public SpawnPoint getSpawnPoint(final WarpPoint warpPoint) {
        final PokemonTiledMap destination = maps.get(warpPoint.destName);
        final PokemonMapImpl destMapModel = (PokemonMapImpl) destination.getModel();
        return destMapModel.getSpawnPoint(warpPoint.spawnIndex);
    }

}
