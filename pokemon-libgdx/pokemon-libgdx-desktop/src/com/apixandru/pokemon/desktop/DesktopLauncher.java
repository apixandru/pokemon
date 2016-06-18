package com.apixandru.pokemon.desktop;

import com.apixandru.pokemon.Pokemon;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 500;
        config.height = 400;
        new LwjglApplication(new Pokemon(), config);
    }
}
