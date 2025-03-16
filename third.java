//3)print the numbers in reverse
import java.util.*;

public class third{
    public static void main(String[] args){
        int n=1234;
        String rev = "";
        for(int i=0;i<4;i++){
            int r = n%10;
            rev = rev+r;
            n = n/10;
        }
        System.out.println(rev);
    }
}