package software.surratt.rps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TieRuleTest  {

    @Test
    public void paper_v_paper_when_returns_true() throws Exception {

        TieRule rule = new TieRule();
        rule.player1Throw = Throw.Paper;
        rule.player2Throw = Throw.Paper;

        assertEquals(true, rule.when());

    }

    @Test
    public void rock_v_rock_when_returns_true() throws Exception {
        TieRule rule = new TieRule();
        rule.player1Throw = Throw.Rock;
        rule.player2Throw = Throw.Rock;

        assertEquals(true, rule.when());
    }

    @Test
    public void scissors_v_scissors_when_returns_true() throws Exception {
        TieRule rule = new TieRule();
        rule.player1Throw = Throw.Scissors;
        rule.player2Throw = Throw.Scissors;

        assertEquals(true, rule.when());
    }

    @Test
    public void scissors_v_rock_when_returns_false() throws Exception {
        TieRule rule = new TieRule();
        rule.player1Throw = Throw.Scissors;
        rule.player2Throw = Throw.Rock;

        assertEquals(false, rule.when());
    }

    @Test
    public void then_sets_outcome_to_tie() throws Exception {
        TieRule rule = new TieRule();
        rule.then();
        assertEquals(Outcome.Tie, rule.outcome);
    }
    // @todo how to test 1 != 2 without having 6 combinations?

}
