package BigApp.Utilities;

import BigApp.Aplication;

import java.sql.*;
import java.util.Scanner;

public class SingIn {
    static Scanner scan = new Scanner(System.in);
    public static int[] singIn(){
        System.out.println("Enter UserName: ");
        String newUserName = scan.nextLine();
        System.out.println("Enter Password:");
        String newPassword = scan.nextLine();

        int[] optiune =  new int[2];
        String url ="jdbc:mysql://localhost:3306/bookstore";
        String userDataBase ="root";
        String passDataBase ="root";

        try {
            Connection myConn = DriverManager.getConnection(url,userDataBase,passDataBase);
            Statement st = myConn.createStatement();
            st.execute(String.format("INSERT INTO client ( USERNAME, PASSWORD) VALUES ('%s','%s')", newUserName, newPassword));

            Statement stId = myConn.createStatement();
            ResultSet rs = stId.executeQuery(String.format("SELECT * FROM client WHERE USERNAME = '%s'", newUserName));
            int id;

            while(rs.next()) {
                id = rs.getInt("IDCLIENT");
                optiune = Aplication.options(3, id);
            }

            myConn.close();




        } catch (SQLException e) {
            System.out.println("A aparut o eroare in SignIn.java");
            e.printStackTrace();
        }
        return optiune;
    }
}
