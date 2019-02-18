package fr.securiface.Securiface;

import sun.misc.resources.Messages_zh_CN;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        Date maintenant = Date.valueOf(LocalDate.now());
        LocalDate date_ajout = LocalDate.of(2019, Month.JANUARY, 18);

        /*Agents.putAgent("Wick","John","55882");
        Agents.getListAgents();
        Agents.removeAgent("Wick");
        Agents.getListAgents();*/


        /*Materiel.putMateriel("Grapin",date_ajout,maintenant,"Grapin de sécurité 45mm");
        Materiel.getListMateriel();
        Materiel.removeMateriel("Grapin");
        Materiel.getListMateriel();*/

        ConnectFrame connectFrame = new ConnectFrame();
    }
}
