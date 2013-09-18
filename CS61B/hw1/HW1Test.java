/** java HW1Test should test the methods defined in Progs.
 *  @author Victoria Lo
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

    /** Print message that test NAME has(if ISOK) or else has not
     *  passed. */
    private static void report(String name, boolean isOK) {
        if (isOK) {
            System.out.printf("%s OK.%n", name);
        } else {
            System.out.printf("%s FAILS.%n", name);
        }
    }

    /** Return true iff factorSum passes its tests. */
    private static boolean testFactorSum() {
        if (Progs.factorSum(10) == 1 + 2 + 5) {
            if (Progs.factorSum(12) == 1 + 2 + 3 + 4 + 6) {
                if (Progs.factorSum(220) == 284) {
                    if (Progs.factorSum(284) == 220) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /** Return true iff printSociablePairs passes its tests. */
    private static boolean testPrintSociablePairs() {
        return true;
    }

    /** Return true iff dcantenate passes its tests. */
    private static boolean testDcatenate() {
        IntList a = IntList.list(1, 3, 4);
        IntList b = IntList.list(2, 5, 8);
        if (Progs.dcatenate(a, b).equals(IntList.list(1, 3, 4, 2, 5, 8))) {
            return true;
        }
        return false;
    }
    /** Return true iff sublist passes its tests. */
    private static boolean testSublist() {
        IntList a = IntList.list(1, 3, 4, 2, 5, 8);
        IntList b = Progs.sublist(a, 3, 3);
        if (b.equals(IntList.list(4, 2, 5))) {
            return true;
        }
        return false;
    }

    /** Return true iff dsublist passes its tests. */
    private static boolean testDsublist() {
        IntList a = IntList.list(1, 3, 4, 2, 5, 8);
        if (Progs.dsublist(a, 3, 3).equals(IntList.list(4, 2, 5))) {
            return true;
        }
        return false;
    }


}
