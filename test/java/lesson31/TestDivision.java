package lesson31;

import by.tms.lesson31.additionaltask1.Division;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDivision {

    private static Division division;

    @BeforeAll
    private static void init() {
        division = new Division();
    }

    @ParameterizedTest
    @MethodSource("testDivideParams")
    public void testDivide(Long first, Long second, Long expected) {
        Long actual = division.divide(first, second);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testDivideParams() {
        return Stream.of(
                Arguments.of(9L, 9L, 1L),
                Arguments.of(27L, 3L, 9L),
                Arguments.of(54L, 6L, 9L),
                Arguments.of(55L, 6L, 9L),
                Arguments.of(null, null, 0L),
                Arguments.of(null, 2L, 0L),
                Arguments.of(0L, null, 0L)
        );
    }
}
