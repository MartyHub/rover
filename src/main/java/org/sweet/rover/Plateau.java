package org.sweet.rover;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private final int         maxX;
    private final int         maxY;
    private final List<Rover> rovers;

    public Plateau(final int maxX, final int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.rovers = new ArrayList<>();
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public void addRover(final Rover rover) {
        this.rovers.add(rover);
        this.validate(rover);
    }

    public void validate() {
        for (final Rover rover : this.rovers) {
            this.validate(rover);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Rover rover : this.rovers) {
            if (sb.length() > 0) {
                sb.append(System.getProperty("line.separator"));
            }
            sb.append(rover.toString());
        }
        return sb.toString();
    }

    private void validate(final Rover rover) {
        if (!rover.getPosition()
                  .validate(this)) {
            throw new RoverException("Rover %s has invalid position : %s", rover.getId(), rover.getPosition());
        }
    }
}
