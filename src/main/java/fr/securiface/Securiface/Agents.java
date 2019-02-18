package fr.securiface.Securiface;

import java.sql.*;

/**
 * Classe permettant la connexion à la base de donnée
 * Et la manipulation de cette dernière
 */
public class Agents {

    public static void getListAgents() {

        try {
           Connection connection = ConnectBDD.getConnection();
            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            /* Exécution d'une requête de lecture */
            ResultSet resultat = statement.executeQuery( "SELECT matricule, nom, prenom FROM agents;" );

            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                String nomAgent = resultat.getString( "nom" );
                String prenomAgent = resultat.getString( "prenom" );
                String matriculeAgent = resultat.getString( "matricule" );

                /* Traiter ici les valeurs récupérées. */
                System.out.println("Agent : "+prenomAgent+" "+nomAgent+" , matricule : "+matriculeAgent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putAgent(String nom, String prenom, String matricule){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            String INSERT_QUERY = "INSERT INTO agents (nom, prenom, matricule) VALUES (?,?,?)";

            /* Exécution d'une requête d'écriture */
            PreparedStatement st = connection.prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.setString( 1, nom );
            st.setString( 2, prenom );
            st.setString( 3, matricule );
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void removeAgent(String agentName){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            String DELETE_QUERY = "DELETE FROM agents WHERE nom = '"+agentName+"'";

            /* Exécution d'une requête de suppression */
            PreparedStatement st = connection.prepareStatement( DELETE_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}