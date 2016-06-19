/**
 *
 */
package com.github.apixandru.pokemon.ui.util;

import com.apixandru.pokemon.model.Constants.MoveDirection;

/**
 * @author Alexandru Bledea
 * @since May 18, 2015
 */
public interface MoveInput {

    MoveDirection getMoveDirection();

    boolean isMove();

}
