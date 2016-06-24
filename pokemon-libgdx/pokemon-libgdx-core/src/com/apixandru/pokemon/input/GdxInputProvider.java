package com.apixandru.pokemon.input;

import com.apixandru.pokemon.model.input.Input;
import com.apixandru.pokemon.model.input.InputProvider;
import com.apixandru.pokemon.model.input.UserInput;
import com.badlogic.gdx.Gdx;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static com.apixandru.pokemon.model.input.Input.MOVE_DOWN;
import static com.apixandru.pokemon.model.input.Input.MOVE_LEFT;
import static com.apixandru.pokemon.model.input.Input.MOVE_RIGHT;
import static com.apixandru.pokemon.model.input.Input.MOVE_UP;
import static com.badlogic.gdx.Input.Keys.DPAD_DOWN;
import static com.badlogic.gdx.Input.Keys.DPAD_LEFT;
import static com.badlogic.gdx.Input.Keys.DPAD_RIGHT;
import static com.badlogic.gdx.Input.Keys.DPAD_UP;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 23, 2016
 */
public final class GdxInputProvider implements InputProvider {

    public static final UserInput USER_INPUT = new UserInput(new GdxInputProvider());

    private static final Map<Input, Integer> INPUT_MAPPER = createInputMap();

    private GdxInputProvider() {
    }

    private static Map<Input, Integer> createInputMap() {
        Map<Input, Integer> inputMap = new EnumMap<>(Input.class);
        inputMap.put(MOVE_LEFT, DPAD_LEFT);
        inputMap.put(MOVE_RIGHT, DPAD_RIGHT);
        inputMap.put(MOVE_UP, DPAD_UP);
        inputMap.put(MOVE_DOWN, DPAD_DOWN);
        return Collections.unmodifiableMap(inputMap);
    }

    @Override
    public boolean hasInput(Input input) {
        if (!INPUT_MAPPER.containsKey(input)) {
            return false;
        }
        int gdxCode = INPUT_MAPPER.get(input);
        return Gdx.input.isKeyPressed(gdxCode);
    }

}
