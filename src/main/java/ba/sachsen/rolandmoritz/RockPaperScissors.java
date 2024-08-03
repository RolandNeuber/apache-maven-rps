package ba.sachsen.rolandmoritz;

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
     * @return Returns null if it's a tie, true if it's a win
     */
    public Boolean wonAgainst(RockPaperScissors opponent){
        int opponentValue = opponent.getValue();

        //Tie
        if(value == opponentValue){
            return null;
        }

        //Rock wins against scissors
        if(value == 1){
            return opponentValue == 3;
        }

        //Paper wins against rock
        if(value == 2){
            return opponentValue == 1;
        }

        //Scissors win against paper
        return opponentValue == 2;
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
