package enigma;

/**
 * Class that represents a reflector in the enigma.
 * @author Victoria Lo
 */
class Reflector extends Rotor {

    /**
     * reflector.
     */
    private final String bc;

    /**
     * @return
     */
    String getBc() {
        return bc;
    }

    /**
     * @param BC1
     */
    public Reflector(String bc1) {
        super(bc1, 0);
        bc = bc1;
    }

    @Override
    boolean hasInverse() {
        return false;
    }

    /** Returns a useless value; should never be called. */
    @Override
    int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

}
