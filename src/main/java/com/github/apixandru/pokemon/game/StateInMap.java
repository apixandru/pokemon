/**
 *
 */
package com.github.apixandru.pokemon.game;

import static com.github.apixandru.pokemon.util.Constants.SCALE;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.apixandru.pokemon.ui.GameMap;
import com.github.apixandru.pokemon.ui.util.Camera;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class StateInMap extends BasicGameState {

	private GameMap gameMap;
	private Camera camera;

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(final GameContainer container, final StateBasedGame game) throws SlickException {
		gameMap = new GameMap();
		camera = new Camera(container.getWidth(), container.getHeight(), SCALE);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final GameContainer container, final StateBasedGame game, final Graphics g) throws SlickException {
		camera.translate(g, gameMap.player.position);
		gameMap.render(g);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(final GameContainer container, final StateBasedGame game, final int delta) throws SlickException {
		gameMap.update(container, delta);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	@Override
	public int getID() {
		return 0;
	}

}
