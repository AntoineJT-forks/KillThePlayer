package fr.leroideskiwis.mapgame;

public class Invincibility {

    private int tour;

    public boolean isInvincible(){
        return tour > 0;
    }

    public void removeOne(){
        tour--;
    }

    public void addInvincility(){
        tour += 3;
    }

    public void display(Game game){
        game.sendMessage("You're invincible mode will be disabled in "+tour+" moves");
    }
}
