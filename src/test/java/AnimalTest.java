import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void animalGetFoodReturnsCorrectTextException() {
        Animal animal = new Animal();
        Exception exception = Assert.assertThrows(Exception.class, () -> animal.getFood("Млекопитающее"));
        assertThat(exception.getMessage(), containsString("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
    }

    @Test
    public void animalGetFamily() {
        Animal animal = new Animal();
        String message = "Для метода getFamily() получено некорректное значение";
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(message, expected, actual);
    }

}
