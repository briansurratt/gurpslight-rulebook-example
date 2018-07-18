package com.github.briansurratt.glrbe.skilltest;

public class SkillTest {


    private final int _effectiveSkill;

    public SkillTest(final int effectiveSkill) {
        _effectiveSkill = effectiveSkill;
    }

    public TestResult test(final int roll) {

        if (roll == 18) {
            return TestResult.CriticalFailure;
        } else if (roll == 17 && _effectiveSkill <=15) {
            return TestResult.CriticalFailure;
        } else if (roll - _effectiveSkill >= 10) {
            return TestResult.CriticalFailure;
        } else if (isCriticalSuccess(roll)) {
            return TestResult.CriticalSuccess;
        } else if (roll <= _effectiveSkill) {
            return TestResult.Success;
        } else {
            return TestResult.Failure;
        }

    }

    private boolean isCriticalSuccess(final int roll) {

        if (roll <= 4) return true;

        return  (_effectiveSkill - roll >= 10) ;

    }

}
