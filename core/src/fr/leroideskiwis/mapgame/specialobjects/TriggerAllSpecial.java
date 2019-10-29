package fr.leroideskiwis.mapgame.specialobjects;

import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.Map;
import fr.leroideskiwis.mapgame.entities.Player;
import fr.leroideskiwis.mapgame.entities.SpecialObj;

public class TriggerAllSpecial extends SpecialObj {

    @Override
    public void execute(Game game, Map map, Player player) {

        game.sendMessage("All special objects are been triggered");
        map.getEntitiesByType(SpecialObj.class).stream().filter(entity -> !(entity instanceof ClearEnnemiesEntity) && !(entity instanceof TriggerAllSpecial) && !(entity instanceof Respawn)).forEach(entity -> entity.onCollide(game, map, player));
    }

}
