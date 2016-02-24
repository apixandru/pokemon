/**
 *
 */
package com.github.apixandru.pokemon.ui;

import com.github.apixandru.pokemon.model.object.Character;
import com.github.apixandru.pokemon.ui.util.CanRender;
import com.github.apixandru.pokemon.ui.util.CanUpdate;
import com.github.apixandru.pokemon.ui.util.MoveInput;
import com.github.apixandru.pokemon.ui.util.MoveInputAdapter;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS;
import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS_NO_SIGN;
import static com.github.apixandru.pokemon.util.Constants.POS_X;
import static com.github.apixandru.pokemon.util.Constants.POS_Y;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public final class Player implements CanRender, CanUpdate {

    private final CharacterSprites sprites;

    private final Vector2f offset = new Vector2f();
    private final Vector2f moveTo = new Vector2f();

    private final float speed = .07f;

    private boolean moving;
    private byte[] directionModifiers;

    private final Character character;

    /**
     * @param character
     * @param sprites
     */
    public Player(final Character character, final CharacterSprites sprites) {
        this.sprites = sprites;
        this.character = character;
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
            sprites.moving.get(character.moveDirection).update(delta);

            final float changeX = speed * delta;
            final float changeY = speed * delta;

            offset.x += directionModifiers[POS_X] * changeX;
            offset.y += directionModifiers[POS_Y] * changeY;

            moveTo.x -= changeX;
            moveTo.y -= changeY;

            finishedWalking = moveTo.x <= 0 && moveTo.y <= 0;

            if (finishedWalking) {
                offset.x = 0;
                offset.y = 0;
                character.moveEnd();
                if (!nowMoving) {
                    sprites.moving.get(character.moveDirection).restart();
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
        final byte moveDirection = adapt.getMoveDirection();

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
        final Vector2f position = getPosition();
        renderables.get(character.moveDirection).draw(position.x, position.y);
    }

    /**
     * @return
     */
    public Vector2f getPosition() {
        return new Vector2f(character.xCurrent * BLOCK_WIDTH + offset.x, character.yCurrent * BLOCK_HEIGHT + offset.y);
    }

    /**
     *
     */
    public void reset() {
        this.sprites.reset();
        this.moving = false;
        this.offset.x = 0;
        this.offset.y = 0;
        this.moveTo.x = 0;
        this.moveTo.y = 0;
    }

}
