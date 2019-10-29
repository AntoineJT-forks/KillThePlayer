package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.Respawn;
import fr.leroideskiwis.utils.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

public class RespawnObject extends SpecialObjBlock {
    public RespawnObject(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public float chance() {
        return 0.06f;
    }

    @Override
    public Entity newEntity() {
        return new Respawn();
    }

    @Override
    public String name() {
        return "Respawn objects";
    }
}
