import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        try{
            int minLength = 4;
            File in = new File("C:\\Users\\mw\\Desktop\\Coding\\Helloword\\src\\words.txt");
            Scanner reader = new Scanner(in);
            Palindrome palindrome = new Palindrome();
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                if (word.length() >= minLength && palindrome.isPalindrome(word))
                    System.out.println(word);
            }
        } catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
/* Uncomment this class once you've written isPalindrome. */