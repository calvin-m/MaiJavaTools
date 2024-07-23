package MaiJavaTools.DataStructure;

import java.util.Map;
import java.util.TreeMap;

public class Combination {
    private StringBuilder out = new StringBuilder();
    private final String in = null;

    public Combination(final String str){

    }

    public void combination(char[] input){
        //1. Get unqiue char count
        Map<Character, Integer> countMap = new TreeMap<>();
        for(char c : input) {
            countMap.compute(c, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }

        //2.
        char[] str = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }

        //3. Now build combination
        char[] output = new char[input.length];
        combination(str, count, 0, output, 0);
    }

    private void combination(char[] input, int[] counts, int pos, char[] output, int len){
        print(output, len);
        for(int i=pos; i < input.length; i++){
            if(counts[i] == 0){
                continue;
            }
            output[len] = input[i];
            counts[i]--;
            combination(input, counts, i, output, len+1);
            counts[i]++;
        }
    }

    private void print(char[] result, int pos){
        for(int i=0; i < pos; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    // --------
    public void combine(String input){
        combine(input, 0, new StringBuilder());
    }

    private void combine(String input, int index, StringBuilder out) {
        for(int i=index; i<input.length(); i++){
            out.append(input.charAt(i));
            System.out.println(out.toString());
            if(i < input.length())
                combine(input, i+1, out);
            out.setLength(out.length() -1);
        }
    }
}
