package model.game;

import model.enums.Platform;
import model.exception.VideogameNotCompatibleException;
import java.util.ArrayList;
import java.util.List;

public class GamingConsole implements Console {
    private boolean isOn;
    private final List<Videogame> installedVideogames;
    private final Platform platform;

    public GamingConsole(Platform platform) {
        this.platform = platform;
        this.installedVideogames = new ArrayList<>();
        this.isOn = false;
    }

    @Override
    public void switchOn() {
        if (isOn) {
            System.out.println(platform.name() + " is already on.");
            return;
        }
        this.isOn = true;
        System.out.println(platform.name() + " is turning on.");
    }

    @Override
    public void switchOff() {
        if (!isOn) {
            System.out.println(platform.name() + " is already off.");
            return;
        }
        this.isOn = false;
        System.out.println(platform.name() + " is turning off.");
    }

    @Override
    public void installVideogame(Videogame videogame) throws VideogameNotCompatibleException {
        if (!isOn) {
            System.out.println("Cannot install " + videogame.getTitle() + ": " + platform.name() + " is powered off.");
            return;
        }
        if (!videogame.isCompatible(this)) {
            throw new VideogameNotCompatibleException(
                    videogame.getTitle() + " is not compatible with " + platform.name() + ".");
        }

        if (installedVideogames.contains(videogame)) {
            System.out.println(videogame.getTitle() + " is already installed on " + platform.name() + ".");
            return;
        }
        installedVideogames.add(videogame);
        System.out.println(videogame.getTitle() + " has been installed successfully.");
    }

    @Override
    public void playVideogame() {
        if (!isOn) {
            System.out.println("Cannot play: " + platform.name() + " is powered off.");
            return;
        }
        if (installedVideogames.isEmpty()) {
            System.out.println("No games installed on " + platform.name() + ".");
            return;
        }
        Videogame firstGame = installedVideogames.get(0);
        System.out.println("Playing " + firstGame.getTitle() + " on " + platform.name() + ".");
    }

    @Override
    public Boolean isCompatible(Videogame videogame) {
        return videogame != null && videogame.getPlatform() == this.platform;
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }

    public boolean isOn() {
        return isOn;
    }

    public List<Videogame> getInstalledVideogames() {
        return new ArrayList<>(installedVideogames);
    }
}
