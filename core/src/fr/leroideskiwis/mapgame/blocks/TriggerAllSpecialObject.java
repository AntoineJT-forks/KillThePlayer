package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.TriggerAllSpecial;
import fr.leroideskiwis.utils.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

public class TriggerAllSpecialObject extends SpecialObjBlock {

    public TriggerAllSpecialObject(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public Entity newEntity() {
        return new TriggerAllSpecial();
    }

    @Override
    public float chance() {
        return 0.01f;
    }

    @Override
    public String name() {
        return "special trigger";
    }
}
