package software.surratt.rps;

import com.deliveredtechnologies.rulebook.annotation.Rule;

@Rule
public class PaperBeatsRockRule extends XBeatsYRule {

    public PaperBeatsRockRule() {
        super(Throw.Paper, Throw.Rock);
    }

}
