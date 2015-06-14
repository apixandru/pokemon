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
public final class MapManagerImpl implements MapManager {

	private final Map<String, PokemonTiledMap> maps = new HashMap<String, PokemonTiledMap>();
	private final MapEventListener listener;

	/**
	 * @param listener
	 * @throws SlickException
	 */
	public MapManagerImpl(final MapEventListener listener) throws SlickException {
		this.listener = listener;
		loadMap("ash_house_level1");
	}

	/**
	 * @param filename
	 * @throws SlickException
	 */
	private void loadMap(final String filename) throws SlickException {
		maps.put(filename, new PokemonTiledMap("resources/maps/" + filename + ".tmx", listener));
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.model.MapManager#getMap(java.lang.String)
	 */
	@Override
	public PokemonTiledMap getMap(final String name) {
		return maps.get(name);
	}
}
