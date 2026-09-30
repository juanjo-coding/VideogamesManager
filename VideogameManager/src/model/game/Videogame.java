package model.game;

import model.enums.Platform;
import model.enums.Genre;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Videogame {
    protected String title;
    protected List<Genre> genres;
    protected Double basePrice;
    protected Platform platform;

    public Videogame(String title, Genre genre, Double basePrice, Platform platform) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Videogame's title can't be empty.");
        }

        if (basePrice == null || basePrice < 0) {
            throw new IllegalArgumentException("Base price for a videogame must be at least 0.");
        }

        if (platform == null) {
            throw new IllegalArgumentException("Platform can't be null.");
        }

        this.title = title;
        this.genres = new ArrayList<>();
        this.basePrice = basePrice;
        this.platform = platform;
        addGenre(genre);
    }

    public abstract Double calculateFinalPrice();

    public Boolean isCompatible(Console console) {
        return console != null && console.getPlatform() == this.platform;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void addGenre(Genre genre) {
        if (genre != null && !genres.contains(genre)) {
            genres.add(genre);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Genre> getGenres() {
        return new ArrayList<>(genres);
    }

    public Double getBasePrice() {
        return basePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Videogame other)) return false;
        return Objects.equals(title, other.title) && platform == other.platform;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, platform);
    }
}
