package fr.securiface.Securiface;

import javax.swing.*;
import java.awt.*;

public class ConnectFrame extends JFrame {
    public ConnectFrame () {
        this.setTitle("Securiface");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);

        // Connect button
        JButton btConnect = new JButton("CONNEXION");
        btConnect.setFont(new Font("Roboto", Font.PLAIN, 25));
        //btConnect.setBorderPainted(false);
        //btConnect.setFocusPainted(false);
        //btConnect.setContentAreaFilled(false);
        btConnect.setForeground(Color.decode("#000000"));
        btConnect.setBackground(Color.decode("#379EC1"));

        // Securiface streamer
        // ...

        mainPanel.add(btConnect);
        this.add(mainPanel);
        this.pack();

        this.setVisible(true);
    }
}
