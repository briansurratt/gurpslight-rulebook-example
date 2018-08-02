package com.github.briansurratt.rps;

public interface RpsGame {
    Outcome play(Throw player1Throw, Throw player2Throw);
}
