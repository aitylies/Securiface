package fr.securiface.Securiface;

import com.github.sarxos.webcam.*;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
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

        //WebcamPanel webcamPanel = GetWebcamPanel();
        //JPanel webcamPanel = new JPanel();

        //this.add(webcamPanel);
        mainPanel.add(btConnect);
        this.add(mainPanel);
        this.pack();

        this.setVisible(true);
    }

    private WebcamPanel GetWebcamPanel(){
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            System.out.println("Webcam : " + webcam.getName());
        } else {
            System.out.println("No webcam detected");
        }
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setDisplayDebugInfo(true);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(true);

        return webcamPanel;
    }
}
