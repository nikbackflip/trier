package tryer.CTCI;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

class IsUnique {

    // O(n^2) - brute force
    public static boolean isUnique_noAuxDS(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for(int j = i+1; j < chars.length; j++) {
                if(chars[i] == chars[j]) return false;
            }
        }
        return true;
    }

    //O(n)
    public static boolean isUnique_auxDS(String str) {
        char[] chars = str.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            charSet.add(chars[i]);
        }
        if (charSet.size() == str.length()) return true;
        return false;
    }

    //O(n)
    public static boolean isUnique_noAuxDS_sorted(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i] == chars[i+1]) return false;
        }
        return true;
    }


    @Test
    public void uniqueStringIsDetected() {
        String str = "abcdefghijk";

        assertTrue(isUnique_noAuxDS(str));
        assertTrue(isUnique_auxDS(str));
        assertTrue(isUnique_noAuxDS_sorted(str));
    }
    @Test
    public void emptyStringIsUnique() {
        String str = "";

        assertTrue(isUnique_noAuxDS(str));
        assertTrue(isUnique_auxDS(str));
        assertTrue(isUnique_noAuxDS_sorted(str));
    }

    @Test
    public void singleCharacterIsUnique() {
        String str = "s";

        assertTrue(isUnique_noAuxDS(str));
        assertTrue(isUnique_auxDS(str));
        assertTrue(isUnique_noAuxDS_sorted(str));
    }

    @Test
    public void repeatingElementsIdentifies() {
        String str = "ababababab";

        assertFalse(isUnique_noAuxDS(str));
        assertFalse(isUnique_auxDS(str));
        assertFalse(isUnique_noAuxDS_sorted(str));
    }

    @Test
    public void repeatingElementsIdentifiesOnBoundaries() {
        String str = "abcdefjhigla";

        assertFalse(isUnique_noAuxDS(str));
        assertFalse(isUnique_auxDS(str));
        assertFalse(isUnique_noAuxDS_sorted(str));
    }

    @Test
    public void largeString() {
        String str = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR888888888888888888888888888888888888888888888888888888888888888000000000000000000000000000000000000000000000000000000000000000000000000000000000kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkdddddddddddddddddddddddddddddddddddddddddddddddddddddd";

        assertFalse(isUnique_noAuxDS(str));
        assertFalse(isUnique_auxDS(str));
        assertFalse(isUnique_noAuxDS_sorted(str));
    }

}
