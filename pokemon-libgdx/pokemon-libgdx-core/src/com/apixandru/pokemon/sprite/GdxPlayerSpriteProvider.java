package com.apixandru.pokemon.sprite;

import com.apixandru.libgdx.util.GdxAnimation;
import com.apixandru.libgdx.util.GdxImage;
import com.apixandru.pokemon.model.Constants;
import com.apixandru.pokemon.ui.PlayerSpriteProvider;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 22, 2016
 */
public class GdxPlayerSpriteProvider implements PlayerSpriteProvider<GdxImage, GdxAnimation> {

    private final CharacterSprites sprites;

    public GdxPlayerSpriteProvider(final CharacterSprites sprites) {
        this.sprites = sprites;
    }

    @Override
    public GdxAnimation getMoving(Constants.MoveDirection moveDirection) {
        // TODO remove ordinal() implementation detail
        return sprites.moving.get(moveDirection.ordinal());
    }

    @Override
    public GdxImage getStanding(Constants.MoveDirection moveDirection) {
        // TODO remove ordinal() implementation detail
        return sprites.notMoving.get(moveDirection.ordinal());
    }

    @Override
    public void reset() {
        sprites.reset();
    }

}
