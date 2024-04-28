package raven.components;

import com.formdev.flatlaf.FlatClientProperties;
import raven.swing.AnimationIcon;
import raven.swing.animation.KeyFrames;
import raven.swing.blur.component.BlurButton;
import raven.swing.blur.style.GradientColor;
import raven.swing.blur.style.Style;
import raven.swing.blur.style.StyleBorder;
import raven.swing.blur.style.StyleOverlay;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Item extends BlurButton {

    public Item(String text, String icon) {
        super(new Style()
                .setBlur(5)
                .setBorder(new StyleBorder(15))
                .setOverlay(new StyleOverlay(new GradientColor(new Color(255, 255, 255), new Color(30, 30, 30), new Point2D.Float(0, 0), new Point2D.Float(0, 1)), 0.3f))
        );
        setText(text);
        if (icon != null) {
            AnimationIcon.AnimatedOption option = new AnimationIcon.AnimatedOption()
                    .setScaleInterpolator(new KeyFrames(0f, 0.4f))
                    .setRotateInterpolator(new KeyFrames(0f, 20f, 0f))
                    .setDuration(350);
            setIcon(new AnimationIconCustom(icon, 1.5f, option));
        }
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:10,20,10,20");
    }

    private class AnimationIconCustom extends AnimationIcon {

        public AnimationIconCustom(String name, float scale, AnimationIcon.AnimatedOption option) {
            super(name, scale, option);
        }

        @Override
        public float getValue(Component component) {
            return getModel().isRollover() ? 1f : 0f;
        }
    }
}
