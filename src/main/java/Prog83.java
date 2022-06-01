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
