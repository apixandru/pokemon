package com.apixandru.pokemon.state;

import com.apixandru.libgdx.state.AbstractState;
import com.apixandru.libgdx.state.StateManager;
import com.apixandru.libgdx.util.Animation;
import com.apixandru.pokemon.sprite.Sprites;
import com.apixandru.pokemon.ui.MoveInput;
import com.apixandru.pokemon.ui.UiConstants;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class StateMap extends AbstractState {

    private final Sprites sprites = new Sprites();
    private final Animation animation = sprites.sprites.moving.get(UiConstants.DIRECTION_RIGHT);

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
    public void update(MoveInput moveInput, Float delta) {
        animation.update(moveInput, delta);
    }

}
