/**
 *
 */
package com.github.apixandru.pokemon.ui.util;

import com.apixandru.pokemon.model.Constants;

/**
 * @author Alexandru Bledea
 * @since May 18, 2015
 */
public interface MoveInput {

    /**
     * @return
     */
    Constants.MoveDirection getMoveDirection();

    /**
     * @return
     */
    boolean isMove();

}
