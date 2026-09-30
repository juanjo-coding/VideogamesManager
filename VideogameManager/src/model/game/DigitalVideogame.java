package model.game;

import model.enums.Platform;
import model.enums.Genre;

public class DigitalVideogame extends Videogame {

    private Double discountPercentage;

    public DigitalVideogame(String title, Genre genre, Double basePrice, Platform platform, Double discountPercentage) {
        super(title, genre, basePrice, platform);
        setDiscountPercentage(discountPercentage);
    }

    @Override
    public Double calculateFinalPrice() {
        return basePrice - (basePrice * discountPercentage);
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        if (discountPercentage == null || discountPercentage < 0 || discountPercentage > 1) {
            throw new IllegalArgumentException("Discount percentage must be a number between 0 and 1.");
        }
        this.discountPercentage = discountPercentage;
    }
}
