package com.apixandru.pokemon.sprite;

import com.apixandru.libgdx.util.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.MOVING_DOWN;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.MOVING_LEFT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.MOVING_UP;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_DOWN;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_LEFT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_UP;
import static java.util.Arrays.asList;

public final class CharacterSprites {

    public final List<TextureRegion> notMoving;
    public final List<Animation> moving;

    CharacterSprites(final TextureRegion[][] spriteSheet) {

        final TextureRegion sittingUp = spriteSheet[SITTING_UP][0];
        final TextureRegion sittingLeft = spriteSheet[SITTING_LEFT][0];
        final TextureRegion sittingRight = flip(sittingLeft);
        final TextureRegion sittingDown = spriteSheet[SITTING_DOWN][0];

        final TextureRegion moveUp = spriteSheet[MOVING_UP][0];
        final TextureRegion moveLeft = spriteSheet[MOVING_LEFT][0];
        final TextureRegion moveRight = flip(moveLeft);
        final TextureRegion moveDown = spriteSheet[MOVING_DOWN][0];

        this.notMoving = asList(
                sittingUp,
                sittingRight,
                sittingDown,
                sittingLeft);


        this.moving = asList(animation(moveUp, sittingUp),
                new Animation(.15f, moveRight, sittingRight),
                animation(moveDown, sittingDown),
                new Animation(.15f, moveLeft, sittingLeft));

    }

    private static Animation animation(final TextureRegion frameMoving, final TextureRegion frameSitting) {
        return new Animation(.15f, frameMoving, frameSitting, flip(frameMoving), frameSitting);
    }

    private static TextureRegion flip(final TextureRegion textureRegion) {
        TextureRegion flipped = new TextureRegion(textureRegion);
        flipped.flip(true, false);
        return flipped;
    }

    public void reset() {
        for (final Animation animation : moving) {
            animation.reset();
        }
    }

}
