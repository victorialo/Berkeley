package enigma;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainTest {

    public static void main(String... args) {
        /** System.exit(ucb.junit.textui.runClasses(Main.class)); **/
    }

    @Test
    public void isConfig() {
        assertTrue("config line",
            Main.isConfigurationLine("* B beta III IV I AXLE"));
    }

    @Test
    public void standard() {
        String L = "ha ha Hee";
        assertEquals("standardize", "HAHAHEE", Main.standardize(L));
    }

}
