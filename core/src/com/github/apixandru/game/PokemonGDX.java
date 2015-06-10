package com.github.apixandru.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PokemonGDX extends ApplicationAdapter {

	int width, height;

	ShapeRenderer renderer;
	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		final float deltaTime = Gdx.graphics.getDeltaTime();
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		renderer.begin();
		renderer.setColor(Color.WHITE);
		final int cols = width / 32 + 1;
		final int rows = height / 32 + 1;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				renderer.rect(i * 32, j * 32, 32, 32);
			}
		}
		renderer.end();
	}
}
