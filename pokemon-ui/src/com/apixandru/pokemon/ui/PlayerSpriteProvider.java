package com.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.ui.render.Animation;
import com.apixandru.pokemon.ui.render.Image;
import com.apixandru.pokemon.ui.render.Renderer;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 19, 2016
 */
public interface PlayerSpriteProvider<R extends Renderer, M extends Animation<R, ?>> {

    M getMoving(MoveDirection moveDirection);

    Image<R> getStanding(MoveDirection moveDirection);

    void reset();

}
