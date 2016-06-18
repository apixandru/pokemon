/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.SpawnPoint;
import com.apixandru.pokemon.model.object.WarpPoint;
import com.apixandru.pokemon.model.object.WorldMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexandru Bledea
 * @since Jun 7, 2015
 */
public final class PokemonMapImpl implements PokemonMap {

    private final MapEventListener listener;

    private final int rows, cols;
    private final boolean[][] content;

    private final Map<Integer, SpawnPoint> spawnPoints = new HashMap<Integer, SpawnPoint>();

    private final List<WarpPoint> warpPoints = new ArrayList<WarpPoint>();

    public PokemonMapImpl(final int cols, final int rows, final MapEventListener listener) {
        this.rows = rows;
        this.cols = cols;
        this.content = new boolean[rows][cols];
        this.listener = listener;
    }

    @Override
    public boolean isBlocked(final int x, final int y) {
        if (isOutOfBounds(x, y)) {
            return true;
        }
        return this.content[y][x];
    }

    private boolean isOutOfBounds(final int x, final int y) {
        return x < 0 || y < 0 || x >= cols || y >= rows;
    }

    public void block(final int x, final int y) {
        this.content[y][x] = true;
    }

    @Override
    public WorldMap asCharacterMoveListener() {
        return new PokemonMapCharacterMoveListener();
    }

    public void addSpawnPoint(final int x, final int y, final int index) {
        spawnPoints.put(index, new SpawnPoint(x, y, index));
    }

    public SpawnPoint getSpawnPoint(final int index) {
        return spawnPoints.get(index);
    }

    public void addWarpPoint(final int x, final int y, final String destName, final int spawnIndex) {
        warpPoints.add(new WarpPoint(x, y, destName, spawnIndex));
    }

    public List<WarpPoint> getWarpPoints() {
        return warpPoints;
    }

    /**
     * @author Alexandru Bledea
     * @since Jun 13, 2015
     */
    private class PokemonMapCharacterMoveListener implements WorldMap {

        @Override
        public void characterMoveStart(final Character character, final byte direction) {

        }

        @Override
        public void characterMoveEnd(final Character character) {
//          TODO: maybe find a quicker way ?
            for (final WarpPoint warpPoint : getWarpPoints()) {
                if (warpPoint.x == character.xCurrent && warpPoint.y == character.yCurrent) {
                    listener.onWarpPoint(character, warpPoint);
                    break;
                }
            }
        }

        @Override
        public boolean isBlocked(final int x, final int y) {
            return PokemonMapImpl.this.isBlocked(x, y);
        }

    }

}
