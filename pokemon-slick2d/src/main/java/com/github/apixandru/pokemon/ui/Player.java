/**
 *
 */
package com.github.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.Point;
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

import static com.apixandru.pokemon.model.Constants.getDirectionModifier;
import static com.apixandru.pokemon.model.Constants.getDirectionModifierUnsigned;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_HEIGHT;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_WIDTH;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public final class Player implements CanRender, CanUpdate {

    private final CharacterSprites sprites;

    private final Vector2f offset = new Vector2f();
    private final Vector2f moveTo = new Vector2f();

    private final float speed = .07f;
    private final Character character;
    private boolean moving;
    private Point directionModifiers;

    public Player(final Character character, final CharacterSprites sprites) {
        this.sprites = sprites;
        this.character = character;
    }

    @Override
    public void update(final GameContainer container, final int delta) {
        final MoveInput adapt = MoveInputAdapter.adapt(container.getInput());
        final boolean nowMoving = adapt.isMove();
        boolean finishedWalking = true;
        if (moving) {
            int ordinal = character.moveDirection.ordinal(); // TODO remove implementation detail!
            sprites.moving.get(ordinal).update(delta);

            final float changeX = speed * delta;
            final float changeY = speed * delta;

            offset.x += directionModifiers.x * changeX;
            offset.y += directionModifiers.y * changeY;

            moveTo.x -= changeX;
            moveTo.y -= changeY;

            finishedWalking = moveTo.x <= 0 && moveTo.y <= 0;

            if (finishedWalking) {
                offset.x = 0;
                offset.y = 0;
                character.moveEnd();
                if (!nowMoving) {
                    sprites.moving.get(ordinal).restart();
                    moving = false;
                }
            }
        }
        if (finishedWalking && nowMoving) {
            move(adapt);
        }
    }

    private void move(final MoveInput adapt) {
        MoveDirection moveDirection = adapt.getMoveDirection();

        if (character.moveBegin(moveDirection)) {
            Point directionPoint = getDirectionModifierUnsigned(moveDirection);
            moveTo.x = directionPoint.x * BLOCK_WIDTH;
            moveTo.y = directionPoint.y * BLOCK_HEIGHT;
        }
        directionModifiers = getDirectionModifier(moveDirection);
        moving = true;
    }

    @Override
    public void render(final Graphics g) {
        final List<? extends Renderable> renderables;
        if (moving) {
            renderables = sprites.moving;
        } else {
            renderables = sprites.notMoving;
        }
        final Vector2f position = getPosition();
        int ordinal = character.moveDirection.ordinal(); // TODO remove implementation detail
        renderables.get(ordinal).draw(position.x, position.y);
    }

    public Vector2f getPosition() {
        return new Vector2f(character.xCurrent * BLOCK_WIDTH + offset.x, character.yCurrent * BLOCK_HEIGHT + offset.y);
    }

    public void reset() {
        this.sprites.reset();
        this.moving = false;
        this.offset.x = 0;
        this.offset.y = 0;
        this.moveTo.x = 0;
        this.moveTo.y = 0;
    }

}
