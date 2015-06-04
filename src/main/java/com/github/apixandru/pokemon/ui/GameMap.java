/**
 *
 */
package com.github.apixandru.pokemon.ui;

import org.newdawn.slick.Graphics;

import com.github.apixandru.pokemon.ui.util.CanRender;
import com.github.apixandru.pokemon.ui.util.CanUpdate;

/**
 * @author Alexandru Bledea
 * @since Jun 4, 2015
 */
public class GameMap implements CanRender, CanUpdate {

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(int)
	 */
	@Override
	public void update(final int delta) {

	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.drawRect(i * 32, 0, 32, 32);
		}
	}

}
