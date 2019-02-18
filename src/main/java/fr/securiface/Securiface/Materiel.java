package fr.securiface.Securiface;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Classe permettant la connexion à la base de donnée
 * Et la manipulation des différents matériels
 */

public class Materiel {

    public static void getListMateriel() {

        try {
            Connection connection = ConnectBDD.getConnection();
            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            /* Exécution d'une requête de lecture */
            ResultSet resultat = statement.executeQuery( "SELECT nom, date_ajout, dern_retrait, description FROM materiel;" );

            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                String nomMateriel = resultat.getString( "nom" );
                String date_ajoutMateriel = resultat.getString( "date_ajout" );
                String dern_retraitMateriel = resultat.getString( "dern_retrait" );
                String description = resultat.getString("description");

                /* Traiter ici les valeurs récupérées. */
                System.out.println("\nMatériel : "+nomMateriel+"\nDate d'ajout : "+date_ajoutMateriel+"\nDernier Retrait : "+dern_retraitMateriel+"\nDescription : "+description+"\n");
                System.out.println("----------------------------------------------------------\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putMateriel(String nom, LocalDate date_ajout, Date dern_retrait, String description){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            String INSERT_QUERY = "INSERT INTO materiel (nom, date_ajout, dern_retrait, description) VALUES (?,?,?,?)";

            /* Exécution d'une requête d'écriture */
            PreparedStatement st = connection.prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.setString( 1, nom );
            st.setString( 2, String.valueOf(date_ajout));
            st.setString( 3, String.valueOf(dern_retrait));
            st.setString(4, description);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void removeMateriel(String materielName){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            String DELETE_QUERY = "DELETE FROM materiel WHERE nom = '"+materielName+"'";

            /* Exécution d'une requête de suppression */
            PreparedStatement st = connection.prepareStatement( DELETE_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
