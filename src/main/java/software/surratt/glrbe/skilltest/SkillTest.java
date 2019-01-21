package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.Fact;
import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;

import java.util.Optional;

public class SkillTest {


    private final int _effectiveSkill;

    public SkillTest(final int effectiveSkill) {
        _effectiveSkill = effectiveSkill;
    }

    public TestResult test(final int roll) {


        return pojoRulesImpl(roll);

//        return rulebookImplementation(roll);


//        return proceduralImplementation(roll);

    }

    private TestResult pojoRulesImpl(final int roll) {
        final TestRoll testRoll = new TestRoll(_effectiveSkill, roll);

        final String name = this.getClass().getPackage().getName();
        RuleBookRunner ruleBook = new RuleBookRunner(name);
        NameValueReferableMap<TestRoll> facts = new FactMap<>();
        facts.put("testRoll", new Fact<>(testRoll));
        ruleBook.setDefaultResult(TestResult.Failure);
        ruleBook.run(facts);

        final Optional result = ruleBook.getResult();

        return (TestResult) ((Result) result.get()).getValue();
    }

    private TestResult rulebookImplementation(final int roll) {
        final TestRoll testRoll = new TestRoll(_effectiveSkill, roll);


        RuleBook ruleBook = RuleBookBuilder.create(SkillTestRuleBook.class).withResultType(TestResult.class)
                .withDefaultResult(TestResult.Failure)
                .build();

        NameValueReferableMap facts = new FactMap();
        facts.setValue("testRoll",testRoll);
        ruleBook.run(facts);

        final Optional result = ruleBook.getResult();

        return (TestResult) ((Result) result.get()).getValue();
    }

    private TestResult proceduralImplementation(final int roll) {

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
