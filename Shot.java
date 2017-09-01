package com.farmhero.farmhero.sprites;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kirk on 8/30/2017.
 */

/***
 * Shot class represents the blue print for a shot it extends from the
 * libGdx Shot class
 */
public class Shot extends Sprite {
    private Vector2 velocity;
    public static  int movement = 60;

    public Shot(Texture shotTexture) {
        super(shotTexture);
        this.velocity = new Vector2(0,0);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
    /***
     * fire(dt) takes delta time of the game loop and  update the x and y position
     *
     * @param dt
     */
    public void fire(float dt)
    {   int xmove =(int)(velocity.x*dt); // get x velocity
        // update the position of the shot by getting x and y only moving the  x position so
        //get the x position and update the x movement on each call of the update method which calls the fire method
        this.setPosition(this.getX()+xmove,this.getY());

    }


}
