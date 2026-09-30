package model.game;

import model.enums.Platform;
import model.exception.VideogameNotCompatibleException;

public interface Console {
    void switchOn();
    void switchOff();
    void installVideogame(Videogame videogame) throws VideogameNotCompatibleException;
    void playVideogame();

    Boolean isCompatible(Videogame videogame);
    Platform getPlatform();
}
