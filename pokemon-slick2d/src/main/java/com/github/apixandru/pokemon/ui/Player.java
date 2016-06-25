/**
 *
 */
package com.github.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.Point;
import com.apixandru.pokemon.slick2d.SlickPlayerSpriteProvider;
import com.apixandru.pokemon.ui.CanUpdate;
import com.github.apixandru.pokemon.ui.util.CanRender;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Vector2f;

import static com.apixandru.pokemon.model.Constants.getDirectionModifier;
import static com.apixandru.pokemon.model.Constants.getDirectionModifierUnsigned;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_HEIGHT;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_WIDTH;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public final class Player implements CanRender, CanUpdate<Integer> {

    private final Vector2f offset = new Vector2f();
    private final Vector2f moveTo = new Vector2f();

    private final float speed = .07f;
    private final Character character;

    private final SlickPlayerSpriteProvider playerSpriteProvider;

    private boolean moving;
    private Point directionModifiers;

    public Player(final Character character, SlickPlayerSpriteProvider playerSpriteProvider) {
        this.character = character;
        this.playerSpriteProvider = playerSpriteProvider;
    }

    @Override
    public void update(MoveInput moveInput, Integer delta) {
        final boolean nowMoving = moveInput.isMove();
        boolean finishedWalking = true;
        if (moving) {
            getMovingAnimation().update(delta);

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
                    getMovingAnimation().restart();
                    moving = false;
                }
            }
        }
        if (finishedWalking && nowMoving) {
            move(moveInput);
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
    public void render() {
        Renderable renderable;
        if (moving) {
            renderable = getMovingAnimation();
        } else {
            renderable = getStandingImage();
        }
        final Vector2f position = getPosition();
        renderable.draw(position.x, position.y);
    }

    private Animation getMovingAnimation() {
        return playerSpriteProvider.getMoving(character.moveDirection);
    }

    private Image getStandingImage() {
        return playerSpriteProvider.getStanding(character.moveDirection);
    }

    public Vector2f getPosition() {
        Point currentLocation = character.getCurrentLocation();
        return new Vector2f(currentLocation.x * BLOCK_WIDTH + offset.x, currentLocation.y * BLOCK_HEIGHT + offset.y);
    }

    public void reset() {
        this.playerSpriteProvider.reset();
        this.moving = false;
        this.offset.x = 0;
        this.offset.y = 0;
        this.moveTo.x = 0;
        this.moveTo.y = 0;
    }

}
