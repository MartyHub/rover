package org.sweet.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class CommandFactory implements Iterable<Command> {

    private BufferedReader reader;

    public CommandFactory(final BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public Iterator<Command> iterator() {
        final String line = this.read();
        final CommandIterator result = new CommandIterator(line);
        return result;
    }

    private String read() {
        try {
            final String result = this.reader.readLine();
            if (result == null) {
                throw new RoverException("Missing command result");
            }
            return result;
        } catch (IOException e) {
            throw new RoverException("Failed to read command line", e);
        }
    }

    private static class CommandIterator implements Iterator<Command> {

        private final String line;
        private       int    index;

        public CommandIterator(final String line) {
            this.line = line;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.line.length();
        }

        @Override
        public Command next() {
            final Command result = this.parse(line.charAt(this.index));
            ++this.index;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Command parse(final char c) {
            for (final Command command : Command.values()) {
                if (command.name()
                           .charAt(0) == c) {
                    return command;
                }
            }
            throw RoverException.unknown(c);
        }
    }
}
