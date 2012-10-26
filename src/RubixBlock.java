import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * A block of a rubix cube.
 * @author Oskar Veerhoek
 */
public class RubixBlock {
	public static enum Side { 
		WHITE(1, 1, 1), YELLOW(1, 1, 0), BLUE(0, 0, 1), GREEN(0, 1, 0), RED(1, 0, 0), ORANGE(1, 0.5f, 0);
		public final float r, g, b;
		Side(float red, float blue, float green) {
			this.r = red;
			this.b = blue;
			this.g = green;
		}
	}
	// TODO: Encapsulate variables.
	public Side leftSide, rightSide, topSide, bottomSide, frontSide, backSide;
	private int displayList;
	public RubixBlock(Side leftSide, Side rightSide, Side topSide, Side bottomSide, Side frontSide, Side backSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.topSide = topSide;
		this.bottomSide = bottomSide;
		this.frontSide = frontSide;
		this.backSide = backSide;
	}
	/**
	 * Performs initialisation, for example: creates rendering objects for OpenGL.
	 */
	public void initialise() {
		displayList = glGenLists(1);
		glNewList(displayList, GL_COMPILE);
		glBegin(GL_QUADS);
		glVertex2f(-1, -1);
		glVertex2f( 1, -1);
		glVertex2f( 1,  1);
		glVertex2f(-1,  1);
		glEnd();
		glEndList();
	}
}
