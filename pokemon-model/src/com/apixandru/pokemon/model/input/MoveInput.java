/**
 *
 */
package com.apixandru.pokemon.model.input;

import com.apixandru.pokemon.model.Constants.MoveDirection;

/**
 * @author Alexandru Bledea
 * @since May 18, 2015
 */
public interface MoveInput {

    MoveDirection getMoveDirection();

    default boolean isMove() {
        return null != getMoveDirection();
    }

}
