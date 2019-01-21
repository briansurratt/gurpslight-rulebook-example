package software.surratt.glrbe.skilltest;


import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessRuleTest {

    // todo how to test for annotations?

    @Test
    public void when_roll_less_than_effective_skill_when_returns_true() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 9);
        final SuccessRule successRule = new SuccessRule();
        successRule.setTestRoll(testRoll);
        assertEquals(true, successRule.when());
    }


    @Test
    public void when_roll_equal_to_effective_skill_when_returns_true() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 10);
        final SuccessRule successRule = new SuccessRule();
        successRule.setTestRoll(testRoll);
        assertEquals(true, successRule.when());
    }

    @Test
    public void when_roll_greater_than_effective_skill_when_returns_true() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final SuccessRule successRule = new SuccessRule();
        successRule.setTestRoll(testRoll);
        assertEquals(false, successRule.when());
    }

    @Test
    public void then_sets_result_to_success() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final SuccessRule successRule = new SuccessRule();
        successRule.setTestRoll(testRoll);
        successRule.then();
        assertEquals(TestResult.Success, successRule.getResult());
    }

    @Test
    public void result_defaults_to_failue() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final SuccessRule successRule = new SuccessRule();
        successRule.setTestRoll(testRoll);
        assertEquals(TestResult.Failure, successRule.getResult());
    }

    @Test
    public void then_returns_rulestate_break() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final SuccessRule successRule = new SuccessRule();
        successRule.setTestRoll(testRoll);
        assertEquals(RuleState.BREAK, successRule.then());
    }


    @Test
    public void test_then_method_has_then_annoation() throws Exception {
        final Method method = SuccessRule.class.getMethod("then", null);
        assertNotNull("then() method found", method);
        assertTrue("method has annotation", method.isAnnotationPresent(Then.class));
    }
    @Test
    public void test_when_method_has_when_annoation() throws Exception {
        final Method method = SuccessRule.class.getMethod("when", null);
        assertNotNull("when() method found", method);
        assertTrue("method has annotation", method.isAnnotationPresent(When.class));
    }

}
