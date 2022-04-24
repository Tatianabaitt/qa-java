import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void lionReturnsCorrectTextException() {
        String message = "В конструкторе Lion(Feline feline, String sex) некорректно отрабатывает исключение";
        String actual = "";
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        try {
            new Lion(feline, "mane");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(message, expected, actual);
    }

    @Test
    public void getKittensLineReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        String message = "Для метода getKittens() получено некорректное значение";
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        assertEquals(message, expected, actual);
    }

    @Test
    public void getFoodLineReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        String message = "Для метода getFood() получено некорректное значение";
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals(message, expected, actual);
    }
}
