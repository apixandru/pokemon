/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.github.apixandru.pokemon.model.MapEventListener;
import com.github.apixandru.pokemon.model.PokemonMap;
import com.github.apixandru.pokemon.model.PokemonMapImpl;
import com.github.apixandru.pokemon.model.object.WarpPoint;

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

	/**
	 * @return the model
	 */
	public PokemonMap getModel() {
		return model;
	}

	/**
	 * @author Alexandru Bledea
	 * @since Jun 14, 2015
	 */
	private class EventListener implements MapEventListener {

		/* (non-Javadoc)
		 * @see com.github.apixandru.pokemon.model.MapEventListener#onWarpPoint(com.github.apixandru.pokemon.model.object.Character, com.github.apixandru.pokemon.model.object.WarpPoint)
		 */
		@Override
		public void onWarpPoint(final Character character, final WarpPoint warpPoint) {
			System.out.println("stepped on warp point");
		}

	}

}
