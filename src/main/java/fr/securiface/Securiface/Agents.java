package fr.securiface.Securiface;

import java.sql.*;

/**
 * Classe permettant la connexion à la base de donnée
 * Et la manipulation des différents agents.
 */

public class Agents {

    public static void getListAgents() {

        try {
           Connection connection = ConnectBDD.getConnection();
            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            /* Exécution d'une requête de lecture */
            ResultSet resultat = statement.executeQuery( "SELECT nom, prenom, matricule, poste, chemin_photo FROM agents;" );

            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                String nomAgent = resultat.getString( "nom" );
                String prenomAgent = resultat.getString( "prenom" );
                String posteAgent = resultat.getString( "poste" );
                String matriculeAgent = resultat.getString( "matricule" );
                String chemin_photoAgent = resultat.getString( "chemin_photo" );

                /* Traiter ici les valeurs récupérées. */
                System.out.println("\nAgent : "+nomAgent+" "+prenomAgent+"\n  - Poste : "+posteAgent+"\n  - Matricule : "+matriculeAgent+"\n  - Chemin Photo : "+chemin_photoAgent+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putAgent(String nom, String prenom, String poste, String matricule, String password, String chemin_photo){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            String INSERT_QUERY = "INSERT INTO agents (nom, prenom, poste, matricule, password, chemin_photo) VALUES (?,?,?,?,?,?)";

            /* Exécution d'une requête d'écriture */
            PreparedStatement st = connection.prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.setString( 1, nom );
            st.setString( 2, prenom );
            st.setString( 3, poste );
            st.setString( 4, matricule );
            st.setString( 5, password );
            st.setString( 6, chemin_photo );
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

    public static String getImageAgent(String agentName){

        String pathfile="";
        try {

            Connection connection = ConnectBDD.getConnection();
            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            /* Exécution d'une requête de lecture */
            ResultSet resultat = statement.executeQuery( "SELECT chemin_photo FROM agents WHERE nom = '"+agentName+"';" );

            if (resultat.next()) {
                /* Traiter ici les valeurs récupérées. */
                pathfile = resultat.getString("chemin_photo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pathfile;
    }
}