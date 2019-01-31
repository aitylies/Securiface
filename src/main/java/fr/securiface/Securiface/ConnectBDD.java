package fr.securiface.Securiface;


import java.sql.*;

/**
 * Classe permettant la connexion à la base de donnée
 * Et la manipulation de cette dernière
 */
public class ConnectBDD {

    public static void ConnectToBDD() {

            /* Chargement du driver JDBC pour MySQL */
            try {
                Class.forName( "com.mysql.cj.jdbc.Driver" );
            } catch ( ClassNotFoundException e ) {
                e.printStackTrace();
            }
            System.out.println("Driver O.K.");

            /* Connexion à la base de données */
            String url = "jdbc:mysql://localhost:3306/securiface?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            String utilisateur = "securiface";
            String motDePasse = "Freesteak44";
            Connection connexion = null;
            try {
                connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

                /* Création de l'objet gérant les requêtes */
                Statement statement = connexion.createStatement();

                /* Exécution d'une requête de lecture */
                ResultSet resultat = statement.executeQuery( "SELECT matricule, nom, prenom FROM agent;" );
                System.out.println(resultat);

            } catch ( SQLException e ) {
                e.printStackTrace();
            } finally {
                if ( connexion != null )
                    try {
                        /* Fermeture de la connexion */
                        connexion.close();
                    } catch ( SQLException ignore ) {
                        /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                    }
            }
    }
}
