/**
 *
 */
package com.github.apixandru.pokemon.ui.util.map;

import com.github.apixandru.pokemon.model.object.SpawnPoint;
import com.github.apixandru.pokemon.model.object.WarpPoint;
import com.github.apixandru.pokemon.ui.PokemonTiledMap;


/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public interface MapManager {

    /**
     * @param name
     * @return
     */
    PokemonTiledMap getMap(String name);

    /**
     * @param warpPoint
     * @return
     */
    SpawnPoint getSpawnPoint(WarpPoint warpPoint);

}
