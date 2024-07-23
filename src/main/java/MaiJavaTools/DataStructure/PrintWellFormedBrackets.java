package MaiJavaTools.DataStructure;

public class PrintWellFormedBrackets {
    private StringBuilder out = null;
    private int n;

    public PrintWellFormedBrackets(){
    }

    public void print(int n){
        this.out = new StringBuilder();
        generateWellFormedBrackets("", n, 0, 0);
        //System.out.println(out.toString());
    }

    private void generateWellFormedBrackets(String out, int n, int open, int close){
        if(open == n && close == n){
            System.out.println(out.toString());
        }
        else{
            if(open < n){
                generateWellFormedBrackets(out+"(", n, open+1, close);
            }
            if(close < open){
                generateWellFormedBrackets(out+")", n, open, close+1);
            }

        }
    }
}
