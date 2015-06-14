/**
 *
 */
package com.github.apixandru.pokemon.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;

import com.github.apixandru.pokemon.game.state.StateInMap;

/**
 * @author Alexandru Bledea
 * @since Jun 12, 2015
 */
public class PokemonGame extends StateBasedGame {

	/**
	 *
	 */
	public PokemonGame() {
		super("Pokemon rip-off");
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.GameContainer)
	 */
	@Override
	public void initStatesList(final GameContainer container) throws SlickException {
		addState(new StateInMap());
		enterState(0, new FadeInTransition(), null);
	}

}
