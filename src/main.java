import static java.nio.file.Files.lines;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import java.io.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class main {
	private final Map<Object, List<String>> dict;

	public main(List<String> words) {
		this.dict = words
				.parallelStream()
				.collect(Collectors.groupingBy(word -> word.length()));
	}

	public main(Path path, Charset charset) throws IOException {
		this(lines(path, charset)
				.map(line -> line.trim())
				.filter(line -> !line.isEmpty())
				.collect(toList()));
	}

	public static void Anagram(String[] args) {
		List<List<String>> records = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"))){
				String line;
				while ((line = br.readLine()) != null)) {
					// RESOLVED: replace COMMA_DELIMITER inside .split with " " for space delimiter
					String[] values = line.split(" "); // Am I supposed to inititalize this somewhere or should this be replaced
					// Each split is appended into the records ArrayList created in line 30
					records.add(Arrays.asList(values)); // Array?
				}
			}
		// RESOLVED: Replaces arrayList with records
		int size = records.size(); // Records[i].size()?
		for (int i = 0; i < size; i++) {
			//Replaced ArrayList with records
			// Still throwing error!!!!
			Anagram.Finder(String[] args, records[i]);
			//should this be records[i]?
		}
	}

    //added the method above

	public List<String> of(String input) {
		if (input == null || input.trim().isEmpty())
			return new ArrayList<>();
		return proceed(input);
	}

	private List<String> proceed(String input) {
		return dict.getOrDefault(input.length(), new ArrayList<>())
				.parallelStream()
				.filter(word -> isAnagram(word, input))
				.sorted()
				.collect(toList());
	}

	private boolean isAnagram(String input, String word) {
		return !input.equals(word) && containsSameChars(input, word);
	}

	private boolean containsSameChars(String word1, String word2) {
		return sortLetters(word1).equals(sortLetters(word2));
	}

	private List<String> sortLetters(String input) {
		return asList(input.split(""))
				.stream()
				.sorted()
				.collect(toList());
	}
}