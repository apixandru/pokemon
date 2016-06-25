package com.apixandru.libgdx.util;

import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.ui.render.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 13, 2016
 */
public class GdxAnimation implements GdxCanUpdate, Animation<GdxRenderer, Float> {

    private final List<TextureRegion> textures;

    private final float duration;
    private final float frameDuration;

    private float currentTime;

    public GdxAnimation(float frameDuration, TextureRegion... frames) {
        this.textures = unmodifiableList(asList(frames));
        this.frameDuration = frameDuration;
        this.duration = frameDuration * frames.length;

    }

    @Override
    public void update(MoveInput moveInput, Float delta) {
        currentTime += delta;
        while (currentTime > duration) {
            currentTime -= duration;
        }
    }

    public TextureRegion getCurrentFrame() {
        return textures.get((int) (currentTime / frameDuration));
    }

    public void reset() {
        currentTime = 0;
    }

    @Override
    public void render(GdxRenderer renderer, FloatingPoint floatingPoint) {
        renderer.render(getCurrentFrame(), floatingPoint.x, floatingPoint.y);
    }

}
