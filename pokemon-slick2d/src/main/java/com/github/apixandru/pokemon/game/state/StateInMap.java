/**
 *
 */
package com.github.apixandru.pokemon.game.state;

import com.apixandru.pokemon.model.MapEventListener;
import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.SpawnPoint;
import com.apixandru.pokemon.model.object.WarpPoint;
import com.apixandru.pokemon.slick2d.SlickPlayerSpriteProvider;
import com.github.apixandru.pokemon.ui.Player;
import com.github.apixandru.pokemon.ui.PokemonTiledMap;
import com.github.apixandru.pokemon.ui.util.Camera;
import com.github.apixandru.pokemon.ui.util.map.MapManager;
import com.github.apixandru.pokemon.ui.util.map.MapManagerImpl;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import static com.apixandru.pokemon.model.Constants.SCALE;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class StateInMap extends BasicGameState {

    public Player player;
    private PokemonTiledMap actualMap;
    private Camera camera;

    private MapManager mapManager;
    private StateBasedGame game;

    @Override
    public void init(final GameContainer container, final StateBasedGame game) throws SlickException {
        this.game = game;

        final CharacterSprites redSprites = CharacterSprites.load("resources/sprites/red.png");

        mapManager = new MapManagerImpl(new EventListener());
        this.actualMap = mapManager.getMap("ash_house_level1");

        final Character character = new Character(3, 6);
        character.setCurrentMap(actualMap.getModel().asCharacterMoveListener());

        this.player = new Player(character, new SlickPlayerSpriteProvider(redSprites));

        this.camera = new Camera(container.getWidth(), container.getHeight(), SCALE);
    }

    @Override
    public void render(final GameContainer container, final StateBasedGame game, final Graphics g) throws SlickException {
        this.camera.translate(g, this.player.getPosition());
        this.actualMap.render(0, 0);
        this.player.render(g);
    }

    @Override
    public void update(final GameContainer container, final StateBasedGame game, final int delta) throws SlickException {
        player.update(container, delta);

    }

    @Override
    public int getID() {
        return 0;
    }

    /**
     * @author Alexandru Bledea
     * @since Jun 14, 2015
     */
    private class EventListener implements MapEventListener {

        @Override
        public void onWarpPoint(final Character character, final WarpPoint warpPoint) {
            game.enterState(0, new FadeOutTransition(), new FadeInTransition() {

                @Override
                public void preRender(final StateBasedGame game, final GameContainer container, final Graphics g) {
                    actualMap = mapManager.getMap(warpPoint.destName);
                    character.setCurrentMap(actualMap.getModel().asCharacterMoveListener());
                    final SpawnPoint spawnPoint = mapManager.getSpawnPoint(warpPoint);
                    character.setLocation(spawnPoint);
                    player.reset();
                }
            });

        }

    }

}
