package fr.leroideskiwis.mapgame.entities;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.Location;
import fr.leroideskiwis.mapgame.Map;
import fr.leroideskiwis.mapgame.entities.enemies.BasicEnemy;
import fr.leroideskiwis.mapgame.impl.Chanceable;
import fr.leroideskiwis.mapgame.specialobjects.Respawn;
import fr.leroideskiwis.utils.RandomPicker;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecialObj extends Entity implements Chanceable{

    protected final Game game;

    private static List<Class<? extends Chanceable>> specialObjs = new ArrayList<>();

    static{
        //        specialObjs.add(RayonEnnemyKiller.class);
//        specialObjs.add(TriggerAllSpecial.class);
//        specialObjs.add(ClearEnnemies.class);
//        specialObjs.add(Reparator.class);
//        specialObjs.add(HorizontalOpenPath.class);
//        specialObjs.add(VerticalOpenPath.class);
        specialObjs.add(Respawn.class);
        //specialObjs.add(InvinciblePlayer.class);
    }

    protected abstract void execute(Game game, Map map, Player player);

    public SpecialObj(Game game, String path) {
        super(path);
        this.game = game;
    }

    public SpecialObj(Game game){
        this(game, null);
    }

    public String toString(){
        return "!";
    }

    public abstract String name();

    public Location spawn(Game main, Map map, Player player){

        return map.getRandomLocationWithSize(size());

    }

    public void kill(){
        delete(game.getMap());
        game.getMap().setEntity(getFirstLocation(), new Obstacle(this));
    }

    @Override
    public boolean onCollide(Game game, Map map, Player player) {
        game.sendMessage("You found a "+name());
        execute(game, map, player);
        return true;
    }

    @Override
    public Chanceable randomPick(RandomPicker randomPicker) {
        return randomPicker.randomItem(specialObjs, randomPicker.game);
    }
}