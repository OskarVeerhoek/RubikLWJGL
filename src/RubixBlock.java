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
	public Side leftSide, rightSide, topSide, bottomSide, frontSide, backSide;
	public RubixBlock(Side leftSide, Side rightSide, Side topSide, Side bottomSide, Side frontSide, Side backSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.topSide = topSide;
		this.bottomSide = bottomSide;
		this.frontSide = frontSide;
		this.backSide = backSide;
	}
}
