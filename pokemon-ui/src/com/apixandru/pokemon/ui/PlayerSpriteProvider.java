package com.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.ui.render.Animation;
import com.apixandru.pokemon.ui.render.Image;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 19, 2016
 */
public interface PlayerSpriteProvider<S extends Image<?>, M extends Animation<?, ?>> {

    M getMoving(MoveDirection moveDirection);

    S getStanding(MoveDirection moveDirection);

    void reset();

}
