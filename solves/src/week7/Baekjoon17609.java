package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17609 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
            String s = br.readLine();
            String rev = new StringBuffer(s).reverse().toString();

            if(s.equals(rev)) sb.append(0+"\n");
            else {
                int size = s.length();
                boolean flag = false;
                for(int i=0; i<size; i++) {
                    if(i >= size-1-i) break;
                    if(s.charAt(i) != s.charAt(size-1-i)) {
                        String str1 = new StringBuilder(s).deleteCharAt(i).toString();
                        String str2 = new StringBuilder(s).deleteCharAt(size-1-i).toString();

                        if(str1.equals(new StringBuffer(str1).reverse().toString())) {
                            sb.append(1+"\n");
                            flag = true;
                        }else if(str2.equals(new StringBuffer(str2).reverse().toString())) {
                            sb.append(1+"\n");
                            flag = true;
                        }
                        break;
                    }
                }
                if(!flag) sb.append(2+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}