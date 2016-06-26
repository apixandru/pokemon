package com.apixandru.pokemon.ui.render;

import com.apixandru.pokemon.ui.CanUpdate;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public interface Animation<R extends Renderer, D extends Number> extends Image<R>, CanUpdate<D> {

    void reset();

}
