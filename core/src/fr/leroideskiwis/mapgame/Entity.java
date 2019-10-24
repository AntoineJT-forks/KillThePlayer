package fr.leroideskiwis.mapgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import fr.leroideskiwis.ktp.Main;
import fr.leroideskiwis.mapgame.entities.Player;
import fr.leroideskiwis.mapgame.managers.TextureManager;

public class Entity {

    private Location location;
    private String path;

    public Entity(Location location, String path){
        this(location.getX(), location.getY(), path);
    }

    public Entity(String path){
        this(0, 0, path);
    }

    public Entity(int x, int y, String path) {
        this.path = path;
        this.location = new Location(x,y);
    }

    public Entity setLocation(Location location){
        this.location = location;
        return this;
    }

    public int getX(){
        return location.getX();
    }

    public int getY(){
        return location.getY();
    }

    private Texture texture(TextureManager manager){

        if(manager.has(this))
            return manager.getTexture(this);
        else {
            manager.register(this, manager.getTexture(path));
            return texture(manager);
        }
    }

    public Location getLocation(){
        return location;
    }

    public Entity setLocation(int x, int y) {
        return setLocation(new Location(x, y));
    }

    public void draw(TextureManager manager, SpriteBatch batch, Rectangle rectangle) {
        batch.draw(texture(manager), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public boolean isInvulnerable(){
        return false;
    }

    public void onCollide(Game game, Map map, Player player){

    }
}
