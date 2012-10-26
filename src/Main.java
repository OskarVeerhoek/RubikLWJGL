import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import static org.lwjgl.opengl.GL11.*;

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
		RubixBlock block = new RubixBlock(RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.RED);
		block.initialise();
		boolean running = true;
		while (running) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			camera.translate();
			camera.handleInput();
			block.draw();
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
