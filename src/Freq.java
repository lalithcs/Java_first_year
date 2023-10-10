import java.util.Arrays;
import java.util.Scanner;

public class Freq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.nextLine();
        in.close();
        // Tokenize the input string into words
        String[] words = input.split("\\s+");
        // Sort the words in lexicographical order
        Arrays.sort(words);
        int wordCount = 1;
        // Count and print word frequencies
        for (int i = 1; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(words[i - 1])) {
                wordCount++;
            } else {
                System.out.println(words[i - 1] + ": " + wordCount);
                wordCount = 1;
            }
        }
        // Print the frequency of the last word
        if (words.length > 0) {
            System.out.println(words[words.length - 1] + ": " + wordCount);
        }
    }
}
