import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @version (20220601)
 * @version (20261117) revised for test isolation, Z-to-A boundary verification, and clean imports
 **/
public class MatangoTest {
    private static char initialNextSuffix;

    @BeforeAll
    static void captureInitialValue() {
        // クラスロード直後の静的フィールドの初期値を記録
        initialNextSuffix = Matango.nextSuffix;
    }

    @BeforeEach
    void resetStaticField() {
        // 初期値が 'A' であることを確認した上で、各テスト前に状態をリセット
        assertEquals('A', initialNextSuffix, "静的フィールド nextSuffix の初期値が 'A' ではありません!");
        Matango.nextSuffix = 'A';
    }

    /**
     * インスタンス生成ごとに suffix が 'A', 'B', 'C' と順番に割り当てられるか検証
     */
    @Test
    public void testSuffix() {
        Matango m1 = new Matango();
        Matango m2 = new Matango();
        Matango m3 = new Matango();

        assertEquals('A', m1.suffix, "1つ目の Matango インスタンスの suffix が 'A' になっていません。");
        assertEquals('B', m2.suffix, "2つ目の Matango インスタンスの suffix が 'B' になっていません。");
        assertEquals('C', m3.suffix, "3つ目の Matango インスタンスの suffix が 'C' になっていません。");
    }

    /**
     * 'Z' を割り当てた後、再び 'A' に循環して戻るか検証
     */
    @Test
    public void testCirculation() {
        Matango lastBeforeWrap = null;
        for (int i = 0; i < 26; i++) {
            lastBeforeWrap = new Matango();
        }
        // 26個目が 'Z' であることを確認
        assertEquals('Z', lastBeforeWrap.suffix, "26個目の Matango インスタンスの suffix が 'Z' になっていません。");

        // 27個目（'Z' の次）が 'A' に戻るか確認
        Matango m27 = new Matango();
        assertEquals('A', m27.suffix, "Matango インスタンスの suffix が 'Z' になった後で 'A' に戻っていません。");

        // 28個目が 'B' に進むか確認
        Matango m28 = new Matango();
        assertEquals('B', m28.suffix, "循環後の Matango インスタンスの suffix が 'B' に進んでいません。");
    }
}
