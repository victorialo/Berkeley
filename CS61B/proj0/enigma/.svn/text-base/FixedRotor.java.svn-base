package enigma;

/**
 * Class that represents a rotor that has no ratchet and does not advance.
 * @author Victoria Lo
 */
class FixedRotor extends Rotor {

    /**
     * name of fixedrotor.
     */
    private final String betaGamma;

    /**
     * @return
     */
    String getbetaGamma() {
        return betaGamma;
    }

    /**
     * @param BETAGAMMA1
     * @param SETTING
     */
    public FixedRotor(String betaGamma1, int setting) {
        super(betaGamma1, setting);
        betaGamma = betaGamma1;
    }

    @Override
    boolean advances() {
        return false;
    }

    @Override
    boolean atNotch() {
        return false;
    }

    /** Fixed rotors do not advance. */
    @Override
    void advance() {
    }

}
