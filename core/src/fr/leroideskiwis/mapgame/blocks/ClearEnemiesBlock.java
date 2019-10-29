package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.ClearEnnemiesEntity;

public class ClearEnemiesBlock extends SpecialObjBlock{

    public ClearEnemiesBlock(Game game, String path, TextureManager textureManager) {
        super(game, "clearennemis.png", textureManager);

    }

    @Override
    public Entity newEntity() {
        return new ClearEnnemiesEntity();
    }

    @Override
    public float chance() {
        return 0.004f;
    }

    @Override
    public String name() {
        return "clear map !";
    }
}
