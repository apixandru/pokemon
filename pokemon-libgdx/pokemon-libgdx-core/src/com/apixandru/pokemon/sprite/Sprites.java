package com.apixandru.pokemon.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.apixandru.libgdx.util.GdxUtils.loadTexture;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_HEIGHT;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_WIDTH;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class Sprites {

    public final Texture redSprites = loadTexture("pokemon-slick2d/resources/sprites/red.png");
    public final TextureRegion[][] tmp = TextureRegion.split(redSprites, BLOCK_WIDTH, BLOCK_HEIGHT);
    public final CharacterSprites sprites = new CharacterSprites(tmp);
    public final GdxPlayerSpriteProvider spriteProvider = new GdxPlayerSpriteProvider(sprites);

}
