package BigApp;

import BigApp.Utilities.*;

import java.sql.SQLException;
import java.util.Scanner;


public class Aplication {

    public static int localUser;


    public static int[] options(int a, int b) {
        int[] arr = {a,b};
        return arr;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("+++BOOKSTORE+++");
        int[] rezultat = MeniuSingInLogIn.meniuSingInLogIn();
        int rezultatNext = 0;
        boolean AplicatieActiva = true;
        System.out.println("Tipul: " + rezultat.getClass().isArray() );
        while(AplicatieActiva) {
            switch (rezultat[0]){
                case 1:
                    rezultat = LogIn.logIn();
                    localUser = rezultat[1];
                    break;
                case 2:
                    rezultat = SingIn.singIn();
                    localUser = rezultat[1];
                    break;
                case 3:
                    System.out.println("THE ID OF THIS USER IS: " + rezultat[1]);
                    rezultat = MeniuPrincipal.meniuPrincipal();
                    break;
                case 4:
                    rezultat = OperatiiCarti.AfiseazaCarti();
                    break;
                case 5:
                    rezultat = OperatiiCarti.StergeCarte();
                    break;
                case 6:
                    rezultat = OperatiiCarti.AdaugaCarte();
                    break;
                case 7:
                    rezultat = OperatiiCarti.EditCarti();
                    break;


//                    rezultat = AdaugaCarti.adaugaCarti();
//                    break;
//                case 6:
//                    rezultat = StergeCarti.stergeCarti();
//                    break;
//                case 7:
//                    rezultat = EditCarti.editCarti():
//                    break;
//                case 8  :
//                    AplicatieActiva = false;
//                    break;
            }

        }
    }
}
