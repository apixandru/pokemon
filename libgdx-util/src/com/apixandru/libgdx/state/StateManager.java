package com.apixandru.libgdx.state;

import com.apixandru.libgdx.util.Renderable;
import com.apixandru.libgdx.util.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class StateManager implements Updatable, Renderable, Disposable {

    private final Deque<AbstractState> states = new LinkedList<>();

    @Override
    public void update(float delta) {
        getCurrentState().update(delta);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        getCurrentState().render(spriteBatch);
    }

    public void enterState(AbstractState state) {
        states.push(state);
    }

    public void exitState() {
        states.pop().dispose();
    }

    public void switchState(AbstractState state) {
        exitState();
        enterState(state);
    }

    private AbstractState getCurrentState() {
        return states.peek();
    }

    @Override
    public void dispose() {
        while (states.isEmpty()) {
            exitState();
        }
    }

}
