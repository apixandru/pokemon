/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.github.apixandru.pokemon.model.MapEventListener;
import com.github.apixandru.pokemon.model.PokemonMap;
import com.github.apixandru.pokemon.model.PokemonMapImpl;

/**
 * This class only exists because we didn't have direct access
 * to the objects from inside tiled map, whatever
 *
 * @author Alexandru Bledea
 * @since Jun 10, 2015
 */
public class PokemonTiledMap extends TiledMap {

	private final PokemonMapImpl model;

	/**
	 * @param ref
	 * @param eventListener
	 * @throws SlickException
	 */
	public PokemonTiledMap(final String ref, final MapEventListener eventListener) throws SlickException {
		super(ref);

		this.model = new PokemonMapImpl(getWidth(), getHeight(), eventListener);

		parseObjects();
		initializeBlocked();

	}

	/**
	 *
	 */
	private void parseObjects() {
		final int objectGroupCount = getObjectGroupCount();
		for (int layer = 0; layer < objectGroupCount; layer++) {
			final ObjectGroup group = (ObjectGroup) objectGroups.get(0);

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

	/**
	 * @param group
	 */
	private void parseSpawnPoints(final ObjectGroup group) {
		for (final Object object : group.objects) {
			final GroupObject obj = (GroupObject) object;
			final int index = getRequiredInt(obj, "index");
			model.addSpawnPoint(obj.x / obj.width, obj.y / obj.height, index);
		}
	}

	/**
	 * @param group
	 */
	private void parseWarpPoints(final ObjectGroup group) {
		for (final Object object : group.objects) {
			final GroupObject obj = (GroupObject) object;
			final int spawnIndex = getRequiredInt(obj, "spawn_index");
			final String destName = getRequiredString(obj, "destination");
			model.addWarpPoint(obj.x / obj.width, obj.y / obj.height, destName, spawnIndex);
		}
	}

	/**
	 * @param obj
	 * @param name
	 * @return
	 */
	private static int getRequiredInt(final GroupObject obj, final String name) {
		return Integer.parseInt(getRequiredString(obj, name));
	}

	/**
	 * @param obj
	 * @param name
	 * @return
	 */
	private static String getRequiredString(final GroupObject obj, final String name) {
		final Object property = obj.props.get(name);
		if (property instanceof String) {
			return (String) property;
		}
		throw new IllegalArgumentException(String.format("Expecting object %s to have %s", obj.index, name));
	}

	/**
	 *
	 */
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

	/**
	 * @return the model
	 */
	public PokemonMap getModel() {
		return model;
	}

}
