package com.apixandru.libgdx.state;

import com.apixandru.libgdx.util.GdxCanUpdate;
import com.apixandru.libgdx.util.Renderable;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Disposable;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public abstract class AbstractState implements Renderable, Disposable, GdxCanUpdate {

    protected final OrthographicCamera camera = new OrthographicCamera();
    private final StateManager stateManager;

    protected AbstractState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void dispose() {

    }

}
