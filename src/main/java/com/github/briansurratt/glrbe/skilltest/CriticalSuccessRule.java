package com.github.briansurratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

@Rule(order = 2)
public class CriticalSuccessRule extends AbstractSkillTestRule {

    @When
    @Override
    public boolean when() {

        final int roll = testRoll.getRoll();
        final int effectiveSkill = testRoll.getEffectiveSkill();

        return roll <= 4 || (effectiveSkill-roll >= 10);

    }

    @Then
    @Override
    public RuleState then() {
        testResult = TestResult.CriticalSuccess;
        return RuleState.BREAK;
    }
}
