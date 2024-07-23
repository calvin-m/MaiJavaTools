package MaiJavaTools.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
   // private boolean[] used;
    private List<String> out;
    //private final String in;
    private int iterationCount = 0;

    public String permute(String in){
        if(null == in || in.length() == 1) return in;

        out = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
       // used = new boolean[in.length()]; // default to false

        permute(in.toCharArray(), 0, buffer);

        return out.toString();
    }

    private void permute(char[] in, int index, StringBuilder buffer){
        if(index == in.length-1) {
            out.add(String.valueOf(in));
            System.out.println(++iterationCount + " : " + String.valueOf(in));
            return;
        }

        for(int i=index; i < in.length; i++){

            swap(in, index, i);
            permute(in, index+1, buffer);
            swap(in, i, index);
        }
    }

    private void swap(char[] in, int i1, int i2){
        char temp = in[i1];
        in[i1] = in[i2];
        in[i2] = temp;
    }

}
