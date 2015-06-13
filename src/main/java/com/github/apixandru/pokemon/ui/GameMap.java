/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.github.apixandru.pokemon.ui.util.CanRender;
import com.github.apixandru.pokemon.ui.util.CanUpdate;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;

/**
 * @author Alexandru Bledea
 * @since Jun 4, 2015
 */
public class GameMap implements CanRender, CanUpdate {

	private final PokemonTiledMap actualMap;
	public final Player player;

	/**
	 * @throws SlickException
	 */
	public GameMap() throws SlickException {
		final CharacterSprites redSprites = CharacterSprites.load("resources/sprites/red.png");

		this.actualMap = new PokemonTiledMap("resources/maps/ash_house.tmx");

		this.player = new Player(3, 6, redSprites, actualMap.getModel());
	}


	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		actualMap.render(0, 0);
//		for (int x = 0; x < 10; x++) {
//			for (int y = 0; y < 10; y++) {
//				g.drawRect(x * BLOCK_WIDTH, y * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
//			}
//		}
		this.player.render(g);
	}

	/**
	 * @param container
	 * @param game
	 * @param delta
	 */
	public void update(final GameContainer container, final StateBasedGame game, final int delta) {
		player.update(container, game, delta);
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) {
		throw new IllegalStateException("Should be replaced by the update with game");
	}

}
