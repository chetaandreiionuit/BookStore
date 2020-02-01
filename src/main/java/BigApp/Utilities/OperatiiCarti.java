package BigApp.Utilities;

import BigApp.Aplication;

import java.sql.*;
import java.util.Scanner;



public class OperatiiCarti {

    static Scanner scan = new Scanner(System.in);
    public static String url ="jdbc:mysql://localhost:3306/bookstore";
    public static String userDataBase ="root";
    public static String passDataBase ="root";

    public static int[] AfiseazaCarti() throws SQLException {
        int[] optiune = {3, 0};

        try{
            Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);

            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM books WHERE IDCLIENT = '%s'", Aplication.localUser));


            System.out.println("Cartile: ");
            while(rs.next()){
                int id = rs.getInt("IDBOOKS");
                String titlu = rs.getString("TITLU");
                String author = rs.getString("AUTOR");
                int an = rs.getInt("AN");

                System.out.println(id + " " + titlu + " " + author + " " + an);
                System.out.println();
            }
            myConn.close();


        } catch( SQLException e) {
            System.out.println("Eroare la afiseaza carti");
            e.printStackTrace();
        }
        return optiune ;
    }

    public static int[] StergeCarte() throws SQLException {
        int[] optiune = {3, 0};


        try{
            Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);

            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM books WHERE IDCLIENT = '%s'", Aplication.localUser));


            System.out.println("Cartile tale: ");
            while(rs.next()){
                int id = rs.getInt("IDBOOKS");
                String titlul = rs.getString("TITLU");
                String author = rs.getString("AUTOR");
                int an = rs.getInt("AN");

                System.out.println(id + " " + titlul + " " + author + " " + an);
                System.out.println();
            }

            System.out.println("Alege titlul cartii ce o vrei sa o stergi");
            int idCarte = scan.nextInt();

            Statement st2 = myConn.createStatement();
            st2.execute(String.format("DELETE FROM books WHERE IDBOOKS = '%d'", idCarte));
            System.out.println("Cartea a fost stearsa");


            myConn.close();


        } catch( SQLException e) {
            System.out.println("Eroare la stergerea carti");
            e.printStackTrace();
        }
        return optiune ;
    }

    public static int[] AdaugaCarte(){
        int[] option =  {3, 0};


        System.out.println("Scrie o carte noua");
        String carteNoua = scan.nextLine();
        System.out.println("Cine a scriso?");
        String autorNou = scan.nextLine();
        System.out.println("In ce an a aparut?");
        int anNou = scan.nextInt();


        try{
            Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);
            Statement st = myConn.createStatement();
            st.execute(String.format("INSERT INTO books (IDCLIENT, TITLU ,AUTOR, AN) VALUES ('%d','%s','%s','%d')",Aplication.localUser, carteNoua,autorNou,anNou));

            System.out.println("Felicitari , ai mai citit o carte!");
            System.out.println("Acum ai in lista:");
            OperatiiCarti.AfiseazaCarti();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    return option;
    }

    public static int[] EditCarti(){
        int[] option =  {3, 0};

        try{
            Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);

            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM books WHERE IDCLIENT = '%s'", Aplication.localUser));


            System.out.println("Cartile tale: ");
            while(rs.next()){
                int id = rs.getInt("IDBOOKS");
                String titlul = rs.getString("TITLU");
                String author = rs.getString("AUTOR");
                int an = rs.getInt("AN");

                System.out.println(id + " " + titlul + " " + author + " " + an);
                System.out.println();
            }

            System.out.println("Ce carte doresti sa modifici? ");
            int select = scan.nextInt();
            System.out.println("Titlu nou:");
            String sadas = scan.nextLine();
            String newtitle = scan.nextLine();
            System.out.println("Autor nou:");
            String newautor = scan.nextLine();
            System.out.println("An nou");
            int anNou = scan.nextInt();


            st.execute(String.format("UPDATE bookstore SET TITLU = '%s', AUTOR = '%s', AN = '%d', WHERE IDBOOKS = '%d';", newtitle, newautor, anNou, select));



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return option;
    }



}


