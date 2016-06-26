package com.apixandru.libgdx.util;

import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.ui.render.Image;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public class GdxImage implements Image<GdxRenderer> {

    public final TextureRegion image;

    public GdxImage(TextureRegion image) {
        this.image = image;
    }

    @Override
    public void render(GdxRenderer renderer, FloatingPoint floatingPoint) {
        renderer.render(image, floatingPoint.x, floatingPoint.y);
    }

}
