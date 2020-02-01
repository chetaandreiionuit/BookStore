package BigApp.Utilities;

import java.util.*;
public class MeniuPrincipal {
    static Scanner scan = new Scanner(System.in);
    public static int[] meniuPrincipal(){
        System.out.println(" _____________________________");
        System.out.println(" |                           |");
        System.out.println(" |      *MENIBOOSTORE*       |");
        System.out.println(" |   1: VEZI cartile tale    |");
        System.out.println(" |   2:   ADAUGA carti       |");
        System.out.println(" |   3:   STERGE carti       |");
        System.out.println(" |   4:    EDIT carti        |");
        System.out.println(" |   5:   <---LOGOUT         |");
        System.out.println(" |___________________________|");
        System.out.print("  -->");

        int alegere =  scan.nextInt();
        int[] optiune = new int[2] ;

        switch(alegere){
            case 1:
                optiune[0] = 4;
                break;
            case 2:
                optiune[0] = 6;
                break;
            case 3:
                optiune[0] = 5;
                break;
            case 4:
                optiune[0] = 7;
                break;
            case 5:
//                optiune[0] = 7;
        }
        return optiune;
    }
}
