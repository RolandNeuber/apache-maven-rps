import ba.sachsen.rolandmoritz.models.enums.GameResult;
import ba.sachsen.rolandmoritz.models.enums.RockPaperScissors;
import org.junit.Assert;
import org.junit.Test;

public class RockPaperScissorsTest {
    @Test
    public void testRockPaperScissorsRockWinGetter() {
        RockPaperScissors rock = RockPaperScissors.Rock;

        GameResult res1 = rock.getResultAgainst(RockPaperScissors.Rock);
        Assert.assertEquals(res1, GameResult.Tie);

        GameResult res2 = rock.getResultAgainst(RockPaperScissors.Paper);
        Assert.assertNotNull(res2);
        Assert.assertEquals(res2, GameResult.Loss);

        GameResult res3 = rock.getResultAgainst(RockPaperScissors.Scissors);
        Assert.assertEquals(res3, GameResult.Win);
    }
}
