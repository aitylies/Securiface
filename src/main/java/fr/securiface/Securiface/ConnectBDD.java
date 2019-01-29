package fr.securiface.Securiface;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe permettant la connexion à la base de donnée
 * Et la manipulation de cette dernière
 */
public class ConnectBDD {

    public static void ConnectToBDD(String url, String user, String passwd) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            /*String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "postgres";
            */
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ListItems(){

    }
}
