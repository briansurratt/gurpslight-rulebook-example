package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.*;

@Rule(order = 3)
public class SuccessRule extends AbstractSkillTestRule {

    @Override
    @When
    public boolean when() {
        return testRoll.getRoll() <= testRoll.getEffectiveSkill();
    }

    @Override
    @Then
    public RuleState then() {
        testResult = TestResult.Success;
        return RuleState.BREAK;
    }

}
