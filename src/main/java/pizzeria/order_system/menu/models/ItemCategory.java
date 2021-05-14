package pizzeria.order_system.menu.models;

public enum ItemCategory {

    PIZZA(1),
    DRINK(2);

    private final int index;

    ItemCategory(int index) {
        this.index = index;
    }

}
