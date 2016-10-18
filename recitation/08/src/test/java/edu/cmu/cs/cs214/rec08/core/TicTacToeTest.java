package edu.cmu.cs.cs214.rec08.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import static edu.cmu.cs.cs214.rec08.core.TicTacToe.Player;
import edu.cmu.cs.cs214.rec08.core.TicTacToe;
import edu.cmu.cs.cs214.rec08.core.TicTacToeImpl;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToeImpl();
    }

    @Test
    public void testSingleMove() {
        game.startNewGame();
        assertNull(game.getSquare(0, 0));
        game.playMove(0, 0);
        assertEquals(Player.X, game.getSquare(0, 0));
    }

	// TODO: write more tests
}
