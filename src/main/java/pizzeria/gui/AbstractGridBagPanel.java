package pizzeria.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGridBagPanel extends JPanel {

    protected final GridBagConstraints gbc = new GridBagConstraints();
    protected JFrame parentFrame;

    public AbstractGridBagPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridBagLayout());

        setVisible(true);
    }

}
