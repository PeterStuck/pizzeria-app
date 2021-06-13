package pizzeria.gui.panels;

import pizzeria.gui.components.CategorySelector;
import pizzeria.gui.components.SectionHeader;
import pizzeria.order_system.menu.repositories.menu_item.DrinkRepository;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;
import pizzeria.order_system.menu.repositories.menu_item.PizzaRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategorySelectPanel extends AbstractGridBagPanel {

    public CategorySelectPanel(JFrame parentFrame) {
        super(parentFrame);

        setBackground(BG_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(new SectionHeader("Kategorie"), gbc);

        String sectionTitle = "Pizza";
        JPanel pizzaCategorySelector = new CategorySelector(parentFrame, sectionTitle, "src\\main\\java\\assets\\pizza-slice.png");
        pizzaCategorySelector.addMouseListener(new CategorySelectorListener(new PizzaRepository(), sectionTitle));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 25);
        add(pizzaCategorySelector, gbc);

        sectionTitle = "Napoje";
        JPanel drinksCategorySelector = new CategorySelector(parentFrame,sectionTitle, "src\\main\\java\\assets\\drink.png");
        drinksCategorySelector.addMouseListener(new CategorySelectorListener(new DrinkRepository(), sectionTitle));
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 25, 0, 0);
        add(drinksCategorySelector, gbc);

        revalidate();
        repaint();
    }

    private class CategorySelectorListener extends MouseAdapter {

        private final MenuItemRepository repository;
        private final String sectionTitle;

        public CategorySelectorListener(MenuItemRepository repository, String sectionTitle) {
            this.repository = repository;
            this.sectionTitle = sectionTitle;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                parentFrame.remove(CategorySelectPanel.this);
                parentFrame.add(new MenuItemSelectPanel(parentFrame, repository, sectionTitle));

                parentFrame.revalidate();
                parentFrame.repaint();
        }
    }
}
