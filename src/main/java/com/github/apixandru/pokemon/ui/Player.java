/**
 *
 */
package com.github.apixandru.pokemon.ui;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_DOWN;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS_NO_SIGN;
import static com.github.apixandru.pokemon.util.Constants.POS_X;
import static com.github.apixandru.pokemon.util.Constants.POS_Y;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Vector2f;

import com.github.apixandru.pokemon.ui.util.CanRender;
import com.github.apixandru.pokemon.ui.util.CanUpdate;
import com.github.apixandru.pokemon.ui.util.MoveInput;
import com.github.apixandru.pokemon.ui.util.MoveInputAdapter;
import com.github.apixandru.pokemon.ui.util.PositionUtil;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public final class Player implements CanRender, CanUpdate {

	private final CharacterSprites sprites;

	private final Vector2f moveTo = new Vector2f();
	private final Vector2f position;

	private final float speed = .1f;

	private boolean moving;
	private byte[] directionModifiers;

	private final Renderable renderable;

	/**
	 * @param vector2f
	 * @param redSprites
	 */
	public Player(final Vector2f position, final CharacterSprites sprites) {
		this.position = position;
		this.sprites = sprites;
		this.renderable = sprites.notMoving.get(DIRECTION_DOWN);
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) {
		if (!moving) {
			final MoveInput adapt = MoveInputAdapter.adapt(container.getInput());
			if (adapt.isMove()) {
				final byte moveDirection = adapt.getMoveDirection();
				directionModifiers = DIRECTION_MODIFIERS[moveDirection];
				moveTo.x = DIRECTION_MODIFIERS_NO_SIGN[moveDirection][POS_X] * BLOCK_WIDTH;
				moveTo.y = DIRECTION_MODIFIERS_NO_SIGN[moveDirection][POS_Y] * BLOCK_HEIGHT;
				moving = true;
			}
		} else {
			final float changeX = speed * delta;
			final float changeY = speed * delta;

			position.x += directionModifiers[POS_X] * changeX;
			position.y += directionModifiers[POS_Y] * changeY;

			moveTo.x -= changeX;
			moveTo.y -= changeY;

			if (moveTo.x <= 0 && moveTo.y <= 0) {
				PositionUtil.round(position);
				moving = false;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		renderable.draw(position.x, position.y);
	}

}
