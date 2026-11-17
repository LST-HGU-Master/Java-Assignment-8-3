# 課題 8-3: 静的メンバ

### 課題の説明
課題8-1ではプログラマがコード内で手作業で割り当てていたお化けキノコの `suffix` が、インスタンス生成時に自動的に決まるようにしたい。
そこで、次に生成するインスタンスに割り当てる文字を保持する `char` 型の静的フィールド `nextSuffix` を用いて実現しよう。

以下に示す `Matango` クラスの雛形に**静的フィールド**と**コンストラクタ**を追加しなさい。  
追加後、`Prog83` クラスの `main` メソッドを実行し、実行例と同じ出力が得られることを確認しなさい。

なお、`Prog83` クラスには変更を加えないので提出は不要とする。

#### 【追加するメンバの仕様】

| 種類 | 宣言・引数リスト | 処理内容・仕様 |
| :--- | :--- | :--- |
| 静的フィールド | `static char nextSuffix = 'A';` | 次に生成するインスタンスの `suffix` に割り当てる文字を保持する（初期値は `'A'`）。 |
| コンストラクタ | `public Matango()`（引数なし） | 現在の `nextSuffix` の値を自身の `suffix` に代入する。<br>その後、次のインスタンスのために `nextSuffix` を次のアルファベット（`'A'`→`'B'`→`'C'`…）へ進める。<br>ただし、`'Z'` を割り当てた後は、再び `'A'` に戻るようにすること。（`hp` の初期化は不要） |

> **ヒント**
> `char` 型は文字コード（Unicode）にもとづく数値として扱うことができます（例：`'A'` は 65、`'B'` は 66）。
> そのため、`nextSuffix++;` のようにインクリメント演算子を使うか、`(char)(nextSuffix + 1)` のように `char` 型へキャストすることで次の文字へ進めることができます（キャストなしの `nextSuffix + 1` は `int` 型になるため注意）。



- **Matango.java**
```java
public class Matango
{
    char suffix;
    int hp;

    // ここに静的フィールドとコンストラクタを追加する
}
```


- Prog83クラス（このコードは提出不要）

```java
public class Prog83 {

    public static void main(String[] args) {
        Matango m1 = new Matango();
        System.out.println("お化けキノコ" + m1.suffix + "が誕生しました！");
        Matango m2 = new Matango();
        System.out.println("お化けキノコ" + m2.suffix + "が誕生しました！");            
            
        Matango [] mts = new Matango[27];
        for( Matango mt: mts){
            mt = new Matango();
            System.out.println( "お化けキノコ" + mt.suffix + "が誕生しました！");
        }
    }

}
```

### 実行例
```
お化けキノコAが誕生しました！
お化けキノコBが誕生しました！
// （途中省略）
お化けキノコZが誕生しました！
お化けキノコAが誕生しました！
お化けキノコBが誕生しました！
お化けキノコCが誕生しました！
```
