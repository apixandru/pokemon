/**
 *
 */
package com.apixandru.pokemon.model.object;

import com.apixandru.pokemon.model.Constants.MoveDirection;

import static com.apixandru.pokemon.model.Constants.getDirectionModifier;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public final class Character {

    public MoveDirection moveDirection = MoveDirection.UP;

    private Point currentLocation;

    private int xDestination, yDestination;
    private WorldMap currentMap;

    public Character(final int x, final int y) {
        setCurrentLocation(new Point(x, y));
    }

    public boolean moveBegin(final MoveDirection moveDirection) {
        this.moveDirection = moveDirection;

        Point destination = getDirectionModifier(moveDirection).merge(currentLocation);

        if (currentMap.isBlocked(destination.x, destination.y)) {
            return false;
        }
        this.xDestination = destination.x;
        this.yDestination = destination.y;
        return true;
    }

    public void moveEnd() {
        setCurrentLocation(new Point(xDestination, yDestination));
        currentMap.characterMoveEnd(this);
    }

    public void setCurrentMap(final WorldMap currentMap) {
        this.currentMap = currentMap;
    }

    public Point getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(final Point newLocation) {
        this.currentLocation = new Point(newLocation);
    }

}
