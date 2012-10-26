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
		boolean running = true;
		Vector3f rotation = new Vector3f(0, 0, 0);
		float zoom = 0;
		while (running) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			glTranslatef(0, 0, -zoom);
			glRotatef(-rotation.x, 1, 0, 0);
			glRotatef(-rotation.y, 0, 1, 0);
			glRotatef(-rotation.z, 0, 0, 1);
			glBegin(GL_TRIANGLES);
			glVertex2f(-1, -1);
			glVertex2f( 1, -1);
			glVertex2f( 1,  1);
			glEnd();
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
