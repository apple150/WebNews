import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ircst on 21.02.15.
 */
public class DaoTest {
    @Test
    public void mustReturnTrueTest() {
        //тут то что ты хочешь проверить
        //потом надо вызвать специальную функцию
        Assert.assertEquals("строка об ошибке", "значение которое должно быть", "фактическое значение");
        //пример
        int expected = 4;
        int b = 2;
        Assert.assertEquals("ошибка",expected,b*b);
    }
}
