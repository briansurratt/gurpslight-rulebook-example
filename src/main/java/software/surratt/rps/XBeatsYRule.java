package software.surratt.rps;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

public class XBeatsYRule extends AbstractRpsRule {


    private final Throw winner;
    private final Throw loser;


    protected XBeatsYRule(final Throw winner, final Throw loser) {
        this.winner = winner;
        this.loser = loser;
    }

    @When
    public boolean when() {
        final boolean when = (player1Throw.equals(winner) || player2Throw.equals(winner))
                && (player1Throw.equals(loser) || player2Throw.equals(loser));
        return when;
    }

    @Then
    public RuleState then() {

        if (player1Throw.equals(winner) && player2Throw.equals(loser)) {
            outcome = Outcome.Player1Wins;
        } else {
            outcome = Outcome.Player2Wins;
        }

        return RuleState.BREAK;
    }

}
