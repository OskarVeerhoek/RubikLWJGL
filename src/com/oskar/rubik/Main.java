package com.oskar.rubik;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluErrorString;
import static com.oskar.rubik.RubixBlock.Side.*;

public class Main {
	public static void main(String[] args) throws LWJGLException {
		Display.setTitle("A Rubix Cube in LWJGL - Oskar");
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		try {
			Display.create(new PixelFormat(32, 0, 24, 8, 4));
		} catch (LWJGLException e) {
			System.err.println("Failed to create multisampled OpenGL context. Creating normal one.");
			try {
				Display.create();
			} catch (LWJGLException ex) {
				ex.printStackTrace();
				Display.destroy();
				System.exit(1);
			}
		}
		RubixCamera camera = new RubixCamera(5); // 18
		camera.initialise();
		RubixCube cube = new RubixCube(3);
		cube.initialise();
		glEnable(GL_LIGHTING);
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_DIFFUSE);
		glEnable(GL_LIGHT0);
		FloatBuffer lightPosition = BufferUtils.createFloatBuffer(4);
		lightPosition.put(0).put(0).put(-10).put(1);
		lightPosition.flip();
		glLight(GL_LIGHT0, GL_POSITION, lightPosition);
		System.out.println(gluErrorString(glGetError()));
		RubixBlock block = new RubixBlock(WHITE, YELLOW, BLUE, GREEN, RED, ORANGE);
		block.initialise();
		boolean running = true;
		while (running) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLight(GL_LIGHT0, GL_POSITION, lightPosition);
			camera.translate();
			camera.handleInput();
			cube.draw();
			block.draw();
			running = (Display.isCloseRequested()) ? false : running;
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
				running = false;
			}
			Display.update();
			Display.sync(120);
		}	
		Display.destroy();
	}
}
