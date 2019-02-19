package fr.securiface.Securiface;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            ResultSet resultat = statement.executeQuery( "SELECT nom, quantite, date_ajout, dern_retrait, description FROM materiel;" );

            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                String nomMateriel = resultat.getString( "nom" );
                String quantite = resultat.getString("quantite");
                String date_ajoutMateriel = resultat.getString( "date_ajout" );
                String dern_retraitMateriel = resultat.getString( "dern_retrait" );
                String description = resultat.getString("description");

                /* Traiter ici les valeurs récupérées. */
                System.out.println("\nMatériel : "+nomMateriel+"\nQuantité : "+quantite+"\nDate d'ajout : "+date_ajoutMateriel+"\nDernier Retrait : "+dern_retraitMateriel+"\nDescription : "+description+"\n");
                System.out.println("----------------------------------------------------------\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putMateriel(String nom, String description){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            String INSERT_QUERY = "INSERT INTO materiel (nom, date_ajout, description) VALUES (?,?,?)";

            java.util.Date date_ajout = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");

            /* Exécution d'une requête d'écriture */
            PreparedStatement st = connection.prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.setString( 1, nom );
            st.setString( 2, ft.format(date_ajout));
            st.setString(3, description);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void setQteMateriel(String nom , Integer quantite){

        try {

            Connection connection = ConnectBDD.getConnection();

            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            /* Création de l'objet Date */
            java.util.Date dern_retrait = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");

            String UPDATE_QUERY;

            if (quantite == -1) {
                UPDATE_QUERY = "UPDATE materiel SET quantite = "+quantite+", dern_retrait = '"+ft.format(dern_retrait)+"' WHERE nom = '"+nom+"';";
            }else{
                UPDATE_QUERY = "UPDATE materiel SET quantite = "+quantite+" WHERE nom = '"+nom+"';";
            }

            /* Exécution d'une requête d'écriture */
            PreparedStatement st = connection.prepareStatement( UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS );
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Integer getQteMateriel(String nom){

        Integer quantite= 0;
        try {

            Connection connection = ConnectBDD.getConnection();
            /* Création de l'objet gérant les requêtes */
            Statement statement = connection.createStatement();

            /* Exécution d'une requête de lecture */
            ResultSet resultat = statement.executeQuery( "SELECT quantite FROM materiel WHERE nom = '"+nom+"';" );

            /* Traiter ici les valeurs récupérées. */
            quantite = resultat.getInt("quantite");

            System.out.println(quantite);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantite;
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
