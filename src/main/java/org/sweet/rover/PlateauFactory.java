package org.sweet.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlateauFactory {

    private BufferedReader reader;

    public PlateauFactory(final BufferedReader reader) {
        this.reader = reader;
    }

    public Plateau getPlateau() throws IOException {
        final String line = this.read();
        final Plateau result = this.parse(line);
        return result;
    }

    private String read() throws IOException {
        final String result = this.reader.readLine();
        if (result == null) {
            throw new RoverException("Missing plateau result");
        }
        return result;
    }

    private Plateau parse(final String line) {
        final Matcher matcher = Pattern.compile("(\\d+) (\\d+)")
                                       .matcher(line);
        if (matcher.matches()) {
            final int maxX = Integer.parseInt(matcher.group(1));
            final int maxY = Integer.parseInt(matcher.group(2));
            return new Plateau(maxX, maxY);
        } else {
            throw new RoverException("Invalid plateau line <%s>", line);
        }
    }
}
