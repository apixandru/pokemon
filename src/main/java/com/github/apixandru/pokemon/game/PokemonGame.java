/**
 *
 */
package com.github.apixandru.pokemon.game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.github.apixandru.pokemon.ui.GameMap;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class PokemonGame extends BasicGame {

	private GameMap gameMap;

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
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final GameContainer container, final Graphics g) throws SlickException {
		gameMap.render(g);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) throws SlickException {
	}

}
