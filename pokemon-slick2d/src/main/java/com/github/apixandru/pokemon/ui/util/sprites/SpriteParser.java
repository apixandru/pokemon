/**
 *
 */
package com.github.apixandru.pokemon.ui.util.sprites;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import static com.apixandru.pokemon.ui.UiConstants.BLOCK_HEIGHT;
import static com.apixandru.pokemon.ui.UiConstants.BLOCK_WIDTH;

/**
 * @author Alexandru Bledea
 * @since Jun 6, 2015
 */
public class SpriteParser {

    public static SpriteSheet loadSpriteSheet(final String resource) throws SlickException {
        final Image image = new Image(resource, Color.white);
        image.setFilter(Image.FILTER_NEAREST);
        return new SpriteSheet(image, BLOCK_WIDTH, BLOCK_HEIGHT);

    }

}
