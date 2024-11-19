public class OrderBuilder {
    private final Order order = new Order();
    
    public OrderBuilder addMainDish(String mainDish) {
        if (mainDish.isBlank())
            return this;
        
        order.setMainDish(mainDish);
        return this;
    }
    
    public OrderBuilder addGarnish(String garnish) {
        if (garnish.isBlank())
            return this;
        
        order.setGarnish(garnish);
        return this;
    }
    
    public OrderBuilder addDrink(String drink) {
        if (drink.isBlank())
            return this;
        
        order.setDrink(drink);
        return this;
    }
    
    public OrderBuilder addDessert(String dessert) {
        if (dessert.isBlank())
            return this;
        
        order.setDessert(dessert);
        return this;
    }
    
    public Order build() {
        return order;
    }
}
