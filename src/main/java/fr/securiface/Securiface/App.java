package fr.securiface.Securiface;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConnectBDD.ConnectToBDD();
        ConnectFrame connectFrame = new ConnectFrame();
    }
}
