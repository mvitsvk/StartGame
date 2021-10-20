package gb.ru;

		import com.badlogic.gdx.ApplicationAdapter;
		import com.badlogic.gdx.graphics.Texture;
		import com.badlogic.gdx.graphics.g2d.SpriteBatch;

		import java.util.Random;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, fon;
	int x, y;
	Random rand = new Random ();


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("звезды_DoV (14).png");
		fon = new Texture("Starry-Sky-HD-2560x2048.jpg");
		y = 900;
		x= rand.nextInt(400);
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(fon, 0,0, 400 , 800);
		batch.draw(img, x, y, 150, 150);
		batch.end();
		y--;
		y--;
		if (y <= -150) {
			y=900;
			x= rand.nextInt(400);
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		fon.dispose();
	}
}
