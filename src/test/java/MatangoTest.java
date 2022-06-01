import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220601)
 **/
public class MatangoTest {
    static int counter  = 0; // this is for static variable tests on the same JVM
    @Test
    public void testSuffix()
    {
        // pre-action for static variable
        if (counter == 0 && Matango.nextSuffix != 'A') fail("静的変数の初期値が ’A’ 以外です!"+counter);
        if (0 < counter) {
            counter = 0; Matango.nextSuffix = 'A';
        }
        // action
        Matango m1 = new Matango();
        Matango m2 = new Matango();
        counter ++;
        
        // assertion
        assertEquals('A', m1.suffix, "最初のMatangoインスタンスのsuffixが A になっていません。");
        assertEquals('B', m2.suffix, "２つ目のMatangoインスタンスのsuffixが B になっていません。");

        //Matango.next_suffix = 'A';
    }

    @Test
    public void testCirculation()
    {
        // pre-action for static variable
        if (counter == 0 && Matango.nextSuffix != 'A') fail("静的変数の初期値が ’A’ 以外です!");
        if (0 < counter) {
            counter = 0; Matango.nextSuffix = 'A';
        }
        // action
        for (int i = 0; i < 26; i++) {
            new Matango();
        }
        Matango m = new Matango();
        counter ++;

        // assertion
        assertEquals('A', m.suffix,"Matangoインスタンスのsuffixが Z になった後で A に戻っていません");

        //Matango.next_suffix = 'A';
    }
}
