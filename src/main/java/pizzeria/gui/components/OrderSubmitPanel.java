package pizzeria.gui.components;

import pizzeria.gui.MainFrame;
import pizzeria.order_system.order.models.Order;
import pizzeria.order_system.order.models.OrderItem;
import pizzeria.order_system.order.utility.OrderTotalCalculator;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.List;

import static pizzeria.gui.settings.PizzeriaColors.ACCENT_COLOR;
import static pizzeria.gui.settings.PizzeriaColors.BG_COLOR;
import static pizzeria.gui.settings.PizzeriaTypography.H4_FONT;
import static pizzeria.gui.settings.PizzeriaTypography.H5_FONT;

public class OrderSubmitPanel extends AbstractGridBagPanel {

    private final Dimension nameLabDim;
    private final Dimension quantityAndPriceDim ;
    private final Dimension totalPriceDim;

    private final Border emptyBorder;
    private final Insets orderItemInsets;
    private final Insets rightOrderItemInsets;

    public OrderSubmitPanel(JFrame parentFrame) {
        super(parentFrame);

        Order order = ((MainFrame) parentFrame).getOrder();
        List<OrderItem> orderList = order.getOrderList();

        int panelHeight = Math.max(orderList.size() * 40 + 50, 200);
        nameLabDim = new Dimension(190, 30);
        quantityAndPriceDim = new Dimension(100, 30);
        totalPriceDim = new Dimension(220, 30);

        emptyBorder = BorderFactory.createEmptyBorder(0, 10, 0, 0);

        orderItemInsets = new Insets(10, 10, 0, 0);
        rightOrderItemInsets = new Insets(10, 10, 0, 30);

        setBackground(BG_COLOR);

        Dimension panelDim = new Dimension(460, panelHeight);
        setMinimumSize(panelDim);
        setPreferredSize(panelDim);

        int nextGridY = 0;
        nextGridY = this.alignOrderItemsInSubmit(nextGridY, orderList);

        if (orderList.size() > 0) {
            this.alignOrderTotalInSubmit(nextGridY, order);
        }
    }

    private int alignOrderItemsInSubmit(int nextGridY, List<OrderItem> orderList) {
        for (OrderItem orderItem : orderList) {
            var tmpMenuItem = orderItem.getMenuItem();
            var nameLab = this.createLabel(
                    tmpMenuItem.getName(),
                    nameLabDim,
                    H4_FONT.deriveFont(Font.PLAIN),
                    JLabel.LEFT,
                    emptyBorder);
            gbc.gridx = 0;
            gbc.gridy = nextGridY;
            gbc.insets = orderItemInsets;
            add(nameLab, gbc);

            var quantityLab = this.createLabel(
                    String.valueOf(orderItem.getQuantity()),
                    quantityAndPriceDim,
                    H4_FONT.deriveFont(Font.PLAIN),
                    JLabel.CENTER,
                    null);
            gbc.gridx = 1;
            gbc.insets = orderItemInsets;
            add(quantityLab, gbc);

            var priceLab = this.createLabel(
                    String.valueOf(tmpMenuItem.getPrice()),
                    quantityAndPriceDim,
                    H4_FONT.deriveFont(Font.PLAIN),
                    JLabel.CENTER,
                    null);
            gbc.gridx = 2;
            gbc.insets = rightOrderItemInsets;
            add(priceLab, gbc);

            nextGridY++;
        }

        return nextGridY;
    }

    private void alignOrderTotalInSubmit(int nextGridY, Order order) {
        var totalLab = this.createLabel(
                "Razem do zapłaty:",
                nameLabDim,
                H4_FONT,
                JLabel.LEFT,
                emptyBorder);
        gbc.gridx = 0;
        gbc.gridy = nextGridY;
        gbc.insets = orderItemInsets;
        add(totalLab, gbc);

        var totalPriceLab = this.createLabel(
                String.format("%.2f", OrderTotalCalculator.calculateOrderTotal(order)),
                totalPriceDim,
                H4_FONT,
                JLabel.RIGHT,
                BorderFactory.createEmptyBorder(0, 0, 0, 25));
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = nextGridY;
        gbc.insets = new Insets(10, 0, 0, 30);
        add(totalPriceLab, gbc);
    }

    private JLabel createLabel(String text, Dimension dim, Font font, int alignment, Border border) {
        var label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(ACCENT_COLOR);
        label.setPreferredSize(dim);
        label.setFont(font);
        label.setHorizontalAlignment(alignment);
        label.setBorder(border);

        return label;
    }

}
