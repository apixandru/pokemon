package com.apixandru.pokemon.state;

import com.apixandru.libgdx.state.AbstractState;
import com.apixandru.libgdx.state.StateManager;
import com.apixandru.libgdx.util.GdxAnimation;
import com.apixandru.libgdx.util.GdxRenderer;
import com.apixandru.pokemon.model.Constants.MoveDirection;
import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.model.object.Point;
import com.apixandru.pokemon.sprite.Sprites;
import com.apixandru.pokemon.ui.object.Player;
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

    private final Player<GdxRenderer, Float> player;

    public StateMap(StateManager stateManager) {
        super(stateManager);
        camera.setToOrtho(false, 166, 133);

        final Character character = new Character(new Point(3, 6));
        this.player = new Player<>(character, sprites.spriteProvider);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        player.render(new GdxRenderer(spriteBatch), FloatingPoint.ZERO);
        spriteBatch.draw(textureRegion, 0, 0);
        spriteBatch.end();
    }

    @Override
    public void update(MoveInput moveInput, Float delta) {

//        player.update(moveInput, delta);

        if (moveInput.isMove()) {
            MoveDirection moveDirection = moveInput.getMoveDirection();
            this.moveDirection = moveDirection;
            GdxAnimation moving = sprites.spriteProvider.getMoving(moveDirection);
            moving.update(moveInput, delta);
            textureRegion = moving.getCurrentFrame();
        } else {
            textureRegion = sprites.spriteProvider.getStanding(moveDirection).image;
        }
    }

}
