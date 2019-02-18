package fr.securiface.Securiface;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Agents.getListAgents();
        Agents.putAgent("Wick","John","55882");
        Agents.getListAgents();
        Agents.removeAgent("Wick");
        Agents.getListAgents();

        ConnectFrame connectFrame = new ConnectFrame();
    }
}
