import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void animalGetFoodReturnsCorrectTextException() {
        Animal animal = new Animal();
        String actual = "";
        String message = "При некорректном параметре метода getFood() не вернулась ожидаемая ошибка";
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            animal.getFood("Млекопитающее");
        } catch (Exception e) {
            actual = e.getMessage();
        }
        assertEquals(message, expected, actual);
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
