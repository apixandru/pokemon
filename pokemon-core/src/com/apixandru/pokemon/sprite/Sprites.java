package com.apixandru.pokemon.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.apixandru.libgdx.util.GdxUtils.loadTexture;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SPRITE_HEIGHT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SPRITE_WIDTH;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class Sprites {

    public final Texture redSprites = loadTexture("../../game/resources/sprites/red.png");
    public final TextureRegion[][] tmp = TextureRegion.split(redSprites, SPRITE_WIDTH, SPRITE_HEIGHT);
    public CharacterSprites sprites = new CharacterSprites(tmp);

}
