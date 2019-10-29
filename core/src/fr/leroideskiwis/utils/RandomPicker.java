package fr.leroideskiwis.utils;

import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.entities.Enemy;
import fr.leroideskiwis.mapgame.entities.SpecialObj;
import fr.leroideskiwis.mapgame.entities.enemies.BasicEnemy;
import fr.leroideskiwis.mapgame.impl.Chanceable;
import fr.leroideskiwis.mapgame.specialobjects.RayonEnnemyKiller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomPicker {

    private final Random random = new Random();
    public final Game game;

    public RandomPicker(Game game){
        this.game = game;
    }

    public Chanceable randomItem(List<Class<? extends Chanceable>> clazzList, Object... initargs){

        List<Chanceable> list = clazzList.stream().map(chanceable -> {
            try {
                return (Chanceable)chanceable.getConstructors()[0].newInstance(initargs);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        return randomItem(list);
    }

    public Chanceable randomItem(List<Chanceable> items) {
        float total = 0;

        for (Chanceable specialObject : items)
            total += specialObject.chance();

        float rf = random.nextFloat();
        rf *= total;

        float cur = 0;
        for(Chanceable item : items) {
            float proba = item.chance();

            if(rf >= cur && rf < cur + proba)
                return item;

            cur += proba;
        }

        return items.stream().findFirst().orElse(null);
    }

}