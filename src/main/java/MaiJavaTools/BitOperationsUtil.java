package MaiJavaTools;

public class BitOperationsUtil {

    private static BitOperationsUtil instance = new BitOperationsUtil();
    public static BitOperationsUtil getInstance () {
        return instance;
    }

    public String intToBinaryString(int num)
    {
        return String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
    }

}
