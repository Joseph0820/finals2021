/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pornillos_finals02;
import java.util.Scanner;
/**
 *
 * @author japz3
 */
public class pornillos_finals02 {
     public static String fRLE(String s){
        int i = 0;
        String e = "";
        while (i < s.length()){
            int count = 1;
        while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
            count++;
            i++;
            }
            e = e + count + s.charAt(i);
            i++;
        }
        return e;
    }
    
    public static String sRLE(String s){
        int num = 0;
        int i = 0;
        String e = "";
        char c = s.charAt(i);
        while (i <= s.length()){
            
            if (i == s.length()){
                e = e + num + c;
            }
            else if (c != s.charAt(i) && i==1){
                e = e + num + c;
                c = s.charAt(i);
                num = 1;
            }
            else if(c != s.charAt(i)){
                e = e + (num) + c;
                c = s.charAt(i);
                num = 1;
            }
            else{
                num++;
            } i++;
        }
        return e;
    }
 public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.print("input: ");
        String input = scan.next();
        System.out.println("1st: ");
        System.out.println(fRLE(input));
        System.out.println("2nd: ");
        System.out.println(sRLE(input));      
        System.out.println("Is it equal? : " + sRLE(input).equals(fRLE(input)));
    }
}