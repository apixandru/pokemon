/**
 *
 */
package com.github.apixandru.pokemon.ui;

import static com.github.apixandru.pokemon.util.Constants.BLOCK_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.BLOCK_WIDTH;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.github.apixandru.pokemon.model.PokemonMap;
import com.github.apixandru.pokemon.ui.util.CanRender;
import com.github.apixandru.pokemon.ui.util.CanUpdate;
import com.github.apixandru.pokemon.ui.util.sprites.CharacterSprites;

/**
 * @author Alexandru Bledea
 * @since Jun 4, 2015
 */
public class GameMap implements CanRender, CanUpdate {

	private final PokemonTiledMap actualMap;
	private final PokemonMap mapModel;
	public final Player player;

	/**
	 * @throws SlickException
	 */
	public GameMap() throws SlickException {
		final CharacterSprites redSprites = CharacterSprites.load("resources/sprites/red.png");

		this.actualMap = new PokemonTiledMap("resources/maps/ash_house.tmx");

		this.mapModel = new PokemonMap(actualMap.getWidth(), actualMap.getHeight());
		this.player = new Player(new Vector2f(3 * BLOCK_WIDTH, 6 * BLOCK_HEIGHT), redSprites, mapModel);
		initializeBlocked(actualMap.getWidth(), actualMap.getHeight());
	}

	/**
	 * @param numTilesX
	 * @param numTilesY
	 */
	private void initializeBlocked(final int numTilesX, final int numTilesY) {
		final int layerId = actualMap.getLayerIndex("stuff");
		if (-1 == layerId) {
			return;
		}
		for (int x = 0; x < numTilesX; x++) {
			for (int y = 0; y < numTilesY; y++) {
				if (actualMap.getTileId(x, y, layerId) != 0) {
					mapModel.block(x, y);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanRender#render(org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(final Graphics g) {
		actualMap.render(0, 0, 0, 0, 16, 16);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				g.drawRect(x * BLOCK_WIDTH, y * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
		this.player.render(g);
	}

	/* (non-Javadoc)
	 * @see com.github.apixandru.pokemon.ui.util.CanUpdate#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(final GameContainer container, final int delta) {
		player.update(container, delta);
	}

}
