import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

public class MatangoTest {
    @Test
    public void testSuffix()
    {
        // action
        Matango m1 = new Matango();
        Matango m2 = new Matango();

        // assertion
        assertEquals('A', m1.suffix);
        assertEquals('B', m2.suffix);

        //Matango.next_suffix = 'A';
    }

    @Test
    public void testCirculation()
    {
        // action
        for (int i = 0; i < 26; i++) {
            new Matango();
        }
        Matango m = new Matango();

        // assertion
        assertEquals('A', m.suffix);

        //Matango.next_suffix = 'A';
    }
}
