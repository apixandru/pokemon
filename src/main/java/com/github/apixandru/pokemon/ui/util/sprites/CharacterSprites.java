/**
 *
 */
package com.github.apixandru.pokemon.ui.util.sprites;

import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_DOWN;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_LEFT;
import static com.github.apixandru.pokemon.ui.util.sprites.SpriteConstants.SITTING_UP;

import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * @author Alexandru Bledea
 * @since Jun 6, 2015
 */
public final class CharacterSprites {

	public final List<Image> notMoving;

	/**
	 * @param spriteSheet
	 */
	private CharacterSprites(final SpriteSheet spriteSheet) {
		this.notMoving = Arrays.asList(
				spriteSheet.getSprite(0, SITTING_UP),
				spriteSheet.getSprite(0, SITTING_LEFT).getFlippedCopy(true, false),
				spriteSheet.getSprite(0, SITTING_DOWN),
				spriteSheet.getSprite(0, SITTING_LEFT));
	}

	/**
	 * @throws SlickException
	 */
	public static CharacterSprites load(final String image) throws SlickException {
		final SpriteSheet spriteSheet = SpriteParser.loadSpriteSheet(image);
		return new CharacterSprites(spriteSheet);
	}

}
