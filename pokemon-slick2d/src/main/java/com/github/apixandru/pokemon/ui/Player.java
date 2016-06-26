/**
 *
 */
package com.github.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.model.object.Point;
import com.apixandru.pokemon.slick2d.SlickPlayerSpriteProvider;
import com.apixandru.pokemon.slick2d.render.SlickAnimation;
import com.apixandru.pokemon.slick2d.render.SlickImage;
import com.apixandru.pokemon.slick2d.render.SlickRenderer;
import com.apixandru.pokemon.ui.CanUpdate;
import com.apixandru.pokemon.ui.render.CanRender;

import static com.apixandru.pokemon.model.Constants.getDirectionModifier;
import static com.apixandru.pokemon.model.Constants.getDirectionModifierUnsigned;
import static com.apixandru.pokemon.model.object.FloatingPoint.ZERO;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_HEIGHT;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_WIDTH;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public final class Player implements CanRender<SlickRenderer>, CanUpdate<Integer> {

    private final float speed = .07f;
    private final Character character;
    private final SlickPlayerSpriteProvider playerSpriteProvider;

    private FloatingPoint offset;
    private FloatingPoint moveTo;

    private boolean moving;
    private Point directionModifiers;

    public Player(final Character character, SlickPlayerSpriteProvider playerSpriteProvider) {
        this.character = character;
        this.playerSpriteProvider = playerSpriteProvider;
        reset();
    }

    @Override
    public void update(MoveInput moveInput, Integer delta) {
        final boolean nowMoving = moveInput.isMove();
        boolean finishedWalking = true;
        if (moving) {
            getMovingAnimation().update(moveInput, delta);

            final float changeX = speed * delta;
            final float changeY = speed * delta;

            offset = offset.add(directionModifiers.x * changeX, directionModifiers.y * changeY);

            moveTo = moveTo.add(-changeX, -changeY);

            finishedWalking = moveTo.x <= 0 && moveTo.y <= 0;

            if (finishedWalking) {
                offset = ZERO;
                character.moveEnd();
                if (!nowMoving) {
                    getMovingAnimation().reset();
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
            moveTo = new FloatingPoint(directionPoint.x * BLOCK_WIDTH, directionPoint.y * BLOCK_HEIGHT);
        }
        directionModifiers = getDirectionModifier(moveDirection);
        moving = true;
    }

    @Override
    public void render(SlickRenderer renderer, FloatingPoint floatingPoint) {
        CanRender<SlickRenderer> renderable;
        if (moving) {
            renderable = getMovingAnimation();
        } else {
            renderable = getStandingImage();
        }
        renderable.render(renderer, getPosition());
    }

    private SlickAnimation getMovingAnimation() {
        return playerSpriteProvider.getMoving(character.moveDirection);
    }

    private SlickImage getStandingImage() {
        return playerSpriteProvider.getStanding(character.moveDirection);
    }

    public FloatingPoint getPosition() {
        Point currentLocation = character.getCurrentLocation();
        float currentX = currentLocation.x * BLOCK_WIDTH + offset.x;
        float currentY = currentLocation.y * BLOCK_HEIGHT + offset.y;
        return new FloatingPoint(currentX, currentY);
    }

    public void reset() {
        this.playerSpriteProvider.reset();
        this.moving = false;
        this.offset = ZERO;
        this.moveTo = ZERO;
    }

}
