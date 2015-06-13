/**
 *
 */
package com.github.apixandru.pokemon.model.object;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public final class Character {

	private final int x, y;

	private final CharacterMoveListener listener;

	/**
	 * @param x
	 * @param y
	 */
	public Character(final int x, final int y, final CharacterMoveListener listener) {
		this.x = x;
		this.y = y;
		this.listener = listener;
	}

	/**
	 * @param direction
	 */
	public void move(final byte direction) {
		listener.characterMoveStart(this, direction);
	}
}
