package raven.application;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import raven.components.DesktopPaneCustom;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private DesktopPaneCustom desktopPaneCustom = new DesktopPaneCustom();

    public Application() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        getContentPane().add(desktopPaneCustom);
    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }
}
