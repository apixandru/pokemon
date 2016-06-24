package com.apixandru.pokemon.ui;

import com.apixandru.pokemon.model.input.MoveInput;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 21, 2016
 */
public interface CanUpdate<D> {

    void update(MoveInput moveInput, D delta);

}
