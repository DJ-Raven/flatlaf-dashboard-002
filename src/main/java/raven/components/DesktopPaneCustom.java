package raven.components;

import javax.swing.*;
import java.awt.*;

public class DesktopPaneCustom extends JDesktopPane {

    public DesktopPaneCustom() {
        init();
    }

    private void init() {
        setLayout(new DesktopLayout());
        menu = new Menu(this);
        setLayer(menu, JLayeredPane.FRAME_CONTENT_LAYER);
        add(menu);
    }

    public void addFrame(String title, Component component) {
        JInternalFrame frame = new JInternalFrame(title, true, true, true, true);
        try {
            frame.setMaximum(true);
        } catch (Exception e) {
        }
        frame.setFrameIcon(null);
        frame.add(component);
        frame.setSize(new Dimension(800, 500));
        frame.setVisible(true);
        add(frame);
    }

    private Menu menu;

    private class DesktopLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                menu.setBounds(x, y, width, height);
            }
        }
    }
}
