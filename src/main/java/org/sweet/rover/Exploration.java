package org.sweet.rover;

public class Exploration {

    private final Plateau        plateau;
    private final Rover          rover;
    private final CommandFactory commandFactory;

    public Exploration(final Plateau plateau, final Rover rover, final CommandFactory commandFactory) {
        this.plateau = plateau;
        this.rover = rover;
        this.commandFactory = commandFactory;
    }

    public void run() {
        for (final Command command : this.commandFactory) {
            rover.process(command);
            plateau.validate();
        }
    }
}
