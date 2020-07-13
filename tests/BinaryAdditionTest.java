import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryAdditionTest {

    @Test
    void addEqualLengthBinary() {
        assertEquals("11011", BinaryAddition.addBinaryFromString("1101", "1110"));
    }

    @Test
    void addDifferentLengthBinary() {
        assertEquals("10000001011", BinaryAddition.addBinaryFromString("1111111101", "1110"));
    }

    @Test
    void addVeryBigBinary() {
        assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000111000000000000000000000000000000000000000000000000000000000000000000000001111011", BinaryAddition.addBinaryFromString("111000000000000000000000000000000000000000000000000000000000000000000000001111101", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110"));
    }

    @Test
    void addVerySmallBinary() {
        assertEquals("10", BinaryAddition.addBinaryFromString("1", "1"));
    }

    @Test
    void nonZeroAndOneString() {
        try {
            BinaryAddition.addBinaryFromString("1002394194", "1111");
            fail("Should have caught error.");
        } catch (InvalidStringException e) {
            assert(true);
        }
    }

    @Test
    void spaceInString() {
        try {
            BinaryAddition.addBinaryFromString("1111 10", "1111")  ;
            fail("Should have caught error.");
        } catch (InvalidStringException e) {
            assert(true);
        }
    }

    @Test
    void nullString() {
        try {
            BinaryAddition.addBinaryFromString(null, null)  ;
            fail("Should have caught error.");
        } catch (Exception e) {
            assert(true);
        }
    }

}