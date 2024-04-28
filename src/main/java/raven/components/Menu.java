package raven.components;

import net.miginfocom.swing.MigLayout;
import raven.swing.blur.BlurBackground;
import raven.swing.blur.BlurChild;
import raven.swing.blur.style.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Menu extends JPanel {

    private DesktopPaneCustom desktopPaneCustom;

    public Menu(DesktopPaneCustom desktopPaneCustom) {
        this.desktopPaneCustom = desktopPaneCustom;
        init();
    }

    private void init() {
        background = new BlurBackground(new ImageIcon(getClass().getResource("/raven/image/background.png")).getImage());
        background.setLayout(new MigLayout("al center center"));
        blurChild = new BlurChild(getStyle());
        blurChild.setLayout(new MigLayout("insets 50,wrap 5,gap 20", "[sg,fill]", "[sg,fill]"));
        background.add(blurChild);

        setLayout(new BorderLayout());

        add(background);

        createMenu();
    }

    private void createMenu() {
        Item itemDashboard = new Item("Dashboard", "raven/menu/dashboard.svg");
        Item itemProduct = new Item("Product", "raven/menu/product.svg");
        Item itemLocation = new Item("Location", "raven/menu/location.svg");
        Item itemBin = new Item("Recycle Bin", "raven/menu/bin.svg");
        Item itemVlc = new Item("VLC Player", "raven/menu/vlc.svg");
        Item itemGta = new Item("GTA 5", "raven/menu/gta.svg");
        Item itemSetting = new Item("Setting", "raven/menu/setting.svg");
        Item itemCalculator = new Item("Calculator", "raven/menu/calculator.svg");
        Item itemGmail = new Item("Gmail", "raven/menu/gmail.svg");
        Item itemWeather = new Item("Weather", "raven/menu/weather.svg");
        Item itemUser = new Item("User", "raven/menu/user.svg");
        Item itemCamera = new Item("Camera", "raven/menu/camera.svg");
        Item itemTelegram = new Item("Telegram", "raven/menu/telegram.svg");

        itemDashboard.addActionListener(e -> {
            desktopPaneCustom.addFrame("Dashboard", new JLabel("Test", SwingConstants.CENTER));
        });


        blurChild.add(itemDashboard);
        blurChild.add(itemProduct);
        blurChild.add(itemLocation);
        blurChild.add(itemBin);
        blurChild.add(itemVlc);
        blurChild.add(itemGta);
        blurChild.add(itemSetting);
        blurChild.add(itemCalculator);
        blurChild.add(itemGmail);
        blurChild.add(itemWeather);
        blurChild.add(itemUser);
        blurChild.add(itemCamera);
        blurChild.add(itemTelegram);
    }

    private Style getStyle() {
        return new Style()
                .setBlur(30)
                .setBorder(new StyleBorder(30)
                        .setBorderWidth(1.5f)
                        .setOpacity(0.25f)
                        .setBorderColor(new GradientColor(new Color(150, 150, 150), new Color(230, 230, 230), new Point2D.Float(0, 0), new Point2D.Float(0, 1)))
                        .setDropShadow(new StyleDropShadow(new Color(0, 0, 0), 0.2f, new Insets(12, 12, 20, 20)))
                )
                .setOverlay(new StyleOverlay(new Color(255, 255, 255), 0.1f));
    }

    private BlurChild blurChild;
    private BlurBackground background;
}
