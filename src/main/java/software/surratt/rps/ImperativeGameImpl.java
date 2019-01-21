package software.surratt.rps;

public class ImperativeGameImpl implements RpsGame {

    @Override
    public Outcome play(final Throw player1Throw, final Throw player2Throw) {

        if (player1Throw.equals(player2Throw)) {
            return Outcome.Tie;
        }

        if (Throw.Paper.equals(player1Throw) && Throw.Rock.equals(player2Throw)) {
            return Outcome.Player1Wins;
        } else if (Throw.Rock.equals(player1Throw) && Throw.Scissors.equals(player2Throw)) {
            return Outcome.Player1Wins;
        } else if (Throw.Scissors.equals(player1Throw) && Throw.Paper.equals(player2Throw)) {
            return Outcome.Player1Wins;
        }
        return Outcome.Player2Wins;

    }

}
