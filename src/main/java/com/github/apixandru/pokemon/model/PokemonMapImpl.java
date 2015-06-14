/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.github.apixandru.pokemon.model.object.Character;
import com.github.apixandru.pokemon.model.object.WorldMap;

/**
 * @author Alexandru Bledea
 * @since Jun 7, 2015
 */
public final class PokemonMapImpl implements PokemonMap {

	private final MapEventListener listener;

	private final int rows, cols;
	private final boolean[][] content;

	/**
	 * @param rows
	 * @param cols
	 * @param listener
	 */
	public PokemonMapImpl(final int rows, final int cols, final MapEventListener listener) {
		this.rows = rows;
		this.cols = cols;
		this.content = new boolean[rows][cols];
		this.listener = listener;
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.model.PokemonMap#isBlocked(int, int)
	 */
	@Override
	public boolean isBlocked(final int x, final int y) {
		if (isOutOfBounds(x, y)) {
			return true;
		}
		return this.content[y][x];
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOutOfBounds(final int x, final int y) {
		return x < 0 || y < 0 || x >= cols || y >= rows;
	}

	/**
	 * @param x
	 * @param y
	 */
	public void block(final int x, final int y) {
		this.content[y][x] = true;
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.model.PokemonMap#asCharacterMoveListener()
	 */
	@Override
	public WorldMap asCharacterMoveListener() {
		return new PokemonMapCharacterMoveListener();
	}

	/**
	 * @author Alexandru Bledea
	 * @since Jun 13, 2015
	 */
	private class PokemonMapCharacterMoveListener implements WorldMap {

		/* (non-Javadoc)
		 * @see com.github.apixandru.pokemon.model.object.CharacterMoveListener#characterMoveStart(com.github.apixandru.pokemon.model.object.Character, byte)
		 */
		@Override
		public void characterMoveStart(final Character character, final byte direction) {

		}

		/* (non-Javadoc)
		 * @see com.github.apixandru.pokemon.model.object.CharacterMoveListener#characterMoveEnd(com.github.apixandru.pokemon.model.object.Character)
		 */
		@Override
		public void characterMoveEnd(final Character character) {
			if (character.xCurrent == 7 && character.yCurrent == 1) {
				listener.onWarpPoint(character, null);
			}
		}

		/* (non-Javadoc)
		 * @see com.github.apixandru.pokemon.model.WorldBounds#isBlocked(int, int)
		 */
		@Override
		public boolean isBlocked(final int x, final int y) {
			return PokemonMapImpl.this.isBlocked(x, y);
		}
	}

}
