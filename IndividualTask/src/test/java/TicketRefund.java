import org.junit.Assert;
import org.junit.Test;
public class TicketRefund {
    //  8 автоматизированных тестов с позитивным сценарием
    @Test
    public void testThreeDays() {
        var actualResult = getResult(3, 1200f);
        Assert.assertEquals("600.0", actualResult);
    }
    @Test
    public void testSevenDays() {
        var actualResult = getResult(7, 1000f);
        Assert.assertEquals("800.0", actualResult);
    }
    @Test
    public void testZeroDays() {
        var actualResult = getResult(0, 1000f);
        Assert.assertEquals("0", actualResult);
    }
    @Test
    public void testTwoDays() {
        var actualResult = getResult(2, 1000f);
        Assert.assertEquals("0", actualResult);
    }
    @Test
    public void testSixDays() {
        var actualResult = getResult(6, 1200f);
        Assert.assertEquals("600.0", actualResult);
    }
    @Test
    public void testTwelveDays() {
        var actualResult = getResult(12, 1000f);
        Assert.assertEquals("800.0", actualResult);
    }
    @Test
    public void testThirteenDays() {
        var actualResult = getResult(13, 1000f);
        Assert.assertEquals("1000.0", actualResult);
    }
    @Test
    public void testFiftyDays() {
        var actualResult = getResult(50, 1000f);
        Assert.assertEquals("1000.0", actualResult);
    }
    //  5 автоматизированных тестов с негативным сценарием
    @Test
    public void testMinusDays() {
        var actualResult = getResult(-2, 1005f);
        Assert.assertEquals("введены не корректные данные оставшихся дней", actualResult);
    }
    @Test
    public void testMinusMoney() {
        var actualResult = getResult(5, -1005f);
        Assert.assertEquals("введены не корректные данные стоимости билета", actualResult);
    }
    @Test
    public void testOverDays() {
        var actualResult = getResult(60, 1400f);
        Assert.assertEquals("введены не корректные данные оставшихся дней", actualResult);
    }
    @Test
    public void testOverMoney() {
        var actualResult = getResult(20, 7000f);
        Assert.assertEquals("введены не корректные данные стоимости билета", actualResult);
    }
    @Test
    public void testOverMoney_and_Days() {
        var actualResult = getResult(-20, -7000f);
        Assert.assertEquals("введены не корректные данные оставшихся дней и стоимости билета", actualResult);
    }
    //Реализация своего модуля на Java по составленному ранее ТЗ
        private String getResult(int days, Float money)
        {
            var vozvrat_50 = (money * 50)/100;
            var vozvrat_80 = (money * 80)/100;
            var vozvrat_100 = (money * 100)/100;
            String userResult = null;
            if ((days < 0 || days > 50) && (money < 0 || money > 6000)) {
                userResult = "введены не корректные данные оставшихся дней и стоимости билета";
            } else if (days < 0 || days > 50) {
                userResult = "введены не корректные данные оставшихся дней";
            } else if (money < 0 || money > 6000)  {
                userResult = "введены не корректные данные стоимости билета";
            } else if (days >= 0 && days < 3) {
                userResult = "0";
            } else if (days >= 3 && days <= 6) {
                userResult = String.valueOf(vozvrat_50) ;
            }else  if (days >= 7 && days <= 12){
                userResult = String.valueOf(vozvrat_80);
            }else if (days > 12 && days <= 50){
                userResult = String.valueOf(vozvrat_100);
            }
            return userResult;
        }
    }
