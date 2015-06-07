/**
 *
 */
package com.github.apixandru.pokemon.ui;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.github.apixandru.pokemon.ui.util.CanRender;

/**
 * @author Alexandru Bledea
 * @since Jun 4, 2015
 */
public class GameMap implements CanRender {

	private final TiledMap actualMap;

	/**
	 * @throws SlickException
	 */
	public GameMap() throws SlickException {
		this.actualMap = new TiledMap("resources/maps/ash_house.tmx");
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		actualMap.render(0, 0, 0, 0, 16, 16);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				g.drawRect(x * BLOCK_WIDTH, y * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
	}

}
