import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void eatMeatFelineReturnsCorrectValue() throws Exception {
        Feline feline = new Feline();
        String message = "Для метода eatMeat() получено некорректное значение";
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(message, expected, actual);
    }

    @Test
    public void getFamilyFelineReturnsCorrectValue() {
        Feline feline = new Feline();
        String message = "Для метода getFamily() получено некорректное значение";
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(message, expected, actual);
    }

    @Test
    public void getKittensFelineReturnsCorrectValue() {
        Feline feline = Mockito.spy(Feline.class);
        int expected = 1;
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        String message = "Для метода getKittens() получено некорректное значение";
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(message, expected, actual);
    }

    @Test
    public void getKittensCountFelineReturnsCorrectValue() {
        Feline feline = new Feline();
        String message = "Для метода getKittens(int kittensCount) получено некорректное значение";
        int expected = 10;
        int actual = feline.getKittens(10);
        assertEquals(message, expected, actual);
    }
}
