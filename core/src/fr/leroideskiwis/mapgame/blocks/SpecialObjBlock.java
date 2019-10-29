package fr.leroideskiwis.mapgame.blocks;

import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.managers.TextureManager;
import fr.leroideskiwis.utils.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SpecialObjBlock extends Block implements Chanceable {

    private static List<Block> specialsObjs = new ArrayList<>();


    public static void register(Game game, TextureManager textureManager){
        specialsObjs.add(new RayonEnnemyKillerObject(game,"rayonkiller.png" , textureManager));
        specialsObjs.add(new TriggerAllSpecialObject(game, "trigger.png", textureManager));
        specialsObjs.add(new ReparatorObject(game, "reparator.png", textureManager));
        specialsObjs.add(new HorizontalOpenPathObject(game, "openpathH.png", textureManager));
        specialsObjs.add(new VerticalOpenPathObject(game, "openpathV.png", textureManager));
        specialsObjs.add(new RespawnObject(game, "respawnobject.png", textureManager));
        specialsObjs.add(new InvinciblePlayerObject(game, "invincible.png", textureManager));
    }

    public SpecialObjBlock(Game game, String path, TextureManager textureManager) {
        super(game, path, textureManager);
    }

    @Override
    public Chanceable randomPick(RandomPicker randomPicker) {
        return randomPicker.randomItem(specialsObjs.stream().map(block -> (Chanceable)block).collect(Collectors.toList()));
    }
}
