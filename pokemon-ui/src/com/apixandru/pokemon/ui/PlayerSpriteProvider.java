package com.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 19, 2016
 */
public interface PlayerSpriteProvider<S, M> {

    M getMoving(MoveDirection moveDirection);

    S getStanding(MoveDirection moveDirection);

    void reset();

}
