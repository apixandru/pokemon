/**
 *
 */
package com.github.apixandru.pokemon.game;

import com.github.apixandru.pokemon.game.state.StateInMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;

/**
 * @author Alexandru Bledea
 * @since Jun 12, 2015
 */
public class PokemonGame extends StateBasedGame {

    public PokemonGame() {
        super("Pokemon rip-off");
    }

    @Override
    public void initStatesList(final GameContainer container) throws SlickException {
        addState(new StateInMap());
        enterState(0, new FadeInTransition(), null);
    }

}
