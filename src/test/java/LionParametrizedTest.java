import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String mane;
    private final boolean expected;

    public LionParametrizedTest(String mane, boolean expected) {
        this.mane = mane;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getHaveMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionReturnsCorrectDoesHaveMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, mane);
        String message = "Для метода doesHaveMane() некорректно отрабатывает исключение";
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}
