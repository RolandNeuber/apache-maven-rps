import ba.sachsen.rolandmoritz.RockPaperScissors;
import org.junit.Assert;
import org.junit.Test;

public class RockPaperScissorsTest {
    @Test
    public void testRockPaperScissorsRockWinGetter() {
        RockPaperScissors rock = RockPaperScissors.Rock;

        Boolean res1 = rock.wonAgainst(RockPaperScissors.Rock);
        Assert.assertNull(res1);

        Boolean res2 = rock.wonAgainst(RockPaperScissors.Paper);
        Assert.assertNotNull(res2);
        Assert.assertFalse(res2);

        Boolean res3 = rock.wonAgainst(RockPaperScissors.Scissors);
        Assert.assertNotNull(res3);
        Assert.assertTrue(res3);
    }
}
