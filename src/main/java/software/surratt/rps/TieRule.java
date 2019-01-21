package software.surratt.rps;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

@Rule
public class TieRule extends AbstractRpsRule {

    @When
    public boolean when() {
        return player1Throw.equals(player2Throw);
    }

    @Then
    public RuleState then() {
        outcome = Outcome.Tie;
        return RuleState.BREAK;
    }

}
