package software.surratt.rps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockBeatsScissorsRuleTest {

    @Test
    public void when_returns_true_when_p1_is_rock_and_p2_is_sisscors() throws Exception {
        final RockBeatsScissorsRule rule = new RockBeatsScissorsRule();
        rule.player1Throw = Throw.Rock;
        rule.player2Throw = Throw.Scissors;
        assertEquals(true, rule.when());

    }

    @Test
    public void when_returns_true_when_p1_is_scissors_and_p2_is_rock() throws Exception {
        final RockBeatsScissorsRule rule = new RockBeatsScissorsRule();
        rule.player1Throw = Throw.Scissors;
        rule.player2Throw = Throw.Rock;
        assertEquals(true, rule.when());
    }

    @Test
    public void result_is_player1wins_for_rock_v_scissors() throws Exception {
        final RockBeatsScissorsRule rule = new RockBeatsScissorsRule();
        rule.player1Throw = Throw.Rock;
        rule.player2Throw = Throw.Scissors;
        rule.then();
        assertEquals(Outcome.Player1Wins, rule.outcome);
    }

    @Test
    public void result_is_player2wins_for_scissors_v_rock() throws Exception {
        final RockBeatsScissorsRule rule = new RockBeatsScissorsRule();
        rule.player1Throw = Throw.Scissors;
        rule.player2Throw = Throw.Rock;
        rule.then();
        assertEquals(Outcome.Player2Wins, rule.outcome);
    }

}
