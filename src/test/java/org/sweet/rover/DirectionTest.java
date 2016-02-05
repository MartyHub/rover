package org.sweet.rover;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testNorthLeft() {
        Assert.assertEquals(Direction.WEST, Direction.NORTH.process(Command.LEFT));
    }

    @Test
    public void testEastLeft() {
        Assert.assertEquals(Direction.NORTH, Direction.EAST.process(Command.LEFT));
    }

    @Test
    public void testSouthLeft() {
        Assert.assertEquals(Direction.EAST, Direction.SOUTH.process(Command.LEFT));
    }

    @Test
    public void testWestLeft() {
        Assert.assertEquals(Direction.SOUTH, Direction.WEST.process(Command.LEFT));
    }

    @Test
    public void testNorthRight() {
        Assert.assertEquals(Direction.EAST, Direction.NORTH.process(Command.RIGHT));
    }

    @Test
    public void testEastRight() {
        Assert.assertEquals(Direction.SOUTH, Direction.EAST.process(Command.RIGHT));
    }

    @Test
    public void testSouthRight() {
        Assert.assertEquals(Direction.WEST, Direction.SOUTH.process(Command.RIGHT));
    }

    @Test
    public void testWestRight() {
        Assert.assertEquals(Direction.NORTH, Direction.WEST.process(Command.RIGHT));
    }

    @Test
    public void testNorthMove() {
        Assert.assertEquals(Direction.NORTH, Direction.NORTH.process(Command.MOVE));
    }

    @Test
    public void testEastMove() {
        Assert.assertEquals(Direction.EAST, Direction.EAST.process(Command.MOVE));
    }

    @Test
    public void testSouthMove() {
        Assert.assertEquals(Direction.SOUTH, Direction.SOUTH.process(Command.MOVE));
    }

    @Test
    public void testWestMove() {
        Assert.assertEquals(Direction.WEST, Direction.WEST.process(Command.MOVE));
    }
}
