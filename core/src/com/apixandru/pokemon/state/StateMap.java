package com.apixandru.pokemon.state;

import com.apixandru.libgdx.state.AbstractState;
import com.apixandru.libgdx.state.StateManager;
import com.apixandru.libgdx.util.Animation;
import com.apixandru.pokemon.sprite.Sprites;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.apixandru.pokemon.util.Constants;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class StateMap extends AbstractState {

    private final Sprites sprites = new Sprites();
    private final Animation animation = sprites.sprites.moving.get(Constants.DIRECTION_RIGHT);

    public StateMap(StateManager stateManager) {
        super(stateManager);
        camera.setToOrtho(false, 166, 133);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(animation.getCurrentFrame(), 0, 0);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        animation.update(delta);
    }

}
