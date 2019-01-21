package software.surratt.glrbe.skilltest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkillTestTest {



    @Test
    public void three_is_a_critical_success() throws Exception {

        final SkillTest skillTest = new SkillTest(5);

        TestResult result = skillTest.test(3);

        assertEquals(TestResult.CriticalSuccess, result);

    }


    @Test
    public void four_is_a_critical_success() throws Exception {

        final SkillTest skillTest = new SkillTest(5);

        TestResult result = skillTest.test(4);

        assertEquals(TestResult.CriticalSuccess, result);

    }

    @Test
    public void eighteen_is_a_critical_failure() throws Exception {

        final SkillTest skillTest = new SkillTest(18);

        TestResult result = skillTest.test(18);

        assertEquals(TestResult.CriticalFailure, result);

    }

    @Test
    public void result_is_success_when_roll_is_less_than_effective_skill() throws Exception {

        final SkillTest skillTest = new SkillTest(12);

        TestResult result = skillTest.test(5);

        assertEquals(TestResult.Success, result);

    }

    @Test
    public void result_is_success_when_roll_is_equal_to_effective_skill() throws Exception {

        final SkillTest skillTest = new SkillTest(12);

        TestResult result = skillTest.test(12);

        assertEquals(TestResult.Success, result);

    }

    @Test
    public void result_is_failure_when_roll_is_greater_than_effective_skill() throws Exception {

        final SkillTest skillTest = new SkillTest(12);

        TestResult result = skillTest.test(13);

        assertEquals(TestResult.Failure, result);

    }

    @Test
    public void five_is_critial_success_if_effective_skill_is_greater_than_fifteen() throws Exception {
        final SkillTest skillTest = new SkillTest(16);

        TestResult result = skillTest.test(5);

        assertEquals(TestResult.CriticalSuccess, result);
    }

    @Test
    public void five_is_critical_success_if_effective_skill_is_fifteen() throws Exception {

        final SkillTest skillTest = new SkillTest(15);

        TestResult result = skillTest.test(5);

        assertEquals(TestResult.CriticalSuccess, result);

    }

    @Test
    public void six_is_critial_success_if_effective_skill_is_greater_than_sixteen() throws Exception {
        final SkillTest skillTest = new SkillTest(17);

        TestResult result = skillTest.test(6);

        assertEquals(TestResult.CriticalSuccess, result);
    }

    @Test
    public void six_is_critial_success_if_effective_skill_is_sixteen() throws Exception {
        final SkillTest skillTest = new SkillTest(16);

        TestResult result = skillTest.test(6);

        assertEquals(TestResult.CriticalSuccess, result);
    }

    @Test
    public void when_effective_skill_is_eighteen_a_roll_of_seventeen_is_a_success() throws Exception {
        final SkillTest skillTest = new SkillTest(18);

        TestResult result = skillTest.test(17);

        assertEquals(TestResult.Success, result);
    }

    @Test
    public void when_effective_skill_is_sixteen_a_roll_of_seventeen_is_a_failure() throws Exception {
        final SkillTest skillTest = new SkillTest(16);

        TestResult result = skillTest.test(17);

        assertEquals(TestResult.Failure, result);
    }


    @Test
    public void when_effective_skill_is_fifteen_a_roll_of_seventeen_is_a_critical_failure() throws Exception {

        final SkillTest skillTest = new SkillTest(15);

        final TestResult result = skillTest.test(17);

        assertEquals(TestResult.CriticalFailure, result);

    }

    @Test
    public void when_effective_skill_is_less_than_fifteen_a_roll_of_seventeen_is_a_critical_failure() throws Exception {

        final SkillTest skillTest = new SkillTest(14);

        final TestResult result = skillTest.test(17);

        assertEquals(TestResult.CriticalFailure, result);

    }


    @Test
    public void when_roll_is_10_more_than_effective_skill_result_is_a_critical_failure() throws Exception {

        final SkillTest skillTest = new SkillTest(2);

        final TestResult result = skillTest.test(12);

        assertEquals(TestResult.CriticalFailure, result);

    }



    @Test
    public void when_roll_is_10_or_more_greater_than_effective_skill_result_is_a_critical_failure() throws Exception {

        final SkillTest skillTest = new SkillTest(2);

        final TestResult result = skillTest.test(13);

        assertEquals(TestResult.CriticalFailure, result);

    }

}
