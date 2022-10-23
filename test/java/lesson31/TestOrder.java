package lesson31;

import by.tms.lesson31.task1.Item;
import by.tms.lesson31.task1.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrder {

    private static Order order;

    @BeforeAll
    private static void init() {
       order = new Order();
    }

    @ParameterizedTest
    @MethodSource("testAddItemParams")
    public void testAddItem(Integer expected, Item...items) {
        Integer actual = order.addItems(items);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testAddItemParams() {
        return Stream.of(
                Arguments.of(4, new Item[4]),
                Arguments.of(3, new Item[3]),
                Arguments.of(2, new Item[2]),
                Arguments.of(1, new Item[1]),
                Arguments.of(0, null)
        );
    }
}
