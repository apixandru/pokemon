package com.apixandru.pokemon.state;

import com.apixandru.libgdx.state.AbstractState;
import com.apixandru.libgdx.state.StateManager;
import com.apixandru.libgdx.util.GdxRenderer;
import com.apixandru.pokemon.model.input.MoveInput;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.FloatingPoint;
import com.apixandru.pokemon.model.object.Point;
import com.apixandru.pokemon.model.object.WorldMap;
import com.apixandru.pokemon.sprite.Sprites;
import com.apixandru.pokemon.ui.object.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public class StateMap extends AbstractState {

    private final Sprites sprites = new Sprites();

    private final Player<GdxRenderer, Float> player;

    public StateMap(StateManager stateManager) {
        super(stateManager);
        camera.setToOrtho(false, 166, 133);

        final Character character = new Character(new Point(3, 6));
        this.player = new Player<>(character, sprites.spriteProvider, 36F);
        character.setCurrentMap(new WorldMap() {
            @Override
            public void characterMoveEnd(Character character) {

            }

            @Override
            public boolean isBlocked(int x, int y) {
                return false;
            }
        });

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        player.render(new GdxRenderer(spriteBatch), FloatingPoint.ZERO);
        spriteBatch.end();
    }

    @Override
    public void update(MoveInput moveInput, Float delta) {
        player.update(moveInput, delta);
    }

}
