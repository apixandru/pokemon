/**
 *
 */
package com.github.apixandru.pokemon.game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.github.apixandru.pokemon.ui.GameMap;
import com.github.apixandru.pokemon.ui.Player;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class PokemonGame extends BasicGame {

	private Player player;
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
		player = new Player(new Vector2f(48, 48));
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final GameContainer container, final Graphics g) throws SlickException {
		gameMap.render(g);
		player.render(g);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) throws SlickException {
	}

}
