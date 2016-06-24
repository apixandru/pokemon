package com.apixandru.libgdx.util;

import com.apixandru.pokemon.model.input.MoveInput;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 13, 2016
 */
public class Animation implements GdxCanUpdate {

    private final List<TextureRegion> textures;

    private final float duration;
    private final float frameDuration;

    private float currentTime;

    public Animation(float frameDuration, TextureRegion... frames) {
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

}
