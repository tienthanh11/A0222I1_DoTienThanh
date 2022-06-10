package ss08_CleanCodeAndRefactoring.BaiTap.Refactoring;

public class Refactoring_TennisGame {

    public static final int LOVE_SCORE = 0;
    public static final int FIFTEEN_SCORE = 1;
    public static final int THIRTY_SCORE = 2;
    public static final int FORTY_SCORE = 3;
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";

    public static String compareScore(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        String score = " ";
        boolean isScoreEqual = scoreOfFirstPlayer == scoreOfSecondPlayer;
        if(isScoreEqual) {
            score = compareAllScore(scoreOfFirstPlayer);
        } else if(scoreOfFirstPlayer >= 4 || scoreOfSecondPlayer >= 4) {
            score = compareLargerOrEqual(scoreOfFirstPlayer, scoreOfSecondPlayer);
        } else {
            score = remainingCases(scoreOfFirstPlayer, scoreOfSecondPlayer, score);
        }
        return score;
    }

    public static String compareAllScore(int scoreOfFirstPlayer) {
        String score;
        switch (scoreOfFirstPlayer) {
            case LOVE_SCORE:
                score = LOVE_ALL;
                break;
            case FIFTEEN_SCORE:
                score = FIFTEEN_ALL;
                break;
            case THIRTY_SCORE:
                score = THIRTY_ALL;
                break;
            case FORTY_SCORE:
                score = FORTY_ALL;
                break;
            default:
                score = DEUCE;
                break;
        }
        return score;
    }

    public static String compareLargerOrEqual(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        String score;
        int minusResult = scoreOfFirstPlayer - scoreOfSecondPlayer;
        if(minusResult == 1) {
            score = ADVANTAGE_PLAYER_1;
        } else if(minusResult == -1) {
            score = ADVANTAGE_PLAYER_2;
        } else if(minusResult >= 2) {
            score = WIN_FOR_PLAYER_1;
        } else {
            score = WIN_FOR_PLAYER_2;
        }
        return score;
    }

    public static String remainingCases(int scoreOfFirstPlayer, int scoreOfSecondPlayer, String score) {
        int tempScore;
        for(int i = 1; i < 3; i++) {
            if(i == 1) {
                tempScore = scoreOfFirstPlayer;
            } else {
                score = "-";
                tempScore = scoreOfSecondPlayer;
            }
            switch (tempScore) {
                case LOVE_SCORE:
                    score += LOVE;
                    break;
                case FIFTEEN_SCORE:
                    score += FIFTEEN;
                    break;
                case THIRTY_SCORE:
                    score += THIRTY;
                    break;
                case FORTY_SCORE:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }
}
