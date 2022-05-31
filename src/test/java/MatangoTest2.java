import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220531)
 **/
public class MatangoTest2 {
    @Test
    public void testSuffix()
    {
        // action
        Matango m1 = new Matango();
        Matango m2 = new Matango();

        // assertion
        assertEquals('A', m1.suffix, "最初のMatangoインスタンスのsuffixが A になっていません。");
        assertEquals('B', m2.suffix, "２つ目のMatangoインスタンスのsuffixが B になっていません。");

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
        assertEquals('A', m.suffix,"Matangoインスタンスのsuffixが Z になった後で A に戻っていません");

        //Matango.next_suffix = 'A';
    }
}
