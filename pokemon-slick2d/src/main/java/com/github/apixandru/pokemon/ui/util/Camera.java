package com.github.apixandru.pokemon.ui.util;

import com.apixandru.pokemon.model.object.FloatingPoint;
import org.newdawn.slick.Graphics;

/**
 * @author Alexandru Bledea
 * @since May 17, 2015
 */
public final class Camera {

    private final float visibleWidth;
    private final float visibleHeight;
    private final byte scale;

    public Camera(final float visibleWidth, final float visibleHeight, final byte scale) {
        this.visibleWidth = visibleWidth / scale;
        this.visibleHeight = visibleHeight / scale;
        this.scale = scale;
    }

    private static float compute(final float position, final float visibleRange) {
        return visibleRange / 2 - position;
    }

    public void translate(final Graphics graphics, final FloatingPoint position) {
        final float x = compute(position.x, this.visibleWidth);
        final float y = compute(position.y, this.visibleHeight);
        graphics.scale(scale, scale);
        graphics.translate(x, y);
    }

}
