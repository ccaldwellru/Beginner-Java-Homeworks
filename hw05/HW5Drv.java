import java.util.*;

public class HW5Drv {

public static boolean testIntMakeString(int[] arr) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    String regex = "[^0-9]*";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        regex += "" + arr[ii] + "[^0-9]+";
    }
    if (arr.length > 0) {
        regex += "" + arr[arr.length - 1] + "[^0-9]*";
    }
    String out = obj.makeString(arr);
    if (out.matches(regex)) {
        System.out.println("      makeString(int[]): " + makeString(arr) + " --> " + out);
    } else {
        System.out.println("FAIL: makeString(int[]): " + makeString(arr) + " --> " + out);
        testPassed = false;
    }
    return testPassed;
}

public static boolean testCharMakeString(char[] arr) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    String regex = ".*";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        regex += "" + arr[ii] + ".+";
    }
    if (arr.length > 0) {
        regex += "" + arr[arr.length - 1] + ".*";
    }
    String out = obj.makeString(arr);
    if (out.matches(regex)) {
        System.out.println("      makeString(char[]): " + makeString(arr) + " --> " + out);
    } else {
        System.out.println("FAIL: makeString(char[]): " + makeString(arr) + " --> " + out);
        testPassed = false;
    }
    return testPassed;
}

public static boolean testEncodeDecode(String input) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    int[] encodedInput = obj.encode(input);
    if (encodedInput.length != input.length()) {
        System.out.println("\nFAIL: encode: output array length does not match input String length.");
        System.out.println("FAIL: encode: <" + input + "> --> " + makeString(encodedInput) + "\n");
        testPassed = false;
    } else {
        System.out.println("      encode: <" + input + "> --> " + makeString(encodedInput));
        String decodedInput = obj.decode(encodedInput);
        if (!decodedInput.equals(input)) {
            System.out.println("\nFAIL: decode: output does not match input String.");
            System.out.println("FAIL: decode: <" + input + "> --> <" + decodedInput + ">\n");
            testPassed = false;
        } else {
            System.out.println("      decode: <" + input + "> --> <" + decodedInput + ">");
        }
    }
    return testPassed;
}

public static boolean testFilter(boolean[] mask, char[] message, char[] expectedOutput) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    char[] output = obj.filter(mask, message);
    if (Arrays.equals(output, expectedOutput)) {
        System.out.println("      filter: expected: " + makeString(expectedOutput) + " output: " + makeString(output));
    } else {
        System.out.println("\nFAIL: filter: mask: " + makeString(mask) + " message: " + makeString(message));
        System.out.println("FAIL: filter: expected: " + makeString(expectedOutput) + " output: " + makeString(output) + "\n");
        testPassed = false;
    }
    return testPassed;
}

public static boolean testIndexMessage(int[] message, char[] letters, String expectedOutput) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    String output = obj.indexMessage(message, letters);
    if (output.equals(expectedOutput)) {
        System.out.println("      filter: expected: <" + expectedOutput + ">  output: <" + output + ">");
    } else {
        System.out.println("\nFAIL: filter: message: " + makeString(message) + " letters: " + makeString(letters));
        System.out.println("FAIL: filter: expected: <" + expectedOutput + ">  output: <" + output + ">\n");
        testPassed = false;
    }
    return testPassed;
}

public static boolean testAcronymize(String[] words, String expectedOutput) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    String output = obj.acronymize(words);
    if (output.equals(expectedOutput)) {
        System.out.println("      filter: expected: <" + expectedOutput + ">  output: <" + output + ">");
    } else {
        System.out.println("\nFAIL: filter: words: " + makeString(words));
        System.out.println("FAIL: filter: expected: <" + expectedOutput + ">  output: <" + output + ">\n");
        testPassed = false;
    }
    return testPassed;
}

public static boolean testLetterCount(String text, int[] expectedOutput) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    int[] output = obj.letterCount(text);
    String displayText = text;
    if (text.length() > 50) {
        displayText = displayText.substring(0,50) + "...";
    }
    if (Arrays.equals(output, expectedOutput)) {
        System.out.println("      filter: passed input: " + displayText);
    } else {
        System.out.println("\nFAIL: filter: input: " + displayText);
        System.out.println("FAIL:                     a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z");
        System.out.println("FAIL: filter: expected: " + makeFormattedString(expectedOutput));
        System.out.println("FAIL: filter:   output: " + makeFormattedString(output) + "\n");
        testPassed = false;
    }
    return testPassed;
}

public static boolean testHighestLetterCount(int[] letterCount, char expectedOutput) {
    HW5Srv obj = new HW5Srv();
    boolean testPassed = true;
    char output = obj.highestLetterCount(letterCount);
    if (output == expectedOutput) {
        System.out.println("      highestLetterCount: expected: '" + expectedOutput + "' output: '" + output + "'");
    } else {
        System.out.println("\nFAIL:                                    a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z");
        System.out.println("FAIL: highestLetterCount: letterCount: " + makeFormattedString(letterCount));
        System.out.println("      highestLetterCount: expected: '" + expectedOutput + "' output: '" + output + "'\n");
        testPassed = false;
    }
    return testPassed;
}

public static void main(String[] args) {
    // --- makeString(int[]) ------------------------------------------------------------
    System.out.println("--- testing makeString(int[]) -------------------------------------------------|\n");
    int sumMethodTestsFailed = 0;

    if (!testIntMakeString(new int[]{})) {
        sumMethodTestsFailed++;
    }

    if (!testIntMakeString(new int[]{0})) {
        sumMethodTestsFailed++;
    }

    if (!testIntMakeString(new int[]{6, 2})) {
        sumMethodTestsFailed++;
    }

    if (!testIntMakeString(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 8, 1, 44353, 851, 2, 2})) {
        sumMethodTestsFailed++;
    }

    if (!testIntMakeString(new int[]{7666, 6555, 4555, 4333, 23343, 11212})) {
        sumMethodTestsFailed++;
    }

    // --- makeString(int[]) summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The makeString(int[]) methods passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The makeString(int[]) methods passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The makeString(int[]) methods failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- makeString(char[]) ------------------------------------------------------------
    System.out.println("--- testing makeString(char[]) -------------------------------------------------|\n");
    sumMethodTestsFailed = 0;

    if (!testCharMakeString(new char[]{})) {
        sumMethodTestsFailed++;
    }

    if (!testCharMakeString(new char[]{'w'})) {
        sumMethodTestsFailed++;
    }

    if (!testCharMakeString(new char[]{'8', 'w'})) {
        sumMethodTestsFailed++;
    }

    if (!testCharMakeString(new char[]{'&', '5', ' ', '^', 'E', 't', 'c', '.', '|', '%', 'q', 'f', 'Z', 'z'})) {
        sumMethodTestsFailed++;
    }

    // --- makeString(char[]) summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The makeString(char[]) methods passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The makeString(char[]) methods passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The makeString(char[]) methods failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- encode/decode ------------------------------------------------------------
    System.out.println("--- testing encode and decode methods -----------------------------------------|\n");
    sumMethodTestsFailed = 0;

    if (!testEncodeDecode("dog")) {
        sumMethodTestsFailed++;
    }

    if (!testEncodeDecode("cat")) {
        sumMethodTestsFailed++;
    }

    if (!testEncodeDecode("dog!")) {
        sumMethodTestsFailed++;
    }

    if (!testEncodeDecode("dog-eat-dog")) {
        sumMethodTestsFailed++;
    }

    if (!testEncodeDecode("Wilson! Have you put the dog out this morning?")) {
        sumMethodTestsFailed++;
    }

    // --- encode/decode summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The encode and decode methods passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The encode and decode methods passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The encode and decode methods failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- filter ------------------------------------------------------------
    System.out.println("--- testing filter method -----------------------------------------------------|\n");
    sumMethodTestsFailed = 0;

    if (!testFilter(new boolean[]{false}, new char[]{'E'}, new char[0])) {
        sumMethodTestsFailed++;
    }

    if (!testFilter(new boolean[]{true}, new char[]{'q'}, new char[]{'q'})) {
        sumMethodTestsFailed++;
    }

    if (!testFilter(new boolean[]{true, false, true, false, true}, "drong".toCharArray(), "dog".toCharArray())) {
        sumMethodTestsFailed++;
    }

    if (!testFilter(new boolean[]{true, false, false, false, false, false, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, true, true, true, true}, 
            "I wore gloves last time I walked with Jill on lava.".toCharArray(), "I love Java.".toCharArray())) {
        sumMethodTestsFailed++;
    }

    // --- filter summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The filter method passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The filter method passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The filter method failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- indexMessage ------------------------------------------------------------
    System.out.println("--- testing indexMessage method -----------------------------------------------|\n");
    sumMethodTestsFailed = 0;

    int[] myMsg = new int[]{ 0 };
    char[] myLetters = new char[]{'Q'};
    if (!testIndexMessage(myMsg, myLetters, "Q")) {
        sumMethodTestsFailed++;
    }

    myLetters = new char[]{'T', 'A', 'P'};

    myMsg = new int[]{ 0, 1, 2 };
    if (!testIndexMessage(myMsg, myLetters, "TAP")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 2, 1, 0 };
    if (!testIndexMessage(myMsg, myLetters, "PAT")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 1, 2, 0 };
    if (!testIndexMessage(myMsg, myLetters, "APT")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 5, 2, 3, 0, 4, 2, 1, 4, 6, 2, 3, 0 };
    myLetters = new char[]{'S', 'N', 'O', 'G', ' ', 'D', 'L'};
    if (!testIndexMessage(myMsg, myLetters, "DOGS ON LOGS")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 2, 5, 1, 2, 6, 4, 5, 3, 2, 6, 4, 0 };
    myLetters = new char[]{'S', 'L', 'I', 'B', 'E', ' ', 'K'};
    if (!testIndexMessage(myMsg, myLetters, "I LIKE BIKES")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 6, 5, 4, 4, 0, 3, 2, 1, 2, 2, 0 };
    myLetters = new char[]{'Y', 'U', 'P', ' ', 'L', 'I', 'S'};
    if (!testIndexMessage(myMsg, myLetters, "SILLY PUPPY")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 4, 1, 1, 0, 3, 5, 2, 3, 6, 1, 1, 0 };
    myLetters = new char[]{'D', 'O', 'S', ' ', 'F', 'I', 'G'};
    if (!testIndexMessage(myMsg, myLetters, "FOOD IS GOOD")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 1, 2, 0, 6, 4, 3, 2, 4, 2, 5, 6, 4, 3 };
    myLetters = new char[]{'H', 'I', ' ', 'R', 'A', 'B', 'E'};
    if (!testIndexMessage(myMsg, myLetters, "I HEAR A BEAR")) {
        sumMethodTestsFailed++;
    }

    myMsg = new int[]{ 5, 6, 2, 4, 3, 1, 0, 3, 7, 6, 2, 4 };
    myLetters = new char[]{'N', 'O', 'T', ' ', 'S', 'C', 'A', 'M' };
    if (!testIndexMessage(myMsg, myLetters, "CATS ON MATS")) {
        sumMethodTestsFailed++;
    }

    // --- indexMessage summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The indexMessage method passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The indexMessage method passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The indexMessage method failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- acronymize ------------------------------------------------------------
    System.out.println("--- testing acronymize method -------------------------------------------------|\n");
    sumMethodTestsFailed = 0;

    String[] words = new String[]{"And", "It", "is", "not", "How"};
    if (!testAcronymize(words, "")) {
        sumMethodTestsFailed++;
    }

    words = new String[0];
    if (!testAcronymize(words, "")) {
        sumMethodTestsFailed++;
    }

    words = new String[]{"Room232"};
    if (!testAcronymize(words, "R")) {
        sumMethodTestsFailed++;
    }

    words = new String[]{"Bureau", "of", "Ridiculously", "Long", "Acronyms", "and", "Other", "Such", "Inconveniences"};
    if (!testAcronymize(words, "BRLAOSI")) {
        sumMethodTestsFailed++;
    }

    words = new String[]{"Solicitations", "another", "long", "arduous", "and", "mediocre", "Invective"};
    if (!testAcronymize(words, "SALAMI")) {
        sumMethodTestsFailed++;
    }

    // --- acronymize summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The acronymize method passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The acronymize method passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The acronymize method failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- letterCount ------------------------------------------------------------
    System.out.println("--- testing letterCount method -------------------------------------------------|\n");
    sumMethodTestsFailed = 0;

    String text = "";
    int[] count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    text = "H";
    count = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    text = "a";
    count = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    text = "z";
    count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    text = "bbb";
    count = new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    text = "Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.";
    count = new int[]{12,  3, 10,  2, 13,  2,  1,  8,  6,  3,  0,  9,  3,  3,  8,  2,  0,  7, 18, 10,  2,  1,  0,  0,  3,  0}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    text = "We're knights of the Round Table, we dance whene'er we're able. We do routines and chorus scenes with footwork impec-cable, We dine well here in Camelot, we eat ham and jam and Spam a lot. / We're knights of the Round Table, our shows are for-mi-dable. But many times we're given rhymes that are quite un-sing-able, We're opera mad in Camelot, we sing from the diaphragm a lot. / In war we're tough and able, Quite in-de-fa-ti-gable. Between our quests we sequin vests and impersonate Clark Gable / It's a busy life in Camelot.";
    count = new int[]{37, 12,  9, 14, 64,  7,  9, 15, 24,  1,  4, 18, 15, 27, 23,  5,  4, 25, 21, 29, 14,  2, 19,  0,  3,  0}; 
    if (!testLetterCount(text, count)) {
        sumMethodTestsFailed++;
    }

    // --- letterCount summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The letterCount method passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The letterCount method passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The letterCount method failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

    // --- highestLetterCount ------------------------------------------------------------
    System.out.println("--- testing highestLetterCount method -------------------------------------------------|\n");
    sumMethodTestsFailed = 0;

    count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testHighestLetterCount(count, 'a')) {
        sumMethodTestsFailed++;
    }

    count = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testHighestLetterCount(count, 'a')) {
        sumMethodTestsFailed++;
    }

    count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}; 
    if (!testHighestLetterCount(count, 'z')) {
        sumMethodTestsFailed++;
    }

    count = new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testHighestLetterCount(count, 'b')) {
        sumMethodTestsFailed++;
    }

    count = new int[]{0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0}; 
    if (!testHighestLetterCount(count, 'e')) {
        sumMethodTestsFailed++;
    }

    count = new int[]{12,  3, 10,  2, 13,  2,  1,  8,  6,  3,  0,  9,  3,  3,  8,  2,  0,  7, 18, 10,  2,  1,  0,  0,  3,  0}; 
    if (!testHighestLetterCount(count, 's')) {
        sumMethodTestsFailed++;
    }

    count = new int[]{37, 12,  9, 14, 64,  7,  9, 15, 24,  1,  4, 18, 15, 27, 23,  5,  4, 25, 21, 29, 14,  2, 19,  0,  3,  0}; 
    if (!testHighestLetterCount(count, 'e')) {
        sumMethodTestsFailed++;
    }

    // --- highestLetterCount summary ----------------------------------------------------
    if (sumMethodTestsFailed == 0) {
        System.out.println("\n*** The highestLetterCount method passed all tests!\n");
    } else if (sumMethodTestsFailed == 1) {
        System.out.println("\n*** The highestLetterCount method passed all but one test- getting close!\n");
    } else {
        System.out.println("\n*** The highestLetterCount method failed " + sumMethodTestsFailed + " tests. More work to do...\n");
    }

}

public static String makeString(boolean[] arr) {
    String out = "[";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        out += "" + (arr[ii]?"T":"f") + ", ";
    }
    if (arr.length == 0) {
        out += " ]";
    } else {
        out += "" + (arr[arr.length - 1]?"T":"f") + "]";
    }
    return out;
}

public static String makeString(int[] arr) {
    String out = "[";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        out += "" + arr[ii] + ", ";
    }
    if (arr.length == 0) {
        out += " ]";
    } else {
        out += "" + arr[arr.length - 1] + "]";
    }
    return out;
}

public static String makeFormattedString(int[] arr) {
    String out = "[";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        if (arr[ii] > 9) {
            out += "" + arr[ii] + ", ";
        } else {
            out += " " + arr[ii] + ", ";
        }
    }
    if (arr.length == 0) {
        out += " ]";
    } else {
        if (arr[arr.length - 1] > 9) {
            out += "" + arr[arr.length - 1] + "]";
        } else {
            out += " " + arr[arr.length - 1] + "]";
        }
    }
    return out;
}

public static String makeString(char[] arr) {
    String out = "[";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        out += "'" + arr[ii] + "', ";
    }
    if (arr.length == 0) {
        out += " ]";
    } else {
        out += "'" + arr[arr.length - 1] + "']";
    }
    return out;
}

public static String makeString(String[] arr) {
    String out = "[";
    for (int ii = 0; ii < arr.length - 1; ii++) {
        out += "\"" + arr[ii] + "\", ";
    }
    if (arr.length == 0) {
        out += " ]";
    } else {
        out += "\"" + arr[arr.length - 1] + "\"]";
    }
    return out;
}

}
