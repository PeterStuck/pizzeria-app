package pizzeria.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGridBagPanel extends JPanel {
    protected final Color BG_COLOR = new Color(255,231,163);
    protected final Color BTN_COLOR = new Color(240,203,98);
//    protected final Color BG_COLOR = new Color(255,231,163);
//    protected final Color BG_COLOR = new Color(255,231,163);


    protected final GridBagConstraints gbc = new GridBagConstraints();
    protected JFrame parentFrame;

    public AbstractGridBagPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridBagLayout());

        setPreferredSize(new Dimension(1000, 500));
        setMinimumSize(new Dimension(1000, 500));
        setMaximumSize(new Dimension(1000, 500));

        setVisible(true);
    }

}
