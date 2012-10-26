import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;

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
		boolean running = true;
		while (running) {
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
