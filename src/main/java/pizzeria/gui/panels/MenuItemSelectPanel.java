package pizzeria.gui.panels;

import pizzeria.gui.components.ItemSelectorPanel;
import pizzeria.gui.components.SectionHeader;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;

import javax.swing.*;
import java.awt.*;

import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.BTN_COLOR;

public class MenuItemSelectPanel extends AbstractGridBagPanel {

    public MenuItemSelectPanel(JFrame parentFrame, MenuItemRepository repository, String title) {
        super(parentFrame);
        setBackground(BG_COLOR);

        JButton backButton = new JButton(new ImageIcon("src\\main\\java\\assets\\go_back.png"));
        backButton.setBackground(BTN_COLOR);
        backButton.setBorder(null);
        backButton.setFocusPainted(false);
        backButton.setMinimumSize(new Dimension(50, 50));
        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                parentFrame.remove(MenuItemSelectPanel.this);
                parentFrame.add(new CategorySelectPanel(parentFrame));

                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 30, 30, 0);
        add(backButton, gbc);

        var sectionHeader = new SectionHeader(title);
        sectionHeader.setMinimumSize(new Dimension(250, 50));
        gbc.gridx = 1;
        gbc.weightx = 10;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(sectionHeader, gbc);

        var submitBtn = new JButton("PODSUMOWANIE");
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 30, 30);
        add(submitBtn, gbc);

        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setViewportView(new ItemSelectorPanel(parentFrame, repository.findAll()));
        scrollPane.setBorder(null);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 300;
        gbc.ipadx = 700;
        add(scrollPane, gbc);

        revalidate();
        repaint();
    }

}
