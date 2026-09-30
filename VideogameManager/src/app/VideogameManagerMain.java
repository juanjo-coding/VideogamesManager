package app;

import model.enums.Genre;
import model.enums.Platform;
import model.exception.VideogameNotCompatibleException;
import model.game.Console;
import model.game.GamingConsole;
import model.game.DigitalVideogame;
import model.game.PhysicalVideogame;
import model.game.Videogame;

import java.util.ArrayList;
import java.util.List;

public class VideogameManagerMain {

    public static void main(String[] args) {
        Console playstation = new GamingConsole(Platform.PLAYSTATION);
        Console xbox = new GamingConsole(Platform.XBOX);
        Console nintendoSwitch = new GamingConsole(Platform.SWITCH);

        Videogame zelda = new PhysicalVideogame("The Legend of Zelda", Genre.ADVENTURE, 59.99, Platform.SWITCH, 5.0);
        Videogame minecraft = new DigitalVideogame("Minecraft", Genre.ADVENTURE, 29.99, Platform.PC, 0.10);
        Videogame dyingLight = new PhysicalVideogame("Dying Light", Genre.ACTION, 42.99, Platform.PLAYSTATION, 1.0);
        Videogame halo = new DigitalVideogame("Halo Infinite", Genre.SHOOTER, 69.99, Platform.XBOX, 0.20);

        zelda.addGenre(Genre.RPG);
        zelda.addGenre(Genre.ACTION);
        minecraft.addGenre(Genre.CASUAL);

        List<Videogame> catalog = new ArrayList<>();
        catalog.add(zelda);
        catalog.add(minecraft);
        catalog.add(dyingLight);
        catalog.add(halo);

        for (Videogame game : catalog) {
            System.out.println("Title: " + game.getTitle());
            System.out.println("Platform: " + game.getPlatform());
            System.out.println("Genres: " + game.getGenres());
            System.out.printf("Base price: %.2f € | Final price: %.2f €%n", game.getBasePrice(), game.calculateFinalPrice());
            System.out.println("----------------------------------------");
        }

        playstation.switchOn();
        xbox.switchOn();
        nintendoSwitch.switchOn();
        System.out.println();

        try {
            playstation.installVideogame(dyingLight);
            playstation.playVideogame();
        } catch (VideogameNotCompatibleException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();

        try {
            xbox.installVideogame(halo);
            xbox.playVideogame();
        } catch (VideogameNotCompatibleException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();

        try {
            nintendoSwitch.installVideogame(zelda);
            nintendoSwitch.playVideogame();
        } catch (VideogameNotCompatibleException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();

        try {
            playstation.installVideogame(zelda);
        } catch (VideogameNotCompatibleException e) {
            System.err.println("Incompatibility caught: " + e.getMessage());
        }

        System.out.println();

        Videogame haloCopy = new DigitalVideogame("Halo Infinite", Genre.SHOOTER, 69.99, Platform.XBOX, 0.20);
        try {
            xbox.installVideogame(haloCopy);
        } catch (VideogameNotCompatibleException e) {
            System.err.println("Incompatibility caught: " + e.getMessage());
        }

        System.out.println();

        playstation.switchOff();
        xbox.switchOff();
        nintendoSwitch.switchOff();

        System.out.println();

        try {
            xbox.installVideogame(halo);
            xbox.playVideogame();
        } catch (VideogameNotCompatibleException e) {
            System.err.println("Incompatibility caught: " + e.getMessage());
        }
    }
}
