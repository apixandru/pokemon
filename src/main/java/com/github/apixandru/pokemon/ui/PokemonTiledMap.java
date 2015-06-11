/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.github.apixandru.pokemon.model.PokemonMapImpl;

/**
 * This class only exists because we didn't have direct access
 * to the objects from inside tiled map, whatever
 *
 * @author Alexandru Bledea
 * @since Jun 10, 2015
 */
public class PokemonTiledMap extends TiledMap {

	public final PokemonMapImpl model;

	/**
	 * @param ref
	 * @throws SlickException
	 */
	public PokemonTiledMap(final String ref) throws SlickException {
		super(ref);

		this.model = new PokemonMapImpl(getWidth(), getHeight());

		parseObjects();
		initializeBlocked();
	}

	/**
	 *
	 */
	private void parseObjects() {
		final int objectGroupCount = getObjectGroupCount();
		if (1 < objectGroupCount) {
			throw new IllegalStateException("More than one group defined!");
		}
		if (objectGroupCount == 0) {
			return;
		}
		final ObjectGroup group = (ObjectGroup) objectGroups.get(0);
		if (!"events".equals(group.name)) {
			throw new IllegalStateException("Expected group name to be 'stuff', it's actually " + group.name);
		}
		for (final Object object : group.objects) {
			final GroupObject obj = (GroupObject) object;
			final String type = (String) obj.props.get("type");
			switch (type) {
				case "spawn_point":
					break;
				case "warp_point":
					break;
				default:
					throw new IllegalArgumentException("Cannot parse map, unexpected type: " + type);
			}
		}
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

}
