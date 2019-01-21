package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CriticalFailureTest {


    @Test
    public void has_rule_annotation() throws Exception {
        assertEquals(true, CriticalFailureRule.class.isAnnotationPresent(Rule.class));
    }


    @Test
    public void eighteen_is_a_critical_failure() throws Exception {

        final TestRoll testRoll = new TestRoll(18, 18);
        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());

    }

    @Test
    public void result_defaults_to_failure_failiure() throws Exception {

        final CriticalFailureRule rule = new CriticalFailureRule();
        assertEquals(TestResult.Failure, rule.getResult());

    }

    @Test
    public void then_sets_result_to_critical_failure() throws Exception {

        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.then();
        assertEquals(TestResult.CriticalFailure, rule.getResult());

    }


    @Test
    public void when_effective_skill_is_fifteen_a_roll_of_seventeen_is_a_critical_failure() throws Exception {
        final TestRoll testRoll = new TestRoll(15, 17);
        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void when_effective_skill_is_less_than_fifteen_a_roll_of_seventeen_is_a_critical_failure() throws Exception {
        final TestRoll testRoll = new TestRoll(14, 17);
        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void when_roll_is_10_more_than_effective_skill_result_is_a_critical_failure() throws Exception {
        final TestRoll testRoll = new TestRoll(5, 15);
        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void when_roll_is_10_or_more_greater_than_effective_skill_result_is_a_critical_failure() throws Exception {
        final TestRoll testRoll = new TestRoll(5, 16);
        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void when_roll_is_9_greater_than_effective_skill_result_is_a_failure() throws Exception {
        final TestRoll testRoll = new TestRoll(5, 14);
        final CriticalFailureRule rule = new CriticalFailureRule();
        rule.setTestRoll(testRoll);
        assertEquals(false, rule.when());
    }

    @Test
    public void then_returns_rulestate_break() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final CriticalFailureRule rule = new CriticalFailureRule();
        assertEquals(RuleState.BREAK, rule.then());
    }

    @Test
    public void test_then_method_has_then_annoation() throws Exception {
        final Method method = CriticalFailureRule.class.getMethod("then", null);
        assertNotNull("then() method found", method);
        assertTrue("method has annotation", method.isAnnotationPresent(Then.class));
    }
    @Test
    public void test_when_method_has_when_annoation() throws Exception {
        final Method method = CriticalFailureRule.class.getMethod("when", null);
        assertNotNull("when() method found", method);
        assertTrue("method has annotation", method.isAnnotationPresent(When.class));
    }

}
