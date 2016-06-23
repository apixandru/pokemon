package com.apixandru.pokemon.input;

import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.ui.MoveInput;

import static com.apixandru.pokemon.model.Constants.MoveDirection.DOWN;
import static com.apixandru.pokemon.model.Constants.MoveDirection.LEFT;
import static com.apixandru.pokemon.model.Constants.MoveDirection.RIGHT;
import static com.apixandru.pokemon.model.Constants.MoveDirection.UP;
import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys.DPAD_DOWN;
import static com.badlogic.gdx.Input.Keys.DPAD_LEFT;
import static com.badlogic.gdx.Input.Keys.DPAD_RIGHT;
import static com.badlogic.gdx.Input.Keys.DPAD_UP;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 22, 2016
 */
public final class GdxMoveInput implements MoveInput {

    public static GdxMoveInput INSTANCE = new GdxMoveInput();

    private GdxMoveInput() {
    }

    @Override
    public MoveDirection getMoveDirection() {
        if (input.isKeyPressed(DPAD_LEFT)) {
            return LEFT;
        } else if (input.isKeyPressed(DPAD_RIGHT)) {
            return RIGHT;
        } else if (input.isKeyPressed(DPAD_UP)) {
            return UP;
        } else if (input.isKeyPressed(DPAD_DOWN)) {
            return DOWN;
        }
        return null;
    }

}
