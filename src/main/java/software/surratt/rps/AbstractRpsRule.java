package software.surratt.rps;

import com.deliveredtechnologies.rulebook.annotation.Given;
import com.deliveredtechnologies.rulebook.annotation.Result;

public class AbstractRpsRule {


    @Given("player1Throw")
    Throw player1Throw;

    @Given("player2Throw")
    Throw player2Throw;

    @Result
    Outcome outcome;

}
