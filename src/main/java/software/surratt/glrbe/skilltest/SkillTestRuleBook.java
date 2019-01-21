package software.surratt.glrbe.skilltest;

import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;

public class SkillTestRuleBook extends CoRRuleBook<TestResult> {

    @Override
    public void defineRules() {

        addRule(
                RuleBuilder.create()
                        .withFactType(TestRoll.class)
                        .withResultType(TestResult.class)
                        .when(facts -> facts.getOne().getRoll() <= 4)
                        .then((facts, result) -> result.setValue(TestResult.CriticalSuccess))
                        .stop()
                        .build()
        );

        addRule(
                RuleBuilder.create()
                        .withFactType(TestRoll.class)
                        .withResultType(TestResult.class)
                        .when(facts -> facts.getOne().getRoll() == 18)
                        .then((facts, result) -> result.setValue(TestResult.CriticalFailure))
                        .stop()
                        .build()
        );

        addRule(
                RuleBuilder.create()
                        .withFactType(TestRoll.class)
                        .withResultType(TestResult.class)
                        .when(facts -> facts.getOne().getEffectiveSkill() - facts.getOne().getRoll() >= 10)
                        .then((facts, result) -> result.setValue(TestResult.CriticalSuccess))
                        .stop()
                        .build()
        );



        addRule(
                RuleBuilder.create()
                        .withFactType(TestRoll.class)
                        .withResultType(TestResult.class)
                        .when(facts -> facts.getOne().getRoll() == 17 && facts.getOne().getEffectiveSkill() <= 15)
                        .then((facts, result) -> result.setValue(TestResult.CriticalFailure))
                        .stop()
                        .build()
        );

        addRule(
                RuleBuilder.create()
                        .withFactType(TestRoll.class)
                        .withResultType(TestResult.class)
                        .when(facts -> (facts.getOne().getRoll() - facts.getOne().getEffectiveSkill()) >= 10)
                        .then((facts, result) -> result.setValue(TestResult.CriticalFailure))
                        .stop()
                        .build()
        );

        addRule(
                RuleBuilder.create()
                        .withFactType(TestRoll.class)
                        .withResultType(TestResult.class)
                        .when(facts -> facts.getOne().getRoll() <= facts.getOne().getEffectiveSkill())
                        .then((facts, result) -> result.setValue(TestResult.Success))
                        .stop()
                        .build()
        );


    }

}
