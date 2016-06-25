package com.apixandru.pokemon.slick2d.render;

import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.ui.render.Animation;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public class SlickAnimation implements Animation<SlickRenderer, Integer> {

    public final org.newdawn.slick.Animation animation;

    public SlickAnimation(org.newdawn.slick.Animation animation) {
        this.animation = animation;
    }

    @Override
    public void render(SlickRenderer renderer, FloatingPoint floatingPoint) {
        this.animation.draw(floatingPoint.x, floatingPoint.y);
    }

    @Override
    public void reset() {
        this.animation.restart();
    }

    @Override
    public void update(MoveInput moveInput, Integer delta) {
        animation.update(delta);
    }

}
