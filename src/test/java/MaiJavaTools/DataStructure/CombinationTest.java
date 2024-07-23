package MaiJavaTools.DataStructure;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CombinationTest {
    @Test
    public void testABC() {
        Combination comb = new Combination("ABC");
        comb.combination("ABC".toCharArray());


        assertTrue(true);
    }

    @Test
    public void testWXYZ(){
        Combination comb = new Combination("WXYZ");
        comb.combine("WXYZ");

        assertTrue(true);
    }
}
