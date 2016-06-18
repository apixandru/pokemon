/**
 *
 */
package com.github.apixandru.pokemon.ui.util.map;

import com.apixandru.pokemon.model.map.PokemonMaps;
import com.github.apixandru.pokemon.ui.PokemonTiledMap;


/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public interface MapManager extends PokemonMaps {

    PokemonTiledMap getMap(String name);

}
