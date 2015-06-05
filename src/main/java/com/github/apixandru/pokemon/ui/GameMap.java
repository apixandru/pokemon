/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.Graphics;

import com.github.apixandru.pokemon.ui.util.CanRender;

/**
 * @author Alexandru Bledea
 * @since Jun 4, 2015
 */
public class GameMap implements CanRender {

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				g.drawRect(x * 32, y * 32, 32, 32);
			}
		}
	}

}
