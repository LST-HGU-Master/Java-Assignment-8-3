# 課題 8-3: 静的メンバ

### 課題の説明
お化けキノコのsuffixが自動的に付けられるようにしたい。
そこで、次のインスタンスにつけるsuffixを保存しておくchar型の変数nextSuffixを静的フィールドに用意することでこれを実現する。
以下のMatangoクラスに静的フィールドとコンストラクタを追加しなさい。コンストラクタでsuffixを初期化すること。
ただしZまでいくとAに戻るように実装すること。
最後にProg83.javaのmainメソッドを実行し、実行例のようになることを確認しなさい。

ヒント：
char型はUnicodeにもとづいて文字を10進数で表した数値を持つ。
例えば、Unicodeでは`a`は`97`という数値が割り当てられている。
従って、`'A' + 1` という計算が可能であり、結果は `B`となる。



- お化けキノコクラスの雛形
```java
public class Matango
{
    char suffix;
    int hp;
    
}
```


### Prog83.java（このコードは提出不要）

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
お化けキノコAが誕生しました!
お化けキノコBが誕生しました!
// （以下略）
```
