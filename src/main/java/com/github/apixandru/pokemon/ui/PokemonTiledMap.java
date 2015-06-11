/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author Alexandru Bledea
 * @since Jun 10, 2015
 */
public class PokemonTiledMap extends TiledMap {

	/**
	 * @param ref
	 * @throws SlickException
	 */
	public PokemonTiledMap(final String ref) throws SlickException {
		super(ref);

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

}
