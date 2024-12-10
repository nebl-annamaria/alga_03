import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RemovalGameTest {
	private String readFile(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	private static Stream<Object[]> testCases() throws IOException {
		String testCasesDir = "src/test/cses_testfiles/";

		return Files.list(Paths.get(testCasesDir))
				.filter(path -> path.toString().endsWith(".in"))
				.map(path -> new Object[]{path.toString(), path.toString().replace(".in", ".out")})
				.filter(pair -> Files.exists(Paths.get(pair[1].toString())))
				.toList()
				.stream();
	}

	@ParameterizedTest(name = "Test {index}: {0}")
	@MethodSource("testCases")
	void testFromFiles(String inputFile, String outputFile) throws IOException {
		String input = readFile(inputFile);
		String expectedOutput = readFile(outputFile).trim();

		String[] lines = input.split("\n");
		int n = Integer.parseInt(lines[0]);
		long[] numbers = Stream.of(lines[1].split(" "))
				.mapToLong(Long::parseLong)
				.toArray();

		RemovalGame game = new RemovalGame();
		long actualOutput = game.maxScore(numbers);

		assertEquals(Long.parseLong(expectedOutput), actualOutput,
				String.format("Failed for input file: %s", inputFile));
	}

}