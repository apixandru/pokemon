package com.github.apixandru.pokemon.ui.util;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Alexandru Bledea
 * @since May 17, 2015
 */
public final class Camera {

	private final float visibleWidth;
	private final float visibleHeight;

	/**
	 * @param visibleWidth
	 * @param visibleHeight
	 */
	public Camera(final float visibleWidth, final float visibleHeight) {
		this.visibleWidth = visibleWidth;
		this.visibleHeight = visibleHeight;
	}

	/**
	 * @param graphics
	 * @param position
	 */
	public void translate(final Graphics graphics, final Vector2f position) {
		final float x = compute(position.x, this.visibleWidth);
		final float y = compute(position.y, this.visibleHeight);
		graphics.translate(x, y);
	}

	/**
	 * @param position
	 * @param visibleRange
	 * @return
	 */
	private static float compute(final float position, final float visibleRange) {
		return visibleRange / 2 - position;
	}

}
