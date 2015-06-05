/**
 *
 */
package com.github.apixandru.pokemon.ui;

import static com.github.apixandru.pokemon.util.Constants.POS_X;
import static com.github.apixandru.pokemon.util.Constants.POS_Y;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

import com.github.apixandru.pokemon.ui.util.CanRender;
import com.github.apixandru.pokemon.ui.util.CanUpdate;
import com.github.apixandru.pokemon.ui.util.MoveInput;
import com.github.apixandru.pokemon.ui.util.MoveInputAdapter;
import com.github.apixandru.pokemon.util.Constants;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public final class Player implements CanRender, CanUpdate {

	private final Vector2f position;
	private final Vector2f moveTo;

	private final float speed = .1f;

	private boolean moving;
	private byte[] directionModifiers;

	/**
	 * @param position
	 */
	public Player(final Vector2f position) {
		this.position = position;
		this.moveTo = position.copy();
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) {
		if (!moving) {
			final MoveInput adapt = MoveInputAdapter.adapt(container.getInput());
			if (adapt.isMove()) {
				directionModifiers = Constants.DIRECTION_MODIFIERS[adapt.getMoveDirection()];
				moveTo.x = position.x + directionModifiers[POS_X] * 32;
				moveTo.y = position.y + directionModifiers[POS_Y] * 32;
				moving = true;
			}
		} else {
			position.x = position.x + directionModifiers[POS_X] * speed * delta;
			position.y = position.y + directionModifiers[POS_Y] * speed * delta;
			if (position.y > moveTo.y) {
				position.y = moveTo.y;
			}
			if (position.x > moveTo.x) {
				position.x = moveTo.x;
			}
			if (moveTo.equals(position)) {
				moving = false;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		g.fill(new Circle(position.x, position.y, 10));
	}

}
