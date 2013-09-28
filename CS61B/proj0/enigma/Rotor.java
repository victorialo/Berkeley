package enigma;

/**
 * Class that represents a rotor in the enigma machine.
 * @author Victoria Lo
 */
class Rotor {
    /**
     * r is name.
     */
    private final String r;

    /**
     * @return
     */
    String getR() {
        return r;
    }

    /**
     * @param NAME
     * @param SETTING
     */
    public Rotor(String name, int setting) {
        r = name;
        _setting = setting;
    }

    /** Size of alphabet used for plaintext and ciphertext. */
    static final int ALPHABET_SIZE = 26;

    /**
     * Assuming that P is an integer in the range 0..25, returns the
     * corresponding upper-case letter in the range A..Z.
     */
    static char toLetter(int p) {
        p = (ALPHABET_SIZE + p) % ALPHABET_SIZE;
        char[] letters;
        letters =
            new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z' };
        return letters[p];
    }

    /**
     * Assuming that C is an upper-case letter in the range A-Z, return the
     * corresponding index in the range 0..25. Inverse of toLetter.
     */
    static int toIndex(char c) {
        char[] letters;
        letters =
            new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z' };
        int g = -1;
        for (int i = 0; i < ALPHABET_SIZE; i += 1) {
            if (c == letters[i]) {
                g = i;
            }
        }
        return g;
    }

    /** Returns true iff this rotor has a ratchet and can advance. */
    boolean advances() {
        return true;
    }

    /** Returns true iff this rotor has a left-to-right inverse. */
    boolean hasInverse() {
        return true;
    }

    /**
     * Return my current rotational setting as an integer between 0 and 25
     * (corresponding to letters 'A' to 'Z').
     */
    int getSetting() {
        return _setting;
    }

    /** Set getSetting() to POSN. */
    void set(int posn) {
        assert 0 <= posn && posn < ALPHABET_SIZE;
        _setting = posn;
    }

    /**
     * Return the conversion of P (an integer in the range 0..25) according to
     * my permutation.
     */
    int convertForward(int p) {
        p = (ALPHABET_SIZE + p) % ALPHABET_SIZE;
        String[] names;
        names =
            new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
                "BETA", "GAMMA", "B", "C" };
        for (int i = 0; i < names.length; i += 1) {
            if (r.equals(names[i])) {
                p = (ALPHABET_SIZE + (p + _setting)) % ALPHABET_SIZE;
                char a;
                a = PermutationData.ROTOR_SPECS[i][1].charAt(p);
                int ind = toIndex(a);
                p = (ind - _setting) % ALPHABET_SIZE;
            }
        }
        return p;
    }

    /**
     * Return the conversion of E (an integer in the range 0..25) according to
     * the inverse of my permutation.
     */
    int convertBackward(int e) {
        e = (ALPHABET_SIZE + e) % ALPHABET_SIZE;
        String[] names;
        names =
            new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
                "BETA", "GAMMA" };
        for (int i = 0; i < names.length; i += 1) {
            if (r.equals(names[i])) {
                e = (ALPHABET_SIZE + (e + _setting)) % ALPHABET_SIZE;
                char b;
                b = PermutationData.ROTOR_SPECS[i][2].charAt(e);
                int ind = toIndex(b);
                e = (ind - _setting) % ALPHABET_SIZE;
            }
        }
        return e;
    }

    /**
     * Returns true iff I am positioned to allow the rotor to my left to
     * advance.
     */
    boolean atNotch() {
        String[] names;
        names =
            new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII" };
        for (int i = 0; i < names.length; i += 1) {
            if (r.equals(names[i])) {
                String notches;
                notches = PermutationData.ROTOR_SPECS[i][3];
                return notches.indexOf(toLetter(_setting)) >= 0;
            }
        }
        return false;
    }

    /** Advance me one position. */
    void advance() {
        int a = 1 + _setting;
        _setting = a % ALPHABET_SIZE;
    }

    /**
     * My current setting (index 0..25, with 0 indicating that 'A' is showing).
     */
    private int _setting;

}
