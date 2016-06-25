package com.apixandru.pokemon.ui.render;

import com.apixandru.pokemon.model.object.FloatingPoint;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public interface CanRender<R extends Renderer> {

    void render(R renderer, FloatingPoint floatingPoint);

}
