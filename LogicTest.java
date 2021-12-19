import java.io.*;
import java.util.*;

public class LogicTest {


    //nomer 1
    public static boolean Palindrom(String a){
        String b = new StringBuilder(a).reverse().toString();

        if(a.equals(b)){
            return true;
        }else{
            return false;
        }
    }


    //nomer 2
    public static void LeapYear(int first, int last){
        for(int i = first+4; i<=last; i+=4){
            System.out.print(i+" ");
        }
    }


    //nomer 3
    public static void ReverseWords(String a){
        String[] temp = a.split(" ",a.length());
        String result = "";

        for(String b : temp){
            String c = b.toUpperCase();
            if(b.substring(0,1).equals(c.substring(0,1))){
                c = (new StringBuilder(b).reverse().toString()).toLowerCase();
                c = c.substring(0,1).toUpperCase() + c.substring(1,c.length());
                result = result+" "+c;
            }else{
                c = new StringBuilder(b).reverse().toString();
                result = result+" "+c;
            }
        }

        System.out.println(result);
    }

    //nomer 4
    public static void NearestFibonacci(int[] a){
        int sum = 0;
        for(int b : a){
            sum+=b;
        }
        
        int n1 = 0,n2 = 1,n3 = 0;
        while(n3 <= sum){
            n3 = n1+n2;
            n1 = n2;
            n2 = n3;
        }
        double next = n2 * ((1+Math.sqrt(5))/2.0);

        if(Math.abs(sum - (int)Math.round(n2)) <= Math.abs(sum - n1)){
            System.out.print(Math.abs(sum-(int)Math.round(n2)));
        }else{
            System.out.print(sum-n1);
        }
    }

    //nomer 5
    public static String[] FizzBuzz(int n){
        String[] result = new String[n];
        int a = 1;
        for(int i =0; i <n; i++){
            if(a%3 == 0 && a%5 == 0){
                result[i] = "FizzBuzz";
            }else if (a%3 == 0){
                result[i] = "Fizz";
            }else if(a%5 == 0){
                result[i] = "Buzz";
            }else{
                result[i] = String.valueOf(a);
            }
            a++;
        }

        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // System.out.print("Input phrase: ");
        // String kata = scan.nextLine();
        // kata = kata.toLowerCase();

        // if(Palindrom(kata) == true){
        //     System.out.println("Palindrome");
        // }else{
        //     System.out.println("not palindrome");
        // }

        // System.out.print("Tahun pertama: ");
        // int first = scan.nextInt();

        // System.out.print("Tahun terakhir: ");
        // int last = scan.nextInt();

        // LeapYear(first,last);

        // System.out.print("Input phrase: ");
        // String kata = scan.nextLine();

        // Reverse(kata);

        // int[] a = {15,1,3};
        // NearestFibonacci(a);

        // String[] a = FizzBuzz(15);
        // for(String b : a){
        //     System.out.print(b+", ");
        // }
    }
}
