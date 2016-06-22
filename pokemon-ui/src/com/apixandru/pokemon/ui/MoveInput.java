/**
 *
 */
package com.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.Constants.MoveDirection;

/**
 * @author Alexandru Bledea
 * @since May 18, 2015
 */
public interface MoveInput {

    MoveDirection getMoveDirection();

    boolean isMove();

}
