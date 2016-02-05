package org.sweet.rover;

import java.io.IOException;

public class Scenario {

    private final PlateauFactory plateauFactory;
    private final RoverFactory   roverFactory;
    private final CommandFactory commandFactory;

    public Scenario(final PlateauFactory plateauFactory, final RoverFactory roverFactory, final CommandFactory commandFactory) {
        this.plateauFactory = plateauFactory;
        this.roverFactory = roverFactory;
        this.commandFactory = commandFactory;
    }

    public void run() throws IOException {
        final Plateau plateau = this.plateauFactory.getPlateau();
        for (final Rover rover : this.roverFactory) {
            plateau.addRover(rover);
            new Exploration(plateau, rover, this.commandFactory).run();
        }
        System.out.println(plateau);
    }
}
