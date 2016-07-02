package com.apixandru.pokemon.ui.object;

import com.apixandru.pokemon.model.Constants;
import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.model.object.Point;
import com.apixandru.pokemon.ui.CanUpdate;
import com.apixandru.pokemon.ui.PlayerSpriteProvider;
import com.apixandru.pokemon.ui.render.Animation;
import com.apixandru.pokemon.ui.render.CanRender;
import com.apixandru.pokemon.ui.render.Image;
import com.apixandru.pokemon.ui.render.Renderer;

import static com.apixandru.pokemon.model.Constants.getDirectionModifier;
import static com.apixandru.pokemon.model.Constants.getDirectionModifierUnsigned;
import static com.apixandru.pokemon.model.object.FloatingPoint.ZERO;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_HEIGHT;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_WIDTH;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 26, 2016
 */
public final class Player<R extends Renderer, D extends Number> implements CanRender<R>, CanUpdate<D> {

    private final float speed;

    private final Character character;
    private final PlayerSpriteProvider<R, D> playerSpriteProvider;

    private FloatingPoint offset;
    private FloatingPoint moveTo;

    private boolean moving;
    private Point directionModifiers;

    public Player(final Character character, PlayerSpriteProvider<R, D> playerSpriteProvider, float speed) {
        this.character = character;
        this.playerSpriteProvider = playerSpriteProvider;
        this.speed = speed;
        reset();
    }

    @Override
    public void update(MoveInput moveInput, D delta) {
        final boolean nowMoving = moveInput.isMove();
        boolean finishedWalking = true;
        if (moving) {
            getMovingAnimation().update(moveInput, delta);

            final float changeX = speed * delta.floatValue(); // use float value?
            final float changeY = speed * delta.floatValue();

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
        Constants.MoveDirection moveDirection = adapt.getMoveDirection();

        if (character.moveBegin(moveDirection)) {
            Point directionPoint = getDirectionModifierUnsigned(moveDirection);
            moveTo = new FloatingPoint(directionPoint.x * BLOCK_WIDTH, directionPoint.y * BLOCK_HEIGHT);
        }
        directionModifiers = getDirectionModifier(moveDirection);
        moving = true;
    }

    @Override
    public void render(R renderer, FloatingPoint floatingPoint) {
        CanRender<R> renderable;
        if (moving) {
            renderable = getMovingAnimation();
        } else {
            renderable = getStandingImage();
        }
        renderable.render(renderer, getPosition());
    }

    private Animation<R, D> getMovingAnimation() {
        return playerSpriteProvider.getMoving(character.moveDirection);
    }

    private Image<R> getStandingImage() {
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
