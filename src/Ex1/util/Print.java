package Ex1.util;

/**
 * @author Guan
 * @date 2023/5/19 9:05
 */
public class Print {

    public static void print(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }


}
