import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class RubixCamera {
	/**
	 * The rotation along the three axes, x, y, and z.
	 */
	private Vector3f rotation;
	/**
	 * The translation along the z-axis.
	 */
	private float zoom;
	public RubixCamera() {
		this.rotation = new Vector3f(0, 0, 0);
		this.zoom = 07;
	}
	public void handleInput() {
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
		boolean up = Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean down = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		Vector3f movement = new Vector3f();
		// TODO: Place x before y.
		movement.y += right ?  1 : 0;
		movement.y += left  ? -1 : 0;
		movement.x += up 	?  1 : 0;
		movement.x += down	? -1 : 0;
		if (movement.length() != 0) {
			movement.normalise();
		}
		rotation = Vector3f.add(rotation, movement, rotation);
	}
	/**
	 * Call this method to apply the camera settings to the current OpenGL projection matrix.
	 */
	public void initialise() {
		//glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glPushAttrib(GL_TRANSFORM_BIT);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		// TODO: Add configuration for fov.
		// TODO: Tweak zNear and zFar.
		gluPerspective(40, (float) Display.getWidth() / (float) Display.getHeight(), 0.3f,100f);
		glPopAttrib();
	}
	/**
	 * Call this method to apply the camera coordinates to the current OpenGL modelview matrix.
	 */
	public void translate() {
		glPushAttrib(GL_TRANSFORM_BIT);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glTranslatef(0, 0, -zoom);
		glRotatef(-rotation.x, 1, 0, 0);
		glRotatef(-rotation.y, 0, 1, 0);
		glRotatef(-rotation.z, 0, 0, 1);
		glPopAttrib();
	}
}

