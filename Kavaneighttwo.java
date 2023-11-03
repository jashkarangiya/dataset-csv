public class Kavaneighttwo {

    public static void rabinKarpSearch(String text, String pattern, int q) {
        int n = text.length();
        int m = pattern.length();
        int d = 256; // Number of characters in the input alphabet

        // Calculate hash value for the pattern and the first window of text
        int patternHash = calculateHash(pattern, m, q);
        int textHash = calculateHash(text, m, q);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (areEqual(text, pattern, i)) {
                    System.out.println("Pattern found at position " + i);
                }
            }

            if (i < n - m) {
                textHash = recalculateHash(text, m, textHash, i, q, d);
                if (textHash < 0) {
                    textHash += q;
                }
            }
        }
    }

    public static int calculateHash(String str, int len, int q) {
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * d + str.charAt(i)) % q;
        }
        return hash;
    }

    public static int recalculateHash(String str, int len, int hash, int oldIndex, int q, int d) {
        int newHash = (hash - str.charAt(oldIndex) * (int) Math.pow(d, len - 1)) * d + str.charAt(oldIndex + len);
        return newHash % q;
    }

    public static boolean areEqual(String text, String pattern, int startIndex) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(startIndex + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text1 = "2359023141526739921";
        String pattern1 = "31415";
        int q1 = 13;
        System.out.println("Test Case 1:");
        rabinKarpSearch(text1, pattern1, q1);

        String text2 = "ABAAABCDBBABCDDEBCABC";
        String pattern2 = "ABC";
        int q2 = 101;
        System.out.println("\nTest Case 2:");
        rabinKarpSearch(text2, pattern2, q2);
    }
}
