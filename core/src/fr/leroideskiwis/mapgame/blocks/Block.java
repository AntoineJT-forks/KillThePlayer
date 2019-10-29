package fr.leroideskiwis.mapgame.blocks;

import com.badlogic.gdx.graphics.Texture;
import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;

public abstract class Block {

    public final Texture texture;
    public final Game game;

    public Block(Game game, String path, TextureManager textureManager){
        this.texture = textureManager.getTexture(path);
        this.game = game;
    }

    public abstract Entity newEntity();

    public int size(){
        return 1;
    };

    public abstract String name();

}
