package com.github.briansurratt.glrbe.skilltest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkillTestTest {

    @Test
    public void three_is_a_critical_success() throws Exception {

        final SkillTest skillTest = new SkillTest(18);

        TestResult result = skillTest.test(3);

        assertEquals(TestResult.CriticalSuccess, result);

    }


    @Test
    public void four_is_a_critical_success() throws Exception {

        final SkillTest skillTest = new SkillTest(18);

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
    public void five_is_critial_success_if_effective_skill_is_fifteen() throws Exception {

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

}
