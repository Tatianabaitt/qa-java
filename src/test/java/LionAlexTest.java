import com.example.Feline;
import com.example.LionAlex;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionAlexTest {

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void lionAlexGetKittensReturnsCorrectValue() throws Exception {
        String message = "Для метода getKittens() получено некорректное значение";
        LionAlex alex = new LionAlex(feline);
        Mockito.when(feline.getKittens()).thenReturn(0);
        int expected = 0;
        int actual = alex.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(0);
        assertEquals(message, expected, actual);
    }

    @Test
    public void lionAlexGetFriendsReturnsCorrectValue() throws Exception {
        String message = "Для метода getFriends() получено некорректное значение";
        LionAlex alex = new LionAlex(feline);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        List<String> actual = alex.getFriends();
        assertEquals(message, expected, actual);
    }

    @Test
    public void lionAlexGetPlaceOfLivingReturnsCorrectValue() throws Exception {
        String message = "Для метода getPlaceOfLiving() получено некорректное значение";
        LionAlex alex = new LionAlex(feline);
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(message, expected, actual);
    }
}
