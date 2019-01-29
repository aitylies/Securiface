package fr.securiface.Securiface;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;


public class ConnectFrame extends JFrame {

    public static final String APP_TITLE = "Securiface";

    public ConnectFrame () {
        // GLOBAL SETTINGS
        this.setTitle(APP_TITLE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.setBackground(Color.WHITE);

        // GO SECURI LOGO
        InputStream imgGoSecuriLogo = getClass().getResourceAsStream("");

        // CONNECT BUTTON
        JButton btConnect = new JButton("CONNEXION");
        btConnect.setFont(new Font("Roboto", Font.PLAIN, 25));
        //btConnect.setBorderPainted(false);
        //btConnect.setFocusPainted(false);
        //btConnect.setContentAreaFilled(false);
        btConnect.setForeground(Color.decode("#000000"));
        btConnect.setBackground(Color.decode("#379EC1"));
        btConnect.setPreferredSize(new Dimension(50, 20));

        // SECURIFACE STREAMER
        JPanel securifaceStreamerPanel = new JPanel();
        securifaceStreamerPanel.setBackground(Color.decode("#379EC1"));
        JLabel lblSecurifaceStreamer = new JLabel("Securiface");
        lblSecurifaceStreamer.setForeground(Color.decode("#000000"));
        securifaceStreamerPanel.add(lblSecurifaceStreamer);

        // ADD COMPONENT TO MAIN PANEL
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.CENTER);
        mainPanel.add(btConnect, BorderLayout.CENTER);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.PAGE_END);
        mainPanel.add(securifaceStreamerPanel, BorderLayout.PAGE_END);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)), BorderLayout.PAGE_END);
        this.add(mainPanel);
        //this.pack();
        this.setVisible(true);
    }
}
