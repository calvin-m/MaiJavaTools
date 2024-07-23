package MaiJavaTools.DataStructure;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PermutationTest {
    @Test
    public void testABC() {

        Permutation p = new Permutation();
        System.out.println(p.permute("ABC"));

        assertTrue(true);
    }

    @Test
    public void testABCD(){
        Permutation p = new Permutation();
        System.out.println(p.permute("ABCD"));

        assertTrue(true);
    }

    @Test
    public void testGeneral(){
        char c1 = 'Z';
        char c2 = (char) ((int)c1 + 3);
        System.out.println("c2: " + c2);
        assertTrue(true);
    }
}
