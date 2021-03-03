package net.heinousgames.bug.libgdxfont;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Main extends ApplicationAdapter {

	private OrthographicCamera camera;
	private Stage stageUI;

	@Override
	public void create () {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("kenpixel_square.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.color = Color.BLACK;
		BitmapFont ttfFont = generator.generateFont(parameter);
		generator.dispose();

		Label.LabelStyle ttfStyle = new Label.LabelStyle();
		ttfStyle.font = ttfFont;

		Label label = new Label("Test Text", ttfStyle);
		label.setAlignment(Align.center);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 288, 208);
		camera.position.set(288/2, 208/2, 0);
		camera.update();
		stageUI = new Stage(new StretchViewport(288, 208, camera));

		Table lblTable = new Table();
		lblTable.setSize(288, 208);

		Label.LabelStyle fntStyle = new Label.LabelStyle();
		fntStyle.font = new BitmapFont(Gdx.files.internal("font_good_neighbors.fnt"));
		Label lblTitle = new Label("Test Text", fntStyle);
		lblTitle.setAlignment(Align.center);
		lblTable.add(label).row();
//		lblTable.add(lblTitle).row();
		stageUI.addActor(lblTable);

		lblTable.debug();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stageUI.act();
		stageUI.draw();
		camera.update();
	}
	
	@Override
	public void dispose () {
		stageUI.dispose();
	}
}
