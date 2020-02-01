package BigApp.Utilities;

import BigApp.*;

import java.util.Scanner;

public class MeniuSingInLogIn {
    static Scanner scan = new Scanner(System.in);
    public static int[] meniuSingInLogIn(){
        System.out.println("***BOOKSTORE***");
        System.out.println("----------------");
        System.out.println("HELLO!");
        System.out.println("ALEGE INTRE:");
        System.out.println("1:LOG IN");
        System.out.println("2:SING IN");

        int alegere = scan.nextInt();
        int[] optiune = new int[2];

        switch (alegere){
            case 1:
                optiune = Aplication.options(alegere,0);
                break;
            case 2:
                optiune = Aplication.options(alegere,0);
                break;
        }
        return optiune;
    }
}
