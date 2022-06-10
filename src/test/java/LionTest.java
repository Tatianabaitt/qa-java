import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
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
        Exception exception = Assert.assertThrows(Exception.class, () ->
                new Lion(feline, "mane"));
        assertThat(exception.getMessage(), containsString("Используйте допустимые значения пола животного - самей или самка"));
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
