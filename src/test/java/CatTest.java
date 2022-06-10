import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CatTest {

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getFoodCatReturnsCorrectValue() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        String message = "Для метода getFood() получено некорректное значение";
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        assertEquals(message, expected, actual);
    }

    @Test
    public void getSoundCatReturnsCorrectValue() {
        Cat cat = new Cat(feline);
        String message = "Для метода getSound() получено некорректное значение";
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(message, expected, actual);
    }
}
