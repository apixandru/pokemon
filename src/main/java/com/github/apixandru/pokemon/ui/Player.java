/**
 *
 */
package com.github.apixandru.pokemon.ui;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS_NO_SIGN;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_UP;
import static com.github.apixandru.pokemon.util.Constants.POS_X;
import static com.github.apixandru.pokemon.util.Constants.POS_Y;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.github.apixandru.pokemon.model.PokemonMap;
import com.github.apixandru.pokemon.model.object.Character;
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

	private final Character character;

	/**
	 * @param x
	 * @param y
	 * @param sprites
	 * @param mapModel
	 */
	public Player(final int x, final int y, final CharacterSprites sprites, final PokemonMap mapModel) {
		this.position = new Vector2f(x * BLOCK_WIDTH, y * BLOCK_HEIGHT);
		this.sprites = sprites;
		this.character = new Character(x, y, mapModel.asCharacterMoveListener());
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) {
		throw new IllegalStateException("replace with the one below");
	}

	/**
	 * @param container
	 * @param game
	 * @param delta
	 */
	public void update(final GameContainer container, final StateBasedGame game, final int delta) {
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
				character.moveEnd();
				if (7 == position.x / BLOCK_WIDTH && 1 == position.y / BLOCK_HEIGHT) {
					game.enterState(0, new FadeOutTransition(), new FadeInTransition() {
						/* (non-Javadoc)
						 * @see org.newdawn.slick.state.transition.FadeInTransition#preRender(org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
						 */
						@Override
						public void preRender(final StateBasedGame game, final GameContainer container, final Graphics g) {
							position.x = 3 * BLOCK_WIDTH;
							position.y = 6 * BLOCK_HEIGHT;
							moveDirection = DIRECTION_UP;
						}
					});
					return;
				}

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

		if (character.moveBegin(moveDirection)) {
			moveTo.x = DIRECTION_MODIFIERS_NO_SIGN[moveDirection][POS_X] * BLOCK_WIDTH;
			moveTo.y = DIRECTION_MODIFIERS_NO_SIGN[moveDirection][POS_Y] * BLOCK_HEIGHT;
		}
		directionModifiers = DIRECTION_MODIFIERS[moveDirection];
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
