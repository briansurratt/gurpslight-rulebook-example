package com.github.briansurratt.rps;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RpsTest {

    private RpsGame _game;

    @Before
    public void setUp() throws Exception {
//        _game = new ImperativeGameImpl();
        _game = new RpsRuleBookImpl();
    }

    @Test
    public void when_paper_v_paper_then_result_is_a_tie() throws Exception {
        Outcome outcome = _game.play(Throw.Paper, Throw.Paper);
        assertEquals(Outcome.Tie, outcome);
    }

    @Test
    public void when_paper_v_rock_then_result_player_1_wins() throws Exception {
        Outcome outcome = _game.play(Throw.Paper, Throw.Rock);
        assertEquals(Outcome.Player1Wins, outcome);
    }

    @Test
    public void when_rock_v_sisscors_then_result_player_1_wins() throws Exception {
        Outcome outcome = _game.play(Throw.Rock, Throw.Scissors);
        assertEquals(Outcome.Player1Wins, outcome);
    }

    @Test
    public void when_scissors_v_paper_then_result_player_1_wins() throws Exception {
        Outcome outcome = _game.play(Throw.Scissors, Throw.Paper);
        assertEquals(Outcome.Player1Wins, outcome);
    }

    @Test
    public void when_rock_v_paper_then_result_player_2_wins() throws Exception {
        Outcome outcome = _game.play(Throw.Rock, Throw.Paper);
        assertEquals(Outcome.Player2Wins, outcome);
    }

    @Test
    public void when_scissors_v_rock_then_result_player_2_wins() throws Exception {
        Outcome outcome = _game.play(Throw.Scissors, Throw.Rock);
        assertEquals(Outcome.Player2Wins, outcome);
    }

    @Test
    public void when_paper_v_scissors_then_result_player_2_wins() throws Exception {
        Outcome outcome = _game.play(Throw.Paper, Throw.Scissors);
        assertEquals(Outcome.Player2Wins, outcome);
    }

}
