package fr.leroideskiwis.mapgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import fr.leroideskiwis.mapgame.blocks.Block;
import fr.leroideskiwis.mapgame.entities.Player;
import fr.leroideskiwis.mapgame.specialobjects.InvinciblePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entity {

    private List<Location> locations;
    protected Block block;
    public Game game;

    public Entity() {
        this.locations = new ArrayList<>();
        setLocation(0, 0);
    }

    public Entity setLocation(int x, int y){
        if(getClass() == InvinciblePlayer.class){
            System.out.println("t");
        }

        locations.clear();

        for(int x1 = 0; x1 < size(); x1++){

            for(int y1 = 0; y1 < size(); y1++){

                Location currentLocation = new Location(x + x1, y + y1);
                locations.add(currentLocation);

            }

        }
        return this;
    }

    public void delete(Map map){
        Location location = locations.get(0);
        map.deleteEntity(location);
    }

    public Entity setLocation(Location location) {
        return setLocation(location.x, location.y);
    }

    public boolean isInvulnerable(){
        return false;
    }

    public boolean onCollide(Game game, Map map, Player player){
        return false;
    }

    public void draw(SpriteBatch batch, Rectangle rectangle) {
        batch.draw(block.texture, rectangle.x, rectangle.y, rectangle.width*size(), rectangle.height*size());
    }

    public int size(){
        return 1;
    }

    public boolean isLocatedAt(int x, int y) {
        return locations.stream()
                .anyMatch(location -> location.equals(x, y));
    }

    public List<Location> getSurroundingLocations(){

        List<Location> surroundingLocations = new ArrayList<>();
        Location location = locations.get(0);

        for(int x = location.x - 1; x <= location.x + 1; x++){
            for(int y = location.y - 1; y <= location.y + 1; y++){
                Location currentLocation = new Location(x, y);
                surroundingLocations.add(currentLocation);
            }
        }

        return surroundingLocations;
    }

    public List<Location> getSurroundingWithoutCorners(){
        Location location = locations.get(0);
        return getSurroundingLocations().stream().filter(location1 -> Math.abs(location1.x-location.x) != Math.abs(location.y-location1.y)).collect(Collectors.toList());
    }

    public Location getFirstLocation(){
        return locations.get(0);
    }

    public void init(Game game, Block block){
        this.block = block;
        this.game = game;

    }
}
