package fr.leroideskiwis.mapgame.entities;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.Location;
import fr.leroideskiwis.mapgame.Map;

public abstract class SpecialObj extends Entity{

    protected abstract void execute(Game game, Map map, Player player);

    public String toString(){
        return "!";
    }

    public Location spawn(Game main, Map map, Player player){

        return map.getRandomLocationWithSize(size());

    }

    public void kill(){
        delete(game.getMap());
        game.getMap().setEntity(getFirstLocation(), new Obstacle(this));
    }

    @Override
    public boolean onCollide(Game game, Map map, Player player) {
        game.sendMessage("You found a "+block.name());
        execute(game, map, player);
        return true;
    }
}