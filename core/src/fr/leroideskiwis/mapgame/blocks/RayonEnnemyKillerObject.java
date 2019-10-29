package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.RayonEnnemyKiller;
import fr.leroideskiwis.utils.Chanceable;

public class RayonEnnemyKillerObject extends SpecialObjBlock {
    public RayonEnnemyKillerObject(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public float chance() {
        return 0.69f;
    }

    @Override
    public Entity newEntity() {
        return new RayonEnnemyKiller();
    }

    @Override
    public String name() {
        return "ennemy rayon killer";
    }
}
