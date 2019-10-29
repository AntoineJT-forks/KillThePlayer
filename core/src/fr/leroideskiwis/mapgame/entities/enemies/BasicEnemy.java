package fr.leroideskiwis.mapgame.entities.enemies;

import fr.leroideskiwis.mapgame.entities.Enemy;
import fr.leroideskiwis.mapgame.impl.Chanceable;
import fr.leroideskiwis.utils.RandomPicker;

public class BasicEnemy extends Enemy {

    public BasicEnemy() {
        super("enemy.png");
    }

    @Override
    public float chance() {
        return 0;
    }
}
