package com.apixandru.pokemon.ui;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 21, 2016
 */
public interface CanUpdate<D> {

    void update(MoveInput moveInput, D delta);

}
