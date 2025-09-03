package com.example.textanalyzer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.textanalyzer.TextanalyzerService;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TextanalyzerApplicationTests {

	@Test
	public void testAnalyzeVowels() {
		TextanalyzerService analyzerService = new TextanalyzerService();
		String input = "This is a test!";

		Map<String, Integer> expected = Map.of(
				"A", 1,
				"E", 1,
				"I", 2,
				"O", 0,
				"U", 0
		);

		List<LetterResult> result = analyzerService.analyzeVowels(input);

		Map<String, Integer> actualResult = new HashMap<>();
		for (LetterResult lr : result) {
			actualResult.put(lr.letter, lr.existence);
		}

		expected.forEach((letter, expectedCount) -> {
			assertEquals(expectedCount, actualResult.get(letter),
					String.format("Letter %s: expected %d, got %d", letter, expectedCount, actualResult.get(letter)));
		});
	}

}
