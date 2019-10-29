package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.entities.Obstacle;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.Reparator;
import fr.leroideskiwis.utils.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

public class ReparatorObject extends SpecialObjBlock{
    public ReparatorObject(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public float chance() {
        if(game.getMap().getEntitiesByType(Obstacle.class).stream().anyMatch(Obstacle::wasObject))
            return 0.06f;
        return 0f;
    }

    @Override
    public Entity newEntity() {
        return new Reparator();
    }

    @Override
    public String name() {
        return "obstacle reparator";
    }
}
