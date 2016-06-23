/**
 *
 */
package com.github.apixandru.pokemon.ui.util;

import com.apixandru.pokemon.model.Constants;
import com.apixandru.pokemon.ui.MoveInput;
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
    public Constants.MoveDirection getMoveDirection() {
        if (input.isKeyDown(Input.KEY_UP)) {
            return Constants.MoveDirection.UP;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            return Constants.MoveDirection.RIGHT;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            return Constants.MoveDirection.DOWN;
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            return Constants.MoveDirection.LEFT;
        }
        return null;
    }

}
