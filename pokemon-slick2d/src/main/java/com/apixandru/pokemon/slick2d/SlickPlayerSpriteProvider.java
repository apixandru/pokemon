package com.apixandru.pokemon.slick2d;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.slick2d.render.SlickAnimation;
import com.apixandru.pokemon.slick2d.render.SlickImage;
import com.apixandru.pokemon.slick2d.render.SlickRenderer;
import com.apixandru.pokemon.ui.PlayerSpriteProvider;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 19, 2016
 */
public final class SlickPlayerSpriteProvider implements PlayerSpriteProvider<SlickRenderer, Integer> {

    private final CharacterSprites sprites;

    public SlickPlayerSpriteProvider(final CharacterSprites sprites) {
        this.sprites = sprites;
    }

    @Override
    public SlickAnimation getMoving(final MoveDirection moveDirection) {
        // TODO remove ordinal() implementation detail
        return sprites.moving.get(moveDirection.ordinal());
    }

    @Override
    public SlickImage getStanding(final MoveDirection moveDirection) {
        // TODO remove ordinal() implementation detail
        return sprites.notMoving.get(moveDirection.ordinal());
    }

    @Override
    public void reset() {
        sprites.reset();
    }

}
