/**
 *
 */
package com.github.apixandru.pokemon.ui.util.sprites;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.Arrays;
import java.util.List;

import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.MOVING_DOWN;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.MOVING_LEFT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.MOVING_UP;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_DOWN;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_LEFT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_UP;

/**
 * @author Alexandru Bledea
 * @since Jun 6, 2015
 */
public final class CharacterSprites {

    public final List<Image> notMoving;
    public final List<Animation> moving;

    private CharacterSprites(final SpriteSheet spriteSheet) {
        final Image sittingUp = spriteSheet.getSprite(0, SITTING_UP);
        final Image sittingLeft = spriteSheet.getSprite(0, SITTING_LEFT);
        final Image sittingRight = sittingLeft.getFlippedCopy(true, false);
        final Image sittingDown = spriteSheet.getSprite(0, SITTING_DOWN);

        final Image moveUp = spriteSheet.getSprite(0, MOVING_UP);
        final Image moveLeft = spriteSheet.getSprite(0, MOVING_LEFT);
        final Image moveRight = moveLeft.getFlippedCopy(true, false);
        final Image moveDown = spriteSheet.getSprite(0, MOVING_DOWN);

        this.notMoving = Arrays.asList(
                sittingUp,
                sittingRight,
                sittingDown,
                sittingLeft);


        this.moving = Arrays.asList(animation(moveUp, sittingUp),
                new Animation(new Image[]{moveRight, sittingRight}, 150, false),
                animation(moveDown, sittingDown),
                new Animation(new Image[]{moveLeft, sittingLeft}, 150, false));
    }

    private static Animation animation(final Image frameMoving, final Image frameSitting) {
        final Image[] image = {frameMoving, frameSitting, frameMoving.getFlippedCopy(true, false), frameSitting};
        final Animation animation = new Animation(image, 150);
        animation.setAutoUpdate(false);
        return animation;
    }

    public static CharacterSprites load(final String image) throws SlickException {
        final SpriteSheet spriteSheet = SpriteParser.loadSpriteSheet(image);
        return new CharacterSprites(spriteSheet);
    }

    public void reset() {
        for (final Animation animation : moving) {
            animation.restart();
        }
    }

}
