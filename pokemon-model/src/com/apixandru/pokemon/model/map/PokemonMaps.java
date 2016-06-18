package com.apixandru.pokemon.model.map;

import com.apixandru.pokemon.model.object.SpawnPoint;
import com.apixandru.pokemon.model.object.WarpPoint;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 18, 2016
 */
public interface PokemonMaps {

    SpawnPoint getSpawnPoint(WarpPoint warpPoint);

}
