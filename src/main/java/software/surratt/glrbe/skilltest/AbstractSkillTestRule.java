package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Given;
import com.deliveredtechnologies.rulebook.annotation.Result;

public abstract class AbstractSkillTestRule {

    @Given("testRoll")
    protected TestRoll testRoll;

    @Result
    protected TestResult testResult = TestResult.Failure;

    public void setTestRoll(final TestRoll testRoll) {
        this.testRoll = testRoll;
    }


    public TestResult getResult() {
        return testResult;
    }

    public abstract boolean when();
    public abstract RuleState then();
}
