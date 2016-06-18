package com.github.apixandru.pokemon.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.io.File;

/**
 *
 */

/**
 * @author Alexandru Bledea
 * @since May 17, 2015
 */
public final class Main {

    public static void main(final String[] args) throws SlickException {
        ensureLwjglIsLoaded();

        final AppGameContainer container = new AppGameContainer(new PokemonGame());
        container.setTargetFrameRate(60);
        container.setDisplayMode(500, 400, false);
        container.start();
    }

    private static void ensureLwjglIsLoaded() {
//      in intellij, make sure that the working dir is game and not parent
        final String natives = new File("natives").getAbsolutePath();
        System.setProperty("java.library.path", natives);
        System.setProperty("org.lwjgl.librarypath", natives);
    }

}
