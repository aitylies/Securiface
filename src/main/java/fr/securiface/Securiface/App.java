package fr.securiface.Securiface;

import org.opencv.core.Mat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {

        /*Agents.removeAgent("Bond");
        Agents.putAgent("Bond","James","Gardien","54782","MotdePasseJames","./src/main/photo.jpg");
        Agents.getImageAgent("Castle");
        Agents.getListAgents();*/
        //System.out.println(Agents.isExisting("Castle"));
        //System.out.println(Agents.reservation("Castle","Grapin"));

        //Materiel.getListMateriel();
        /*Materiel.removeMateriel("Grapin");
        Materiel.putMateriel("Grapin","Grapin de sécurité 45mm",6);*/
        //Materiel.setQteMateriel("Grapin",2);

        //Materiel.getListMateriel();
        //Materiel.putMateriel("Menottes","Menottes 45mm",8);
        //System.out.println(Materiel.isEmpty("Grapin"));


        ConnectFrame connectFrame = new ConnectFrame();
    }
}
