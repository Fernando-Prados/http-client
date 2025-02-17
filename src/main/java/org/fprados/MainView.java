package org.fprados;

import javax.swing.*;
import java.awt.*;

import org.fprados.views.RequestPanel;

public class MainView extends JFrame {

    public MainView() {
        super();
        setTitle("HTTP Client");
        setIconImage(new ImageIcon(MainView.class.getClassLoader().getResource("icons/logo.png")).getImage());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        RequestPanel panel = new RequestPanel();
        add(panel, BorderLayout.NORTH);

        setVisible(true);
    }
}
