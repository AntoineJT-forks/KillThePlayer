package fr.leroideskiwis.mapgame.specialobjects;

import fr.leroideskiwis.mapgame.Game;
import fr.leroideskiwis.mapgame.Location;
import fr.leroideskiwis.mapgame.Map;
import fr.leroideskiwis.mapgame.entities.Player;
import fr.leroideskiwis.mapgame.entities.SpecialObj;

public class InvinciblePlayer extends SpecialObj {

    @Override
    public void execute(Game game, Map map, Player player) {

        int invincibleTour = game.randomInt(5, 6);
        player.addInvincility(invincibleTour);
        game.sendMessage("You got "+invincibleTour+" invincible moves");

    }

    @Override
    public Location spawn(Game game, Map map, Player player) {
        return new RayonEnnemyKiller().spawn(game, map, player);
    }

}
