package fr.leroideskiwis.mapgame.entities;

import fr.leroideskiwis.mapgame.Entity;
import fr.leroideskiwis.mapgame.entities.enemies.BasicEnemy;
import fr.leroideskiwis.mapgame.impl.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends Entity implements Chanceable {

    private static List<Class<? extends Chanceable>> enemies = new ArrayList<>();

    static{
        enemies.add(BasicEnemy.class);
    }

    public Enemy(String path){
        super(path);
    }

    public void update(){}

    @Override
    public Chanceable randomPick(RandomPicker randomPicker) {
        return randomPicker.randomItem(enemies);
    }
}