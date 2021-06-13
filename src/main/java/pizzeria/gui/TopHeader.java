package pizzeria.gui;

import javax.swing.*;
import java.awt.*;

public class TopHeader extends JLabel {
    protected final Font TOP_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 40);
    protected final Color ACCENT_COLOR = new Color(252, 197, 93);
    public TopHeader(String topText) {

        setText(topText);
        setFont(TOP_FONT);
        setBorder(BorderFactory.createMatteBorder(0,0,3,0,ACCENT_COLOR));
        setVisible(true);

    }
}
