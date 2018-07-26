package com.github.rulebook.example;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HomeLoanRateRuleBookTest {

    @Test
    public void credit_score_between_600_and_700_pays_a_1_point_increase() throws Exception {

        RuleBook homeLoanRateRuleBook = buildDefaultRuleBook(4.5, 650, false, 20000.0);

        final Optional result = homeLoanRateRuleBook.getResult();

        assertEquals(true, result.isPresent());
        assertEquals(5.5, ((Result)result.get()).getValue());

    }

    @Test
    public void first_time_home_buyer_gets_a_20_percent_rate_reduction() throws Exception {

        RuleBook homeLoanRateRuleBook = buildDefaultRuleBook(4.5, 650, true, 20000.0);

        final Optional result = homeLoanRateRuleBook.getResult();

        assertEquals(true, result.isPresent());
        assertEquals(4.4, ((Result)result.get()).getValue());

    }

    @Test
    public void credit_score_less_than_600_yields_rate_times_four() throws Exception {

        RuleBook homeLoanRateRuleBook = buildDefaultRuleBook(4.0, 550, true, 20000.0);

        final Optional result = homeLoanRateRuleBook.getResult();
        assertEquals(true, result.isPresent());

        assertEquals(16.0, ((Result)result.get()).getValue());

    }

    @Test
    public void credit_score_is_700_and_25000_cash_on_hand_25_percent_rate_decrease() throws Exception {

        RuleBook homeLoanRateRuleBook = buildDefaultRuleBook(4.0, 750, false, 25000.0);
        final Optional result = homeLoanRateRuleBook.getResult();
        assertEquals(true, result.isPresent());

        assertEquals(3.75, ((Result)result.get()).getValue());

    }

    private RuleBook buildDefaultRuleBook(final double v, final int i, final boolean newHomeBuyer, final double cashOnHand) {

        RuleBook homeLoanRateRuleBook = RuleBookBuilder.create(HomeLoanRateRuleBook.class).withResultType(Double.class)
                .withDefaultResult(v)
                .build();

        NameValueReferableMap facts = new FactMap();

        facts.setValue("applicant", new ApplicantBean(i, cashOnHand, newHomeBuyer));
        homeLoanRateRuleBook.run(facts);

        return homeLoanRateRuleBook;

    }

}
