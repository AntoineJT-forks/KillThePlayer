package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.VerticalOpenPath;
import fr.leroideskiwis.utils.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

public class VerticalOpenPathObject extends SpecialObjBlock {
    public VerticalOpenPathObject(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public float chance() {
        return 0.075f;
    }

    @Override
    public Entity newEntity() {
        return new VerticalOpenPath();
    }

    @Override
    public String name() {
        return "open path";
    }
}
