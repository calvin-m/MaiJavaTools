package MaiJavaTools.DataStructure;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortedLinkedListTest {
    @Test
    public void test1() {

        SortLinkedList list = new SortLinkedList();
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        System.out.println(list.toString());

        list.sort();
        System.out.println(list.toString());

        StringBuilder sb = new StringBuilder();
        sb.append("a").append("bcd");
        sb.setLength(2);
        System.out.println(sb.toString());



        assertTrue(true);
    }
}
