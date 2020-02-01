package BigApp.Utilities;



import BigApp.*;
import java.sql.*;
import java.util.Scanner;


public class LogIn {
    static Scanner scan = new Scanner(System.in);


    public static int[] logIn(){
        System.out.println("ENTER USERNAME");
        String userName = scan.nextLine();
        System.out.println("ENTRE PASSWORD");
        String password = scan.nextLine();

        int[] optiune = new int[2];
//        optiune[0] = 1;
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String userDataBase = "root";
        String passDataBase = "root";
        boolean flag =  false;


        try{
            Connection myConn = DriverManager.getConnection(url, userDataBase, passDataBase);
            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM client WHERE USERNAME = '%s'", userName));
            int id;
            while (rs.next()) {
                id = rs.getInt("IDCLIENT");
                String userName1 = rs.getString("USERNAME");
                String passVerify = rs.getString("PASSWORD");
                if (password.matches(passVerify)) {

                    System.out.println("ID: "+ id);
                    System.out.println("UserName si Parola sunt inregistrate in baza noastra de data si sunt CORECTE!");
                    optiune = Aplication.options(3, id);

                }

            }
                myConn.close();

        } catch (SQLException e) {
            System.out.println("A aparut o eroare in LogIn.java");
            e.printStackTrace();
        }
        return optiune;
    }

}
