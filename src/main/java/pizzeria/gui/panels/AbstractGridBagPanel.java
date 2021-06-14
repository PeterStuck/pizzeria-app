package pizzeria.gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGridBagPanel extends JPanel {

    protected final GridBagConstraints gbc = new GridBagConstraints();
    protected JFrame parentFrame;

    public AbstractGridBagPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridBagLayout());

        var appDim = new Dimension(1000, 500);

        setPreferredSize(appDim);
        setMinimumSize(appDim);
        setMaximumSize(appDim);

        setVisible(true);
    }

}
