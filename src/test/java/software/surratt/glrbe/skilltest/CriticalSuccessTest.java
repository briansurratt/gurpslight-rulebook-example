package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CriticalSuccessTest {

    @Test
    public void has_rule_annotation() throws Exception {
        assertEquals(true, CriticalSuccessRule.class.isAnnotationPresent(Rule.class));
    }


    @Test
    public void when_roll_equals_3_when_returns_true() throws Exception {

        final TestRoll testRoll = new TestRoll(5, 3);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());

    }

    @Test
    public void when_roll_equals_4_when_returns_true() throws Exception {

        final TestRoll testRoll = new TestRoll(5, 4);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());

    }

    @Test
    public void when_roll_greater_than_4_when_returns_false() throws Exception {
        final TestRoll testRoll = new TestRoll(6, 5);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(false, rule.when());
    }

    @Test
    public void result_defaults_to_failue() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(TestResult.Failure, rule.getResult());
    }

    @Test
    public void then_returns_rulestate_break() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(RuleState.BREAK, rule.then());
    }

    @Test
    public void then_sets_result_to_critical_success() throws Exception {
        final TestRoll testRoll = new TestRoll(10, 11);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        rule.then();
        assertEquals(TestResult.CriticalSuccess, rule.getResult());
    }

    @Test
    public void if_effective_skill_is_greater_than_15_and_roll_is_5_then_when_returns_true() throws Exception {
        final TestRoll testRoll = new TestRoll(16, 5);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void five_is_critical_success_if_effective_skill_is_fifteen() throws Exception {
        final TestRoll testRoll = new TestRoll(15, 5);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void six_is_critial_success_if_effective_skill_is_sixteen() throws Exception {
        final TestRoll testRoll = new TestRoll(16, 6);
        final CriticalSuccessRule rule = new CriticalSuccessRule();
        rule.setTestRoll(testRoll);
        assertEquals(true, rule.when());
    }

    @Test
    public void test_then_method_has_then_annoation() throws Exception {
        final Method method = CriticalSuccessRule.class.getMethod("then", null);
        assertNotNull("then() method found", method);
        assertTrue("method has annotation", method.isAnnotationPresent(Then.class));
    }
    @Test
    public void test_when_method_has_when_annoation() throws Exception {
        final Method method = CriticalSuccessRule.class.getMethod("when", null);
        assertNotNull("when() method found", method);
        assertTrue("method has annotation", method.isAnnotationPresent(When.class));
    }

}
