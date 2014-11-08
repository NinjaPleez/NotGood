import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Game {
	
	/** The texture that will hold the image details */	
	private Texture texture;
	
	public Game(){
		init();
	}
	
	//TODO Move all texture loading into Screen class.
	public void init() {
		 
		try {
			// load texture from PNG file
			texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/testImg.jpg"));
 
			System.out.println("Texture loaded: "+texture);
			System.out.println(">> Image width: "+texture.getImageWidth());
			System.out.println(">> Image height: "+texture.getImageHeight());
			System.out.println(">> Texture width: "+texture.getTextureWidth());
			System.out.println(">> Texture height: "+texture.getTextureHeight());
			System.out.println(">> Texture ID: "+texture.getTextureID());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gameLoop(){
		while (true) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			//TODO: Move rendering further down the hierarchy so 
			//that each screen handles its own render
			render();
 
			Display.update();
			Display.sync(100);
 
			if (Display.isCloseRequested()) {
				Display.destroy();
				System.exit(0);
			}
		}
	}
	
	// TODO: Move this whole function down into Screen class.
	/**
	 * draw a quad with the image on it
	 */
	public void render() {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
 
		GL11.glBegin(GL11.GL_QUADS);
			//Top Left
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(0,0);
			//Top Right
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(800,0);
			//GL11.glVertex2f(texture.getTextureWidth(),0);
			//Bottom Right
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(800,600);
			//GL11.glVertex2f(texture.getTextureWidth(),texture.getTextureHeight());
			//Bottom Left
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(0,600);
			//GL11.glVertex2f(0,texture.getTextureHeight());
		GL11.glEnd();
	}
}
