package com.apixandru.pokemon.slick2d.input;

import com.apixandru.pokemon.model.input.Input;
import com.apixandru.pokemon.model.input.InputProvider;
import com.apixandru.pokemon.model.input.UserInput;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static com.apixandru.pokemon.model.input.Input.MOVE_DOWN;
import static com.apixandru.pokemon.model.input.Input.MOVE_LEFT;
import static com.apixandru.pokemon.model.input.Input.MOVE_RIGHT;
import static com.apixandru.pokemon.model.input.Input.MOVE_UP;
import static org.newdawn.slick.Input.KEY_DOWN;
import static org.newdawn.slick.Input.KEY_LEFT;
import static org.newdawn.slick.Input.KEY_RIGHT;
import static org.newdawn.slick.Input.KEY_UP;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 24, 2016
 */
public final class SlickInputProvider implements InputProvider {

    private static final Map<Input, Integer> INPUT_MAPPER = createInputMap();

    private final org.newdawn.slick.Input input;

    private SlickInputProvider(final org.newdawn.slick.Input input) {
        this.input = input;
    }

    private static Map<Input, Integer> createInputMap() {
        Map<Input, Integer> inputMap = new EnumMap<>(Input.class);
        inputMap.put(MOVE_LEFT, KEY_LEFT);
        inputMap.put(MOVE_RIGHT, KEY_RIGHT);
        inputMap.put(MOVE_UP, KEY_UP);
        inputMap.put(MOVE_DOWN, KEY_DOWN);
        return Collections.unmodifiableMap(inputMap);
    }

    public static UserInput inputFrom(org.newdawn.slick.Input input) {
        return new UserInput(new SlickInputProvider(input));
    }

    @Override
    public boolean hasInput(Input input) {
        if (!INPUT_MAPPER.containsKey(input)) {
            return false;
        }
        int slickCode = INPUT_MAPPER.get(input);
        return this.input.isKeyDown(slickCode);
    }

}
