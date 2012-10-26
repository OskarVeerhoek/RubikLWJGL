import static org.lwjgl.opengl.GL11.*;

/**
 * A rubix cube.
 * @author Oskar Veerhoek
 */
public final class RubixCube {
	/**
	 * The width, height and length of the rubix cube in blocks.
	 */
	private final int size; 	
	private final RubixBlock[][][] blocks;
	private int displayList;
	public RubixCube(int size) {
		this.size = size;
		this.blocks = new RubixBlock[size][size][size];
		for (int x = 0; x < size; x++) 
			for (int y = 0; y < size; y++)
				for (int z = 0; z < size; z++) 
					blocks[x][y][z] = new RubixBlock(RubixBlock.Side.WHITE,RubixBlock.Side.YELLOW,RubixBlock.Side.BLUE,RubixBlock.Side.GREEN,RubixBlock.Side.RED,RubixBlock.Side.ORANGE);
	}
	public void initialise() {
		displayList = glGenLists(1);
		glNewList(displayList, GL_COMPILE);
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int z = 0; z < size; z++) {
					glPushMatrix();
					glScalef(0.1f, 0.1f, 0.1f);
					glTranslatef(x*10, y*10, z*10);
					blocks[x][y][z].drawInImmediateMode();
					glPopMatrix();
				}
			}
		}
		glEndList();
	}
	public void draw() {
		glCallList(displayList);
	}
}
