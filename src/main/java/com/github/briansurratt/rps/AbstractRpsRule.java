package com.github.briansurratt.rps;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Given;
import com.deliveredtechnologies.rulebook.annotation.Result;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

public class AbstractRpsRule {


    @Given("player1Throw")
    Throw player1Throw;

    @Given("player2Throw")
    Throw player2Throw;

    @Result
    Outcome outcome;

}
