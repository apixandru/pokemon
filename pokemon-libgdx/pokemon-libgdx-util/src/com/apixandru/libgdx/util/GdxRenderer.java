package com.apixandru.libgdx.util;

import com.apixandru.pokemon.ui.render.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public class GdxRenderer implements Renderer {

    private final SpriteBatch spriteBatch;

    GdxRenderer(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void render(final TextureRegion region, final float x, final float y) {
        spriteBatch.draw(region, x, y);
    }

}
