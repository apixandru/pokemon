package com.apixandru.pokemon;

import com.apixandru.libgdx.state.StateManager;
import com.apixandru.pokemon.state.StateMap;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.apixandru.libgdx.util.GdxUtils.disposeAll;

public class Pokemon extends ApplicationAdapter {

    private final StateManager stateManager = new StateManager();

    private SpriteBatch spriteBatch;

    @Override
    public void create() {

        stateManager.enterState(new StateMap(stateManager));

        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stateManager.update(Gdx.graphics.getDeltaTime());
        stateManager.render(spriteBatch);

    }

    @Override
    public void dispose() {
        disposeAll(stateManager, spriteBatch);
    }
}
