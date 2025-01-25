import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();

        int[] arr = new int[26];
        int max = 0;
        int index = 0;
        for(int i=0;i<str.length();i++){
            int alpha = str.charAt(i);
            arr[alpha-65]++;
        }
        for(int i=0; i<arr.length;i++){
            if(max <arr[i]){
                max = arr[i];
                index = i+65;
            }
            else if(max == arr[i]){
                index = '?';
            }

        }
        System.out.println((char)index)
        ;
    }
}