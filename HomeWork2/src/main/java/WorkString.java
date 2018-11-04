import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WorkString {
    public static void main(String[] args)  throws FileNotFoundException {
        Scanner one1 = new Scanner(new FileInputStream("src/main/resources/string1.txt"));
        Scanner two1 = new Scanner(new FileInputStream("src/main/resources/string2.txt"));
        String one = one1.nextLine();
        String two = two1.nextLine();
        String[] oneArray = one.toLowerCase().split(" ");
        for (int i = 0; i < oneArray.length; i++) {
            boolean isContain1 = two.toLowerCase().contains(oneArray[i]);
            if (isContain1 == false) {
                System.out.println(oneArray[i]);
            }

        }
    }
}