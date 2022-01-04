/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pornillos_finals01;

/**
 *
 * @author japz3
 */

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
public class pornillos_finals01 {
    
private static int conDec(String x) {
        int b = 1;
        int decim = 0;
        String num = x;
        int len = num.length();
        for (int i = len - 1; i >= 0; i--){
            if (num.charAt(i) == '1'){
            decim += b;
            b = b * 2;
        }
       }
        return decim;
    }
private static String getStrng(String s) {
        int n = (s.length());
        if (n % 8 != 0) {
            return "Please try again";
        }
        String e = "";
        for (int i = 0; i < n; i += 8) {
            int decimal_value = conDec((s.substring(i, 8+i)));
            e += (char)(decimal_value);
        }
        return e;
    }
    
private static String opxor(String q, String r, int t){
    String inp = "";
        for (int i = 0; i < t; i++){
        if (q.charAt(i) == r.charAt(i)){inp += "0";
        } else{
            inp += "1";
        }
       }
    return inp;
    } 
        
public static String convBinary(String s) {
        StringBuilder r = new StringBuilder();
        char[] e = s.toCharArray();
        for (char aChar : e) {
        r.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
       }
    return r.toString();
    }

public static String outBin(String b, int c, String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < b.length()) { 
        i += c;
        result.add(b.substring(i, Math.min(i + c, b.length())));
        }
        return result.stream().collect(Collectors.joining(s));
    }

public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("input string: ");
        String givenStr = s.nextLine(); 
        System.out.print("first name: ");  
        String studName = s.next();
                
        if(studName.length() > givenStr.length()){
            String newStr = givenStr.repeat(givenStr.length()).substring(0, studName.length());       
            givenStr = newStr;
        }    
        String tCase = convBinary(givenStr);  
        
        if(givenStr.length() > studName.length()){
            String newStr = studName.repeat(studName.length()).substring(0, givenStr.length());
            studName = newStr;
        }  
        String result = convBinary(studName);     
        String printFname = outBin(result, 8, " ");
        String printString = outBin(tCase, 8, " ");
        System.out.println();
        System.out.println("string in binary: \n" + printString);
        System.out.println("name in binary: \n" + printFname);
        int l = result.length();
        String finalXor = opxor(result, tCase, l);
        System.out.println("XOR:\n" + outBin(finalXor, 8, " "));
        System.out.println(getStrng(finalXor));       
    }
}