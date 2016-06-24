package com.apixandru.pokemon.state;

import com.apixandru.libgdx.state.AbstractState;
import com.apixandru.libgdx.state.StateManager;
import com.apixandru.libgdx.util.Animation;
import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.sprite.Sprites;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.apixandru.pokemon.model.Constants.MoveDirection.DOWN;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class StateMap extends AbstractState {

    private final Sprites sprites = new Sprites();
    private MoveDirection moveDirection = DOWN;
    private TextureRegion textureRegion;

    public StateMap(StateManager stateManager) {
        super(stateManager);
        camera.setToOrtho(false, 166, 133);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(textureRegion, 0, 0);
        spriteBatch.end();
    }

    @Override
    public void update(MoveInput moveInput, Float delta) {
        if (moveInput.isMove()) {
            MoveDirection moveDirection = moveInput.getMoveDirection();
            this.moveDirection = moveDirection;
            Animation moving = sprites.spriteProvider.getMoving(moveDirection);
            moving.update(moveInput, delta);
            textureRegion = moving.getCurrentFrame();
        } else {
            textureRegion = sprites.spriteProvider.getStanding(moveDirection);
        }
    }

}
