package com.github.apixandru.pokemon.game;

import java.io.File;

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
		String natives = new File("target/natives").getAbsolutePath();
		System.setProperty("java.library.path", "target");
		System.setProperty("org.lwjgl.librarypath", natives);
		final AppGameContainer container = new AppGameContainer(new PokemonGame());
		container.setTargetFrameRate(60);
		container.setDisplayMode(500, 400, false);
		container.start();
	}

}
