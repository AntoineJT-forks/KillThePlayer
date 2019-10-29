package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.mapgame.specialobjects.InvinciblePlayer;
import fr.leroideskiwis.utils.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

public class InvinciblePlayerObject extends SpecialObjBlock {
    public InvinciblePlayerObject(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public float chance() {
        return 0.06f;
    }

    @Override
    public Entity newEntity() {
        return new InvinciblePlayer();
    }

    @Override
    public String name() {
        return "player invincible";
    }
}
