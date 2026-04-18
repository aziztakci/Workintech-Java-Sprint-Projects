import org.example.Person;
import org.example.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.example.Person;
import org.example.Wall;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    private Person person;
    private Wall wall;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe", 20);
        wall = new Wall(10, 10);
    }

    @DisplayName("Person sınıf değişkenleri doğru tipte mi ?")
    @Test
    public void testPersonTypes() {
        assertThat(person.getFirstName(), instanceOf(String.class));
        assertThat(person.getLastName(), instanceOf(String.class));
        assertThat(person.getAge(), instanceOf(Integer.class));
    }

    @DisplayName("getFirstName doğru çalışıyor mu?")
    @Test
    public void testPersonGetFirstName() {
        assertEquals(person.getFirstName(), "John");
    }

    @DisplayName("getLastName doğru çalışıyor mu?")
    @Test
    public void testPersonGetLastName() {
        assertEquals(person.getLastName(), "Doe");
    }

    @DisplayName("getAge doğru çalışıyor mu?")
    @Test
    public void testPersonGetAge() {
        assertEquals(person.getAge(), 20);
    }

    @DisplayName("isTeen doğru çalışıyor mu?")
    @Test
    public void testPersonIsTeen() {
        assertEquals(new Person("Jane", "Doe", 18).isTeen(), true);
        assertEquals(new Person("Jane", "Doe", 22).isTeen(), false);
        assertEquals(new Person("Jane", "Doe", 13).isTeen(), true);
    }

    @DisplayName("Wall sınıf değişkenleri doğru tipte mi ?")
    @Test
    public void testWallTypes() {
        assertThat(wall.getWidth(), instanceOf(Double.class));
        assertThat(wall.getHeight(), instanceOf(Double.class));
    }

    @DisplayName("Wall getWidth metodu doğru çalışıyor mu ?")
    @Test
    public void testWallGetWidth() {
        assertEquals(wall.getWidth(), 10);
    }

    @DisplayName("Wall getHeight metodu doğru çalışıyor mu ?")
    @Test
    public void testWallGetHeight() {
        assertEquals(wall.getHeight(), 10);
    }

    @DisplayName("Wall setWidth metodu doğru çalışıyor mu ?")
    @Test
    public void testWallSetWidth() {
        wall.setWidth(20);
        assertEquals(wall.getWidth(), 20);

        wall.setWidth(-10);
        assertEquals(wall.getWidth(), 0);
    }

    @DisplayName("Wall setHeight metodu doğru çalışıyor mu ?")
    @Test
    public void testWallSetHeight() {
        wall.setHeight(20);
        assertEquals(wall.getHeight(), 20);

        wall.setHeight(-10);
        assertEquals(wall.getHeight(), 0);
    }

    @DisplayName("Wall GetArea metodu doğru çalışıyor mu ?")
    @Test
    public void testWallGetArea() {
        wall.setWidth(10);
        wall.setHeight(10);
        assertEquals(wall.getArea(), 100);

        wall.setHeight(-10);
        assertEquals(wall.getArea(), 0);
    }
}
