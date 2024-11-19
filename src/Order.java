public class Order {
    private String mainDish;
    private String garnish;
    private String drink;
    private String dessert;
    
    public String getMainDish() {
        return mainDish;
    }
    
    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }
    
    public String getGarnish() {
        return garnish;
    }
    
    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }
    
    public String getDrink() {
        return drink;
    }
    
    public void setDrink(String drink) {
        this.drink = drink;
    }
    
    public String getDessert() {
        return dessert;
    }
    
    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
    
    // Override method toString, но проспусти поля с null при выводе
    @Override
    public String toString() {
        var builder = new StringBuilder();
        
        builder.append("Ваш заказ:\n");
        
        if (mainDish != null)
            builder.append("Основное блюдо: ").append(mainDish).append("\n");
        
        if (garnish != null)
            builder.append("Гарнир: ").append(garnish).append("\n");
        
        if (drink != null)
            builder.append("Напиток: ").append(drink).append("\n");
        
        if (dessert != null)
            builder.append("Десерт: ").append(dessert).append("\n");
        
        return builder.toString();
    }
}
