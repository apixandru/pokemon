/**
 *
 */
package com.github.apixandru.pokemon.game;

import static com.github.apixandru.pokemon.util.Constants.SCALE;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.github.apixandru.pokemon.ui.GameMap;
import com.github.apixandru.pokemon.ui.util.Camera;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class PokemonGame extends BasicGame {

	private GameMap gameMap;
	private Camera camera;

	/**
	 *
	 */
	public PokemonGame() {
		super("Pokemon");
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
	 */
	@Override
	public void init(final GameContainer container) throws SlickException {
		gameMap = new GameMap();
		camera = new Camera(container.getWidth(), container.getHeight(), SCALE);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final GameContainer container, final Graphics g) throws SlickException {
		camera.translate(g, gameMap.player.position);
		gameMap.render(g);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) throws SlickException {
		gameMap.update(container, delta);
	}

}
