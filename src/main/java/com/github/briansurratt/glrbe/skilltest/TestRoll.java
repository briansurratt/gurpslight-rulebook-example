package com.github.briansurratt.glrbe.skilltest;

public class TestRoll {

    private final int _effectiveSkill;
    private final int _roll;

    public TestRoll(final int effectiveSkill, final int roll) {
        _effectiveSkill = effectiveSkill;
        _roll = roll;
    }

    public int getEffectiveSkill() {
        return _effectiveSkill;
    }

    public int getRoll() {
        return _roll;
    }

}
