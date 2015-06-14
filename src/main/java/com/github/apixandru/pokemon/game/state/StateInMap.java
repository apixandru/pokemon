/**
 *
 */
package com.github.apixandru.pokemon.game.state;

import static com.github.apixandru.pokemon.util.Constants.SCALE;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.github.apixandru.pokemon.model.MapEventListener;
import com.github.apixandru.pokemon.model.object.Character;
import com.github.apixandru.pokemon.model.object.WarpPoint;
import com.github.apixandru.pokemon.ui.Player;
import com.github.apixandru.pokemon.ui.PokemonTiledMap;
import com.github.apixandru.pokemon.ui.util.Camera;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class StateInMap extends BasicGameState {

	private PokemonTiledMap actualMap;
	public Player player;
	private Camera camera;

	private StateBasedGame game;

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(final GameContainer container, final StateBasedGame game) throws SlickException {
		this.game = game;

		final CharacterSprites redSprites = CharacterSprites.load("resources/sprites/red.png");

		this.actualMap = new PokemonTiledMap("resources/maps/ash_house.tmx", new EventListener());

		final Character character = new Character(3, 6);
		character.setCurrentMap(actualMap.getModel().asCharacterMoveListener());

		this.player = new Player(character, redSprites);

		this.camera = new Camera(container.getWidth(), container.getHeight(), SCALE);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final GameContainer container, final StateBasedGame game, final Graphics g) throws SlickException {
		this.camera.translate(g, this.player.getPosition());
		this.actualMap.render(0, 0);
		this.player.render(g);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(final GameContainer container, final StateBasedGame game, final int delta) throws SlickException {
		player.update(container, delta);

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	@Override
	public int getID() {
		return 0;
	}

	/**
	 * @author Alexandru Bledea
	 * @since Jun 14, 2015
	 */
	private class EventListener implements MapEventListener {

		/* (non-Javadoc)
		 * @see com.github.apixandru.pokemon.model.MapEventListener#onWarpPoint(com.github.apixandru.pokemon.model.object.Character, com.github.apixandru.pokemon.model.object.WarpPoint)
		 */
		@Override
		public void onWarpPoint(final Character character, final WarpPoint warpPoint) {
			game.enterState(0, new FadeOutTransition(), new FadeInTransition() {

				/* (non-Javadoc)
				 * @see org.newdawn.slick.state.transition.FadeInTransition#preRender(org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
				 */
				@Override
				public void preRender(final StateBasedGame game, final GameContainer container, final Graphics g) {
					character.xCurrent = 3;
					character.yCurrent = 6;
					player.reset();
				}
			});

		}

	}

}
