package com.github.apixandru.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.apixandru.game.PokemonGDX;

/**
 * @author Alexandru Bledea
 * @since Jun 10, 2015
 */
public final class DesktopLauncher {

	/**
	 * @param arg
	 */
	@SuppressWarnings ("unused")
	public static void main(final String[] arg) {
		final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new PokemonGDX(), config);
	}

}
