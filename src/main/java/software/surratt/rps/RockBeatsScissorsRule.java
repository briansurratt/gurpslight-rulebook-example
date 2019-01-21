package software.surratt.rps;

import com.deliveredtechnologies.rulebook.annotation.*;

@Rule
public class RockBeatsScissorsRule extends XBeatsYRule {

    public RockBeatsScissorsRule() {
        super(Throw.Rock, Throw.Scissors);
    }

}
