import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluErrorString;

public class Main {
	public static void main(String[] args) throws LWJGLException {
		Display.setTitle("A Rubix Cube in LWJGL - Oskar");
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		RubixCamera camera = new RubixCamera();
		camera.initialise();
		RubixCube cube = new RubixCube(3);
		cube.initialise();
//		RubixBlock block = new RubixBlock(RubixBlock.Side.WHITE,RubixBlock.Side.YELLOW,RubixBlock.Side.BLUE,RubixBlock.Side.GREEN,RubixBlock.Side.RED,RubixBlock.Side.ORANGE);
//		block.initialise();
		boolean running = true;
		while (running) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			camera.translate();
			camera.handleInput();
			System.out.println(gluErrorString(glGetError()));
			cube.draw();
			System.out.println(gluErrorString(glGetError()));
			//			block.draw();
			running = (Display.isCloseRequested()) ? false : running;
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
				running = false;
			}
			Display.update();
			Display.sync(60);
		}	
		Display.destroy();
	}
}
