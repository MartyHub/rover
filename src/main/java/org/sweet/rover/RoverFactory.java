package org.sweet.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoverFactory implements Iterable<Rover> {

    private BufferedReader reader;

    public RoverFactory(final BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public Iterator<Rover> iterator() {
        final RoverIterator result = new RoverIterator();
        return result;
    }

    private class RoverIterator implements Iterator<Rover> {

        private int    index;
        private String line;

        @Override
        public boolean hasNext() {
            try {
                this.line = reader.readLine();
                return this.line != null;
            } catch (IOException e) {
                throw new RoverException("Failed to read rover line", e);
            }
        }

        @Override
        public Rover next() {
            final Matcher matcher = Pattern.compile("(\\d+) (\\d+) ([NESW])")
                                           .matcher(line);
            if (matcher.matches()) {
                final int x = Integer.parseInt(matcher.group(1));
                final int y = Integer.parseInt(matcher.group(2));
                final Position position = new Position(x, y);
                final Direction direction = this.toDirection(matcher.group(3));
                return new Rover(++this.index, position, direction);
            } else {
                throw new RoverException("Invalid rover line <%s>", line);
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Direction toDirection(final String s) {
            for (final Direction direction : Direction.values()) {
                if (String.valueOf(direction.name()
                                            .charAt(0))
                          .equals(s)) {
                    return direction;
                }
            }
            throw RoverException.unknown(s);
        }
    }
}
