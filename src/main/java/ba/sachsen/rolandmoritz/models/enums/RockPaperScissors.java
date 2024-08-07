package ba.sachsen.rolandmoritz.models.enums;

public enum RockPaperScissors {
    Rock(1),
    Paper(2),
    Scissors(3);

    private final int value;

    RockPaperScissors(int v){
        value = v;
    }

    public int getValue(){
        return value;
    }

    /**
     * Checks if this object won against another RockPaperScissors opponent
     * @param opponent opponent of type RockPaperScissors
     * @return GameResult
     */
    public GameResult getResultAgainst(RockPaperScissors opponent){
        int opponentValue = opponent.getValue();

        //Tie
        if(value == opponentValue){
            return GameResult.Tie;
        }

        //Rock wins against scissors
        if(value == 1){
            if(opponentValue == 3){
                return GameResult.Win;
            }
            return GameResult.Loss;
        }

        //Paper wins against rock
        if(value == 2){
            if(opponentValue == 1){
                return GameResult.Win;
            }
            return GameResult.Loss;
        }

        //Scissors win against paper
        if(opponentValue == 2){
            return GameResult.Win;
        }
        return GameResult.Loss;
    }

    @Override
    public String toString() {
        if(value == 1){
            return "Rock";
        }
        if(value == 2){
            return "Paper";
        }

        return "Scissors";
    }
}
