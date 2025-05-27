package anagramaTest;

import org.example.question0.Anagrama;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramaTeste {

    private final Anagrama anagrama = new Anagrama();

    @Test
    public void testGenerateAnagrams_ThreeLetters() {
        List<String> result = anagrama.geradorAnagrama("abc");
        List<String> expected = List.of("abc", "acb", "bac", "bca", "cab", "cba");
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testGenerateAnagrams_SingleLetter() {
        List<String> result = anagrama.geradorAnagrama("a");
        List<String> expected = List.of("a");
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateAnagrams_EmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            anagrama.geradorAnagrama("");
        });
        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testGenerateAnagrams_NonLetterInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            anagrama.geradorAnagrama("ab1");
        });
        assertEquals("Input must contain only letters", exception.getMessage());
    }
}