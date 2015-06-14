/**
 *
 */
package com.github.apixandru.pokemon.ui.util.map;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.SlickException;

import com.github.apixandru.pokemon.model.MapEventListener;
import com.github.apixandru.pokemon.ui.PokemonTiledMap;

/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public final class MapLoader {

	private final Map<String, PokemonTiledMap> maps = new HashMap<String, PokemonTiledMap>();
	private final MapEventListener listener;

	/**
	 * @param listener
	 */
	public MapLoader(final MapEventListener listener) {
		this.listener = listener;
	}

	/**
	 * @param filename
	 * @throws SlickException
	 */
	public void loadMap(final String filename) throws SlickException {
		maps.put(filename, new PokemonTiledMap("resources/maps/" + filename + ".tmx", listener));
	}

	/**
	 * @return
	 */
	public MapManager build() {
		return new MapLoaderManager();
	}

	/**
	 * @author Alexandru Bledea
	 * @since Jun 14, 2015
	 */
	private class MapLoaderManager implements MapManager {

		/* (non-Javadoc)
		 * @see com.github.apixandru.pokemon.model.MapManager#getMap(java.lang.String)
		 */
		@Override
		public PokemonTiledMap getMap(final String name) {
			return maps.get(name);
		}

	}
}
