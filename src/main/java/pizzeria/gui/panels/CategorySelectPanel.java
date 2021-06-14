package pizzeria.gui.panels;

import pizzeria.gui.components.CategorySelector;
import pizzeria.gui.components.Navbar;
import pizzeria.order_system.menu.repositories.menu_item.DrinkRepository;
import pizzeria.order_system.menu.repositories.menu_item.MenuItemRepository;
import pizzeria.order_system.menu.repositories.menu_item.PizzaRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static pizzeria.gui.settings.ImagePaths.*;
import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;

public class CategorySelectPanel extends AbstractGridBagPanel {

    public CategorySelectPanel(JFrame parentFrame) {
        super(parentFrame);

        setBackground(BG_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 60, 0);
        add(new Navbar(parentFrame, "Kategorie", this, new StartPanel(parentFrame)), gbc);

        String sectionTitle = "Pizza";
        JPanel pizzaCategorySelector = new CategorySelector(parentFrame, sectionTitle, PIZZA_CATEGORY_IMG);
        pizzaCategorySelector.addMouseListener(new CategorySelectorListener(new PizzaRepository(), sectionTitle, PIZZA_PLACEHOLDER_IMG));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(-30, 275, 0, 25);
        add(pizzaCategorySelector, gbc);

        sectionTitle = "Napoje";
        JPanel drinksCategorySelector = new CategorySelector(parentFrame, sectionTitle, DRINK_CATEGORY_IMG);
        drinksCategorySelector.addMouseListener(new CategorySelectorListener(new DrinkRepository(), sectionTitle, DRINK_PLACEHOLDER_IMG));
        gbc.gridx = 1;
        gbc.insets = new Insets(-30, 25, 0, 275);
        add(drinksCategorySelector, gbc);

        revalidate();
        repaint();
    }

    private class CategorySelectorListener extends MouseAdapter {

        private final MenuItemRepository repository;
        private final String sectionTitle;
        private final String placeholderPath;

        public CategorySelectorListener(MenuItemRepository repository, String sectionTitle, String placeholderPath) {
            this.repository = repository;
            this.sectionTitle = sectionTitle;
            this.placeholderPath = placeholderPath;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                parentFrame.remove(CategorySelectPanel.this);
                parentFrame.add(new MenuItemSelectPanel(parentFrame, repository, sectionTitle, placeholderPath));

                parentFrame.revalidate();
                parentFrame.repaint();
        }
    }
}
