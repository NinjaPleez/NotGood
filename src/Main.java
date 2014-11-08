import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Main {
	//Found the entry point.
	public static void main(String[] argv) {
		initDisplay(800,600);
		initGL(800,600);
		Game game = new Game();
		while (true) {
			game.update();
			game.render();		
			Display.update();
			Display.sync(100);
 
			if (Display.isCloseRequested()) {
				Display.destroy();
				System.exit(0);
			}
		}

	}
	
	private static void initDisplay(int width, int height)
	{
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Initialize the GL display
	 * 
	 * @param width The width of the display
	 * @param height The height of the display
	 */
	private static void initGL(int width, int height) {
 
		GL11.glEnable(GL11.GL_TEXTURE_2D);               
 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          
 
        	// enable alpha blending
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        	GL11.glViewport(0,0,width,height);
		//GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		
	}
}
