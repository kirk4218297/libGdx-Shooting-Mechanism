package com.farmhero.farmhero.support;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.farmhero.farmhero.sprites.Hero;
import com.farmhero.farmhero.sprites.Shot;

import java.util.ArrayList;

/**
 * Created by kirk on 8/30/2017.
 */

/***
 * Shot Manager represent a blueprint of a shotManger object the
 * is used with the shot class to maintain and fire shots
 *
 * NB. Class does not dispose shot when shot leaves camera viewport
 * method need to dispose shots to save on  memory
 */
public class ShotManager {
    private static final int SHOT_X_OFFSET = 90;
    private static final float CYCLE_TIME = 0.5f;
    private static final int FRAME_COUNT = 0;
    private static final int SHOT_SPEEDX = 600;
    private static final int HERO_SHOTX_OFFSET = 30;
    private static final int HERO_SHOTY_OFFSET = 8;
    private java.util.List<Shot> shots = new ArrayList<Shot>();
    private Texture shotTexture;


    public ShotManager()
    {
        this.shotTexture =  new Texture("shot.png"); // add shot texture to memory


    }

    public void fireShot(Hero hero) {


        if(canFireShot())
        {
            Shot newShot = new Shot(shotTexture);
            newShot.setPosition(hero.getPosition().x+ HERO_SHOTX_OFFSET,hero.getPosition().y+ HERO_SHOTY_OFFSET);
            newShot.setVelocity(new Vector2(SHOT_SPEEDX,0)); // set the velocity of the shot to be fired Vextor2 x & y corrd
            shots.add(newShot);  // add new shot to the list
        }

    }

    private boolean canFireShot() {

        return  true;
    }

    public void update(float dt)
    {
        for(Shot shot:shots)
        {
          shot.fire(dt);

        }

    }
    public void draw(SpriteBatch batch) {

        for(Shot shot:shots)
        {

          shot.draw(batch);


        }

    }

    public java.util.List<Shot> getShots() {
        return shots;
    }
}
