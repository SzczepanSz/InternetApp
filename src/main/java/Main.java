import java.sql.Connection;
import java.sql.DriverManager;

//import java.beans.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Statement;





public class Main {

    public static void main (String[]args){
            String url = "jdbc:postgresql://localhost:5433/postgres";
            String user = "postgres";
            String pass = "holandia";

            System.out.print("fsfsdafafas");
            Connection conn = null;



            try {

                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url , user, pass);

                Statement stat = conn.createStatement();


            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(conn != null){
                   try{
                       conn.close();
                   }catch (SQLException e){
                       e.printStackTrace();
                   }
                }
            }




    }

}
