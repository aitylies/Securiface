package fr.securiface.Securiface;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConnectFrame connectFrame = new ConnectFrame();
        ConnectBDD.ConnectToBDD();
    }
}
