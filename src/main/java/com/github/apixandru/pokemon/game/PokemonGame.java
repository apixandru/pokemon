/**
 *
 */
package com.github.apixandru.pokemon.game;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.github.apixandru.pokemon.ui.GameMap;
import com.github.apixandru.pokemon.ui.Player;
import com.github.apixandru.pokemon.ui.util.Camera;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;

/**
 * @author Alexandru Bledea
 * @since Jun 3, 2015
 */
public class PokemonGame extends BasicGame {

	private Player player;
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
		final CharacterSprites redSprites = CharacterSprites.load("resources/sprites/red.png");
		gameMap = new GameMap();
		player = new Player(new Vector2f(3 * BLOCK_WIDTH, 6 * BLOCK_HEIGHT), redSprites);
		camera = new Camera(container.getWidth(), container.getHeight());
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final GameContainer container, final Graphics g) throws SlickException {
		camera.translate(g, player.position);
		gameMap.render(g);
		camera.translate(g, player.position);
		player.render(g);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) throws SlickException {
		player.update(container, delta);
	}

}
