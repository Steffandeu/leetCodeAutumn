package steffan.deu.offer.CMBCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exam3 {
    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       String str = bufferedReader.readLine();
        str = str.replace('?','.');
        int num = str.length();
        Pattern pattern = Pattern.compile(str);
        int count = 0;
        for (long i = 5; i < Math.pow(10,num); i++) {
            String s1 = ""+i;
            String s2 = "";
            int num2 = s1.length();
            for (int j = num2; j < num; j++) {
                s2 +="0";
            }
            s1 = s2+s1;
            Matcher matcher = pattern.matcher(s1);
            if (matcher.find()){
                count++;
            }
        }
        System.out.println(count);
    }
}
