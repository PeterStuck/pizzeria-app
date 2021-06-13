package pizzeria.gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGridBagPanel extends JPanel {

    protected final Color BG_COLOR = new Color(255,231,163);
<<<<<<< HEAD:src/main/java/pizzeria/gui/AbstractGridBagPanel.java
    protected final Color BTN_COLOR = new Color(255, 239, 194);
    protected final Color ACCENT_COLOR = new Color(252, 197, 93);
    protected final Font CATEGORY_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 30);

//    protected final Color BG_COLOR = new Color(255,231,163);
//    protected final Color BG_COLOR = new Color(255,231,163);
=======
    protected final Color BTN_COLOR = new Color(240,203,98);
>>>>>>> 58eb02ad47b0ba6e381b3f559bd80c719e986a44:src/main/java/pizzeria/gui/panels/AbstractGridBagPanel.java

    protected final Font HEADER_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 40);

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
