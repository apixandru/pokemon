package com.apixandru.libgdx.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

import java.util.stream.Stream;

import static com.badlogic.gdx.graphics.Pixmap.Format.LuminanceAlpha;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 12, 2016
 */
public final class GdxUtils {

    private GdxUtils() {
    }

    public static void disposeAll(Disposable... disposables) {
        Stream.of(disposables)
                .forEach(Disposable::dispose);
    }

    public static Texture loadTexture(String location) {
        FileHandle fileHandle = Gdx.files.internal(location);
        return new Texture(fileHandle, LuminanceAlpha, false);
    }

}
