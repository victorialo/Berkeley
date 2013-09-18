/** HW #1 solutions.
 *
 *  @author Victoria Lo
 */

class Progs {

    /* 1a. */
    /** Returns the sum of all integers, k, such that 1 <= k < N and
     *  N is evenly divisible by k. */
    static int factorSum(int N) {
        /* *Replace the following with the answer* */
        int total = 0;
        int k = 1;
        while (k < N) {
            if (N % k == 0) {
                total = total + k;
            }
            k += 1;
        }
        return total;
    }

    /* 1b. */
    /** Print the set of all sociable pairs whose members are all
     *  between 1 and N>=0 (inclusive) on the standard output (one pair per
     *  line, smallest member of each pair first, with no repetitions). */
    static void printSociablePairs(int N) {
        /* *Fill in here* */
        for (int k = 1; k < N; k += 1) {
            for (int m = 2; m < N; m += 1) {
                if (k == factorSum(m) && (m == factorSum(k))) {
                    if (k < m) {
                        System.out.println(Integer.toString(k)
                            + Integer.toString(m));
                    } else {
                        System.out.println(Integer.toString(m)
                            + Integer.toString(k));
                    }
                }
            }
        }
    }

    /* 2a. */
    /** Returns a list consisting of the elements of A followed by the
     *  elements of B.  May modify items of A. Don't use 'new'. */
    static IntList dcatenate(IntList A, IntList B) {
        /* *Replace the following with the answer* */
        IntList C = A.tail;
        while (C.tail != null) {
            C = C.tail;
        }
        C.tail = B;
        return A;
    }

    /* 2b. */
    /** Returns the sublist consisting of LEN items from list L,
     *  beginning with item #START (where the first item is #0).
     *  Does not modify the original list elements.
     *  It is an error i the desired items don't exist. */
    static IntList sublist(IntList L, int start, int len) {
        /* *Replace the following with the answer* */
        IntList m = null;
        for (int i = 0; i < start - 1; i += 1) {
            L = L.tail;
        }
        m = L;
        IntList result = new IntList(m.head, null);
        IntList holder = result;
        IntList end = m.tail;
        for (int i = start; i < (len + start) - 1; i += 1) {
            holder.tail = new IntList(end.head, null);
            holder = holder.tail;
            end = end.tail;
        }
        return result;
    }

    /* 2c. */
    /** Returns the sublist consisting of LEN items from list L,
     *  beginning with item #START (where the first item is #0).
     *  May modify the original list elements. Don't use 'new'.
     *  It is an error if the desired items don't exist. */
    static IntList dsublist(IntList L, int start, int len) {
        /* *Replace the following with the answer* */
        IntList m = null;
        for (int i = 0; i < start - 1; i += 1) {
            L = L.tail;
        }
        m = L;
        IntList holder = m;
        IntList end = m.tail;
        for (int i = start; i < (len + start) - 1; i += 1) {
            holder.tail = end;
            holder = holder.tail;
            end = end.tail;
        }
        holder.tail = null;
        return m;
    }

}
