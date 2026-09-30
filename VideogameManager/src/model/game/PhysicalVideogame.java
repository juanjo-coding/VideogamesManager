package model.game;

import model.enums.Platform;
import model.enums.Genre;

public class PhysicalVideogame extends Videogame {

    private Double shippingCost;

    public PhysicalVideogame(String title, Genre genre, Double basePrice, Platform platform, Double shippingCost) {
        super(title, genre, basePrice, platform);
        setShippingCost(shippingCost);
    }

    @Override
    public Double calculateFinalPrice() {
        return basePrice + shippingCost;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        if (shippingCost == null || shippingCost < 0) {
            throw new IllegalArgumentException("Shipping costs must be at least 0.");
        }
        this.shippingCost = shippingCost;
    }
}
