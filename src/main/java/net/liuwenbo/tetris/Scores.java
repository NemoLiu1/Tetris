package net.liuwenbo.tetris;

public class Scores {
//    public static final int[] POINTS = {
//        1, // soft drop
//        2, // hard drop
//        100, // single line clear
//        300, // double line clear
//        500, // triple line clear
//        800, // Tetris or 4 line clear
//        400, // T-spin
//        800, // T-spin Single
//        1200, // T-spin Double
//        1600, // T-spin Triple
//        // currently missing "back-to-back (0.5 * Tetris or T-spin)"
//    };
    public static final int SOFT_DROP = 1;
    public static final int HARD_DROP = 2;
    public static final int singleLineClear = 100;
    public static final int doubleLineClear = 300;
    public static final int tripleLineClear = 500;
    public static final int tetrisLineClear = 800;
    public static final int tSpin = 400;
    public static final int tSpinSingle = 800;
    public static final int tSpinDouble = 1200;
    public static final int tSpinTriple = 1600;

    private int currentScore = 0;
    private int gameLevel = 0;
    private int totalClearedLines = 0;

    public void setCurrentScore(int newScore) {
        currentScore = newScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getTotalClearedLines() {
        return totalClearedLines;
    }

    public void addLinesToTotalClearedLines(int linesCleared) {
        totalClearedLines += linesCleared;
    }


    public void addScoreForSoftDrop(int dropDistance) {
        currentScore += dropDistance * SOFT_DROP;
    }

    public void addScoreForHardDrop(int dropDistance) {
        currentScore += dropDistance * HARD_DROP;
    }

    public void addScoreForLineClear(int linesCleared) {
        switch (linesCleared) {
            case 1:
                currentScore += singleLineClear;
                break;
            case 2:
                currentScore += doubleLineClear;
                break;
            case 3:
                currentScore += tripleLineClear;
                break;
            case 4:
                currentScore += tetrisLineClear;
                break;
        }
        totalClearedLines += linesCleared;
        // need improvement:
//        public void addScoreForLineClear(int linesCleared, int currentLevel, boolean isBackToBack) {
    }

    public void addScoreForTSpin(int linesCleared) {
        switch (linesCleared) {
            case 0:
                currentScore += tSpin;
                break;
            case 1:
                currentScore += tSpinSingle;
                break;
            case 2:
                currentScore += tSpinDouble;
                break;
            case 3:
                currentScore += tSpinTriple;
                break;
        }
        // need improve:
//        public void addScoreForTSpin(int linesCleared, int currentLevel, boolean isBackToBack) {
    }

    public void resetCurrentScore() {
        currentScore = 0;
    }

    public void resetTotalClearedLines() {
        totalClearedLines = 0;
    }

    public void reset() {
        resetCurrentScore();
        resetTotalClearedLines();
    }
}
