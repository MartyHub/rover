package org.sweet.rover;

public class Rover {

    private int       id;
    private Position  position;
    private Direction direction;

    public Rover(final int id, final Position position, final Direction direction) {
        this.id = id;
        this.position = position;
        this.direction = direction;
    }

    public int getId() {
        return this.id;
    }

    public Position getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void process(final Command command) {
        if (command == Command.MOVE) {
            this.move();
        } else {
            this.rotate(command);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.position, this.direction);
    }

    private void move() {
        this.position = this.position.move(this.direction);
    }

    private void rotate(final Command command) {
        this.direction = this.direction.process(command);
    }
}
