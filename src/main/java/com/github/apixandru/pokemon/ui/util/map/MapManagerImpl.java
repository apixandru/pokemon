/**
 *
 */
package com.github.apixandru.pokemon.ui.util.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.newdawn.slick.SlickException;

import com.github.apixandru.pokemon.model.MapEventListener;
import com.github.apixandru.pokemon.model.PokemonMapImpl;
import com.github.apixandru.pokemon.model.object.SpawnPoint;
import com.github.apixandru.pokemon.model.object.WarpPoint;
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
		loadMap("ash_house_level0");
		validateLinks();
	}

	/**
	 *
	 */
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
							entry.getKey(),
							warp.destName, warp.spawnIndex));
				}
			}
		}
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
