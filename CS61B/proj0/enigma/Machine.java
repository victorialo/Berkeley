package enigma;

/**
 * Class that represents a complete enigma machine.
 * @author Victoria Lo
 */
class Machine {
    /**
     * make rotors.
     */
    private Rotor[] rotors;

    /**
     * @return
     */
    Rotor[] getRotors() {
        return rotors;
    }

    /**
     * Set my rotors to (from left to right) ROTORS. Initially, the rotor
     * settings are all 'A'.
     * @param ROTORS2
     */
    void replaceRotors(Rotor[] rotors2) {
        rotors = rotors2;
    }

    /**
     * Set my rotors according to SETTING, which must be a string of four
     * upper-case letters. The first letter refers to the leftmost rotor
     * setting.
     */
    void setRotors(String setting) {
        char[] seta = setting.toCharArray();
        rotors[1].set(seta[0]);
        rotors[2].set(seta[1]);
        rotors[3].set(seta[2]);
        rotors[4].set(seta[3]);
    }

    /**
     * Returns the encoding/decoding of MSG, updating the state of the rotors
     * accordingly.
     */
    String convert(String msg) {
        msg = Main.standardize(msg);
        char[] input = msg.toCharArray();
        if (rotors[3].atNotch()) {
            rotors[2].advance();
            rotors[3].advance();
        } else if (rotors[4].atNotch()) {
            rotors[3].advance();
        }
        rotors[4].advance();
        for (int i = 0; i < input.length; i += 1) {
            int numi = Rotor.toIndex(input[i]);
            for (int k = 4; k >= 0; k -= 1) {
                numi = rotors[k].convertForward(numi);
            }
            for (int l = 1; l <= 4; l += 1) {
                numi = rotors[l].convertBackward(numi);
            }
            input[i] = Rotor.toLetter(numi);
        }
        String msg2;
        msg2 = new String(input);
        return msg2;
    }
}
