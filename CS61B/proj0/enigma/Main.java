package enigma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Enigma simulator.
 * @author Victoria Lo
 */
public final class Main {

    /**
     * Process a sequence of encryptions and decryptions, as specified in the
     * input from the standard input. Print the results on the standard output.
     * Exits normally if there are no errors in the input; otherwise with code
     * 1.
     */
    public static void main(String[] unused) {
        Machine M;
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        buildRotors();

        M = null;

        try {
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                if (isConfigurationLine(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /** Return true iff LINE is an Enigma configuration line. */
    public static boolean isConfigurationLine(String line) {
        line = line.toUpperCase();
        String[] aline = line.split(" ");
        if (aline.length == 7) {
            if (aline[0].equals("*")
                && (aline[1].equals("B") || aline[1].equals("C"))
                && (aline[2].equals("GAMMA") || aline[2].equals("BETA"))
                && aline[6].length() == 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * Configure M according to the specification given on CONFIG, which must
     * have the format specified in the assignment.
     */
    private static void configure(Machine M, String config) {
        if (isConfigurationLine(config)) {
            String[] pline = config.split(" ");
            String rset;
            rset = pline[6];
            Rotor[] rotors = new Rotor[5];
            for (int i = 0; i < pline.length - 2; i += 1) {
                if (i == 0) {
                    rotors[i] = new Reflector(pline[1]);
                } else if (i == 1) {
                    rotors[i] = new FixedRotor(pline[2], 0);
                } else {
                    rotors[i] = new Rotor(pline[i + 1], 0);
                }
            }
            M.replaceRotors(rotors);
            M.setRotors(rset);
        } else {
            System.out.println("not a config line!");
        }
    }

    /**
     * Return the result of converting LINE to all upper case, removing all
     * blanks and tabs. It is an error if LINE contains characters other than
     * letters and blanks.
     */
    public static String standardize(String line) {
        line = line.toUpperCase();
        line = line.replaceAll("\t", "");
        line = line.replaceAll("\n", "");
        line = line.replaceAll(" ", "");
        return line;
    }

    /**
     * Print MSG in groups of five (except that the last group may have fewer
     * letters).
     */
    public static void printMessageLine(String msg) {
        for (int i = 0; i < msg.length(); i += 1) {
            if (i % 5 == 0 && i != 0) {
                System.out.print(" ");
            }
            System.out.print(msg.charAt(i));
        }
    }

    /** Create all the necessary rotors. */
    private static void buildRotors() {
    }

}
