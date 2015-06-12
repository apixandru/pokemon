package com.github.apixandru.pokemon.game;

/**
 *
 */

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * @author Alexandru Bledea
 * @since May 17, 2015
 */
public final class Main {

	/**
	 * @param args
	 * @throws SlickException
	 */
	public static void main(final String[] args) throws SlickException {
		final AppGameContainer container = new AppGameContainer(new PokemonGameOld());
		container.setTargetFrameRate(60);
		container.setDisplayMode(500, 400, false);
		container.start();
	}

}
