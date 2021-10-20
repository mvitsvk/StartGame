package gb.ru.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import gb.ru.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    public Texture img;
    public Vector2 touch;
    public Vector2 v;
    public Vector2 mouseKey;
    public Vector2 length_res;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        v = new Vector2(1, 1);
        mouseKey = new Vector2(0, 0);
        length_res = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        batch.draw(img, touch.x, touch.y);
        batch.end();
        //touch.add(v);
        update();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mouseKey.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    public void update(){
        if ((mouseKey.x > touch.x) & (mouseKey.y == touch.y)) v.set (1,0);
        if ((mouseKey.x > touch.x) & (mouseKey.y > touch.y)) v.set (1,1);
        if ((mouseKey.x > touch.x) & (mouseKey.y < touch.y)) v.set (1,-1);

        if ((mouseKey.x == touch.x) & (mouseKey.y == touch.y)) v.set (0,0);
        if ((mouseKey.x == touch.x) & (mouseKey.y > touch.y)) v.set (0,1);
        if ((mouseKey.x == touch.x) & (mouseKey.y < touch.y)) v.set (0,-1);

        if ((mouseKey.x < touch.x) & (mouseKey.y == touch.y)) v.set (-1,0);
        if ((mouseKey.x < touch.x) & (mouseKey.y > touch.y)) v.set (-1,1);
        if ((mouseKey.x < touch.x) & (mouseKey.y < touch.y)) v.set (-1,-1);

        touch.add(v);
    }

}
