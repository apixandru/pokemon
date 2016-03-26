/**
 *
 */
package com.github.apixandru.pokemon.ui.util;

import com.github.apixandru.pokemon.util.Constants;
import org.newdawn.slick.Input;


/**
 * @author Alexandru Bledea
 * @since May 18, 2015
 */
public final class MoveInputAdapter implements MoveInput {

    private final Input input;

    private MoveInputAdapter(final Input input) {
        this.input = input;
    }

    public static MoveInput adapt(final Input input) {
        return new MoveInputAdapter(input);
    }

    @Override
    public byte getMoveDirection() {
        if (input.isKeyDown(Input.KEY_UP)) {
            return Constants.DIRECTION_UP;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            return Constants.DIRECTION_RIGHT;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            return Constants.DIRECTION_DOWN;
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            return Constants.DIRECTION_LEFT;
        }
        return -1;
    }

    @Override
    public boolean isMove() {
        return -1 != getMoveDirection();
    }

}
