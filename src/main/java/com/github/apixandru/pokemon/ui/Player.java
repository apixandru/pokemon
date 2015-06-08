/**
 *
 */
package com.github.apixandru.pokemon.ui;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS_NO_SIGN;
import static com.github.apixandru.pokemon.util.Constants.POS_X;
import static com.github.apixandru.pokemon.util.Constants.POS_Y;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Vector2f;

import com.github.apixandru.pokemon.model.PokemonMap;
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
	public final Vector2f position;

	private final float speed = .07f;

	private boolean moving;
	private byte[] directionModifiers;

	private byte moveDirection;

	private final PokemonMap mapModel;

	/**
	 * @param mapModel
	 * @param vector2f
	 * @param redSprites
	 */
	public Player(final Vector2f position, final CharacterSprites sprites, final PokemonMap mapModel) {
		this.position = position;
		this.sprites = sprites;
		this.mapModel = mapModel;
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) {
		final MoveInput adapt = MoveInputAdapter.adapt(container.getInput());
		final boolean nowMoving = adapt.isMove();
		boolean finishedWalking = true;

		if (moving) {
			sprites.moving.get(moveDirection).update(delta);

			final float changeX = speed * delta;
			final float changeY = speed * delta;

			position.x += directionModifiers[POS_X] * changeX;
			position.y += directionModifiers[POS_Y] * changeY;

			moveTo.x -= changeX;
			moveTo.y -= changeY;

			finishedWalking = moveTo.x <= 0 && moveTo.y <= 0;

			if (finishedWalking) {
				PositionUtil.round(position); // center in block
				if (!nowMoving) {
					sprites.moving.get(moveDirection).restart();
					moving = false;
				}
			}
		}
		if (finishedWalking && nowMoving) {
			move(adapt);
		}
	}

	/**
	 * @param adapt
	 */
	private void move(final MoveInput adapt) {
		moveDirection = adapt.getMoveDirection();
		directionModifiers = DIRECTION_MODIFIERS[moveDirection];
		moveTo.x = DIRECTION_MODIFIERS_NO_SIGN[moveDirection][POS_X] * BLOCK_WIDTH;
		moveTo.y = DIRECTION_MODIFIERS_NO_SIGN[moveDirection][POS_Y] * BLOCK_HEIGHT;
		moving = true;
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		final List<? extends Renderable> renderables;
		if (moving) {
			renderables = sprites.moving;
		} else {
			renderables = sprites.notMoving;
		}
		renderables.get(moveDirection).draw(position.x, position.y, BLOCK_WIDTH, BLOCK_HEIGHT);
	}

}
