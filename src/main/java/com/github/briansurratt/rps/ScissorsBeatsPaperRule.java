package com.github.briansurratt.rps;

import com.deliveredtechnologies.rulebook.annotation.Rule;

@Rule
public class ScissorsBeatsPaperRule extends XBeatsYRule {

    public ScissorsBeatsPaperRule() {
        super(Throw.Scissors, Throw.Paper);
    }
}
