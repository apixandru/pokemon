package com.apixandru.pokemon.model.input;

import com.apixandru.pokemon.model.Constants.MoveDirection;

import java.util.stream.Stream;

import static com.apixandru.pokemon.model.Constants.MoveDirection.DOWN;
import static com.apixandru.pokemon.model.Constants.MoveDirection.LEFT;
import static com.apixandru.pokemon.model.Constants.MoveDirection.RIGHT;
import static com.apixandru.pokemon.model.Constants.MoveDirection.UP;
import static com.apixandru.pokemon.model.input.Input.MOVE_DOWN;
import static com.apixandru.pokemon.model.input.Input.MOVE_LEFT;
import static com.apixandru.pokemon.model.input.Input.MOVE_RIGHT;
import static com.apixandru.pokemon.model.input.Input.MOVE_UP;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 23, 2016
 */
public final class UserInput implements MoveInput {

    private final InputProvider inputProvider;

    public UserInput(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    private boolean hasInput(Input input) {
        return this.inputProvider.hasInput(input);
    }

    @Override
    public MoveDirection getMoveDirection() {
        if (hasInput(MOVE_LEFT)) {
            return LEFT;
        }
        if (hasInput(MOVE_RIGHT)) {
            return RIGHT;
        }
        if (hasInput(MOVE_UP)) {
            return UP;
        }
        if (hasInput(MOVE_DOWN)) {
            return DOWN;
        }
        return null;
    }

    @Override
    public boolean isMove() {
        return Stream.of(MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT)
                .anyMatch(this::hasInput);
    }

}
