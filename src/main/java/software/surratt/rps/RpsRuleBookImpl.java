package software.surratt.rps;

import com.deliveredtechnologies.rulebook.Fact;
import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;

import java.util.Optional;

public class RpsRuleBookImpl implements RpsGame {

    @Override
    public Outcome play(final Throw player1Throw, final Throw player2Throw) {

        final String packageName = this.getClass().getPackage().getName();
        RuleBookRunner ruleBook = new RuleBookRunner(packageName);

        NameValueReferableMap<Throw> facts = new FactMap<>();
        facts.put("player1Throw", new Fact<>(player1Throw));
        facts.put("player2Throw", new Fact<>(player2Throw));

        Outcome outcome = null;

        ruleBook.run(facts);
        final Optional<Result> result = ruleBook.getResult();

        outcome = (Outcome) result.get().getValue();


        return outcome;

    }

}
