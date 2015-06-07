package com.github.apixandru.pokemon.ui.util;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Alexandru Bledea
 * @since May 17, 2015
 */
public final class Camera {

	private final int visibleWidth;
	private final int visibleHeight;

	/**
	 * @param visibleWidth
	 * @param visibleHeight
	 */
	public Camera(final int visibleWidth, final int visibleHeight) {
		this.visibleWidth = visibleWidth;
		this.visibleHeight = visibleHeight;
	}

	/**
	 * @param graphics
	 * @param position
	 */
	public void translate(final Graphics graphics, final Vector2f position) {
		final int x = compute(position.x, this.visibleWidth);
		final int y = compute(position.y, this.visibleHeight);
		graphics.translate(x, y);
	}

	/**
	 * @param position
	 * @param visibleRange
	 * @return
	 */
	private static int compute(final float position, final int visibleRange) {
		return (int) -position + visibleRange / 2;
	}

}
