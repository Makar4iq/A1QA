import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorkString2
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner  three1 = new Scanner(new FileInputStream("src/main/resources/string3.txt"));
        Scanner word1 = new Scanner(new FileInputStream("src/main/resources/word1.txt"));
        String three = three1.nextLine();
        String wordC = word1.nextLine();
        String word = wordC.toLowerCase();
        String four = three.replace(",", "").replace(".", "").replace("?", "").replace("!", "").replace(":", "");
        int symbols = three.length()-four.length();
        String[] fourArray = four.toLowerCase().split(" ");
        int count=0;
        for (int i=0; i < fourArray.length; i++)
            if (fourArray[i].contains(word))
                count++;
            else { }
        System.out.println("Слово "+ word +" повторяется "+ count + " раз(а)");
        System.out.println("Знаков припенания в строке " + symbols);

    }
}
