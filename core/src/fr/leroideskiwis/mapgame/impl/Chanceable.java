package fr.leroideskiwis.mapgame.impl;

import fr.leroideskiwis.utils.RandomPicker;

public interface Chanceable {

    float chance();

    Chanceable randomPick(RandomPicker randomPicker);

}
