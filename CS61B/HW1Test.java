/** java HW1Test should test the methods defined in Progs.
 *  @Victoria Lo
 */
public class HW1Test {

    /** Run all tests. */
    public static void main(String[] args) {
        report("factorSum", testFactorSum());
        report("printSociablePairs", testPrintSociablePairs());
        report("dcatenate", testDcatenate());
        report("sublist", testSublist());
        report("dsublist", testDsublist());
    }

    /** Print message that test NAME has (if ISOK) or else has not
     *  passed. */
    private static void report(String name, boolean isOK) {
        if (isOK) {
            System.out.printf("%s OK.%n", name);
        } else {
            System.out.printf("%s FAILS.%n", name);
        }
    }

    // Replace the bodies of the functions below with something serious.

    /** Return true iff factorSum passes its tests. */
    private static boolean testFactorSum() {
        check (int 8, Progs.factorSum(10));
        check (int 16, Progs.factorSum(12));
        check (int 284, Progs.factorSum(220));
        check (int 220, Progs.factorSum(284));

    }

    /** Return true iff printSociablePairs passes its tests. */
    private static boolean testPrintSociablePairs() {
        check (IntList.list (220, 284), Progs.printSociablePairs(284));
    }

    /** Return true iff dcantenate passes its tests. */
    private static boolean testDcatenate() {
        IntList a = IntList.list (1, 3, 4);
        IntList b = IntList.list (2, 5, 8);
        check (IntList.list (1, 3, 4, 2, 5, 8), Progs.dcatenate (a, b));
        check (IntList.list(1, 3, 4), Progs.dcatenate (a, null));
        check (IntList.list(2, 5, 8), Progs.dcatenate (null, b));
    }

    /** Return true iff sublist passes its tests. */
    private static boolean testSublist() {
        return true;
    }

    /** Return true iff dsublist passes its tests. */
    private static boolean testDsublist() {
        return true;
    }

}
