package com.apixandru.pokemon.slick2d.render;

import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.ui.render.Image;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public class SlickImage implements Image<SlickRenderer> {

    public final org.newdawn.slick.Image image;

    public SlickImage(org.newdawn.slick.Image image) {
        this.image = image;
    }

    @Override
    public void render(SlickRenderer renderer, FloatingPoint floatingPoint) {
        this.image.draw(floatingPoint.x, floatingPoint.y);
    }

}
