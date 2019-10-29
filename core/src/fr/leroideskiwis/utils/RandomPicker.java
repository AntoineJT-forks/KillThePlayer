package fr.leroideskiwis.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomPicker {

    private static final Random random = new Random();

    public Chanceable randomItem(List<Class<? extends Chanceable>> items, Object... initargs){
        List<Chanceable> chanceables = items.stream().map(item -> {

            try {
                return (Chanceable)item.getConstructors()[0].newInstance(initargs);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            return null;

        }).collect(Collectors.toList());

        return randomItem(chanceables);
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