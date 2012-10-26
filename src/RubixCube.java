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
	public RubixCube(int size) {
		this.size = size;
		this.blocks = new RubixBlock[size][size][size];
		for (int x = 0; x < size; x++) 
			for (int y = 0; y < size; y++)
				for (int z = 0; z < size; z++) 
					blocks[x][y][z] = new RubixBlock(RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW,RubixBlock.Side.YELLOW);
	}
}
