package org.sweet.rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private final String fileName;

    public Main(final String fileName) {
        this.fileName = fileName;
    }

    public void run() throws IOException {
        try (final BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            final Scenario scenario = new Scenario(new PlateauFactory(reader), new RoverFactory(reader), new CommandFactory(reader));
            scenario.run();
        }
    }

    public static void main(final String[] args) throws IOException {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("usage: java input.txt");
        }
        new Main(args[0]).run();
    }
}
