import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {
    private final String animalKind;
    private final List<String> expected;

    public AnimalParametrizedTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getFoodAnimal() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void animalReturnsCorrectGetFood() throws Exception {
        Animal animal = new Animal();
        String message = "Для метода getFood(String animalKind) некорректно отрабатывает исключение";
        List<String> actual = animal.getFood(animalKind);
        assertEquals(message, expected, actual);
    }
}
