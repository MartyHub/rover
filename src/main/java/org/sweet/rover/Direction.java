package org.sweet.rover;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction process(final Command command) {
        switch (command) {
            case LEFT:
                return process(-1);
            case RIGHT:
                return process(1);
            case MOVE:
                return this;
            default:
                throw RoverException.unknown(command);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(name().charAt(0));
    }

    private Direction process(final int increment) {
        final int index = (ordinal() + 4 + increment) % 4;
        final Direction result = Direction.values()[index];
        return result;
    }
}
