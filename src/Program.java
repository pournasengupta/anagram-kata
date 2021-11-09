import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws IOException {
		System.out.println("Enter word to find anagrams for: ");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		Anagram anagramsFinder = new Anagram();
        List<String> anagrams = Anagram(records);
        // Error is line above. Tried replacing AnagramsFinder(word) with Anagram(word)
        System.out.println(String.join(", ", anagrams));
        System.in.read();
        scanner.close();
	}
}
