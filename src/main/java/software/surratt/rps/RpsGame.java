package software.surratt.rps;

public interface RpsGame {
    Outcome play(Throw player1Throw, Throw player2Throw);
}
