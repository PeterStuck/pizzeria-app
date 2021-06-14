package pizzeria.gui.components;

import javax.swing.*;

import static pizzeria.gui.settings.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H1_FONT;

public class SectionHeader extends JLabel {

    public SectionHeader(String topText) {
        setText(topText);
        setFont(H1_FONT);
        setBorder(BorderFactory.createMatteBorder(0,0,3,0, ACCENT_COLOR));
        setHorizontalAlignment(JLabel.CENTER);
        setVisible(true);
    }
}
