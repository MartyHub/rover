package org.sweet.rover;

public class Position {

    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Position move(final Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(x, y + 1);
            case EAST:
                return new Position(x + 1, y);
            case SOUTH:
                return new Position(x, y - 1);
            case WEST:
                return new Position(x - 1, y);
            default:
                throw RoverException.unknown(direction);
        }
    }

    public boolean validate(final Plateau plateau) {
        return this.x >= 0 && this.x <= plateau.getMaxX() && this.y >= 0 && this.y <= plateau.getMaxY();
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.x, this.y);
    }
}
