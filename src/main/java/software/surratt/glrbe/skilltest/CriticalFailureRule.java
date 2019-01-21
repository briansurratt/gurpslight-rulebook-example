package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

@Rule(order = 1)
public class CriticalFailureRule extends AbstractSkillTestRule {

    @Override
    @When
    public boolean when() {

        final int roll = testRoll.getRoll();
        final int effectiveSkill = testRoll.getEffectiveSkill();

        if (roll == 18) return true;

        if ((roll - effectiveSkill >=10)) {
            return true;
        }

        if (roll == 17 && effectiveSkill <= 15) {
            return true;
        }

        return false;

    }

    @Override
    @Then
    public RuleState then() {
        testResult = TestResult.CriticalFailure;
        return RuleState.BREAK;
    }

}
