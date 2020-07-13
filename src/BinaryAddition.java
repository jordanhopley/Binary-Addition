/**
 *
 * The BinaryAddition class provides single function to allow the addition of two binary strings.
 *
 * @author Jordan Hopley
 *
 */
public class BinaryAddition {

    // Provide a working Java library with a function that solves the following problem:
    // Given two arbitrarily long strings representing two binary numbers, implement an
    // algorithm to add the two numbers and output the result as a third string.
    // Prove that the code solves the problem.

    /**
     *
     * Takes two strings representing two binary numbers, adds them together and returns the result.
     *
     * @param binaryStringOne The first binary string
     * @param binaryStringTwo The second binary string to be added onto the first
     * @return The result of adding binaryStringOne and binaryStringTwo
     */
    public static String addBinaryFromString(String binaryStringOne, String binaryStringTwo) {

        if (!binaryStringOne.matches("^[0-1]+") || !binaryStringTwo.matches("^[0-1]+")) {
            throw new InvalidStringException("Invalid input - Strings must contain a combination of 0's and 1's with no other characters.");
        }

        String binaryResult = "";

        int i = 0;
        int carry = 0;

        // While i is less than whichever string contains most bits.
        while (i < binaryStringOne.length() || i < binaryStringTwo.length()) {

            // Iterate from the end to the start as i increases. If one string contains more bits, 0's are added to the smaller string.
            int bitOne = i <= (binaryStringOne.length() - 1) ? Character.getNumericValue(binaryStringOne.charAt((binaryStringOne.length() - 1) - i)) : 0;
            int bitTwo = i <= (binaryStringTwo.length() - 1) ? Character.getNumericValue(binaryStringTwo.charAt((binaryStringTwo.length() - 1) - i)) : 0;

            int bitResult = bitOne + bitTwo + carry;

            // If result is 2 or 3, then the carry is 1.
            carry = bitResult > 1 ? 1 : 0;
            // If result is 0 or 2, then the result is 0.
            // If result is 1 or 3, then the result is 1.
            bitResult = bitResult % 2;

            // Add result to resulting string.
            binaryResult = binaryResult.concat(Integer.toString(bitResult));

            i++;

        }

        // Add the final carry
        if (carry > 0) binaryResult = binaryResult.concat(Integer.toString(carry));

        // Flip the string since the bit results were added from the end first.
        return new StringBuilder(binaryResult).reverse().toString();

    }

}
