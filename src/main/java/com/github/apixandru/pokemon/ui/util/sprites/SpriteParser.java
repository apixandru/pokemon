/**
 *
 */
package com.github.apixandru.pokemon.ui.util.sprites;

import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SPRITE_HEIGHT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SPRITE_WIDTH;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * @author Alexandru Bledea
 * @since Jun 6, 2015
 */
public class SpriteParser {


	/**
	 * @param resource
	 * @return
	 * @throws SlickException
	 */
	public static SpriteSheet loadSpriteSheet(final String resource) throws SlickException {
		final Image image = new Image(resource);
		image.setFilter(Image.FILTER_NEAREST);
		return new SpriteSheet(image, SPRITE_WIDTH, SPRITE_HEIGHT);

	}

}