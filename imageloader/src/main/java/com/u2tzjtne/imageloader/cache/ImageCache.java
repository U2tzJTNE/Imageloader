package com.u2tzjtne.imageloader.cache;

import android.graphics.Bitmap;

/**
 * @author u2tzjtne
 */
public interface ImageCache {
    /**
     * @param url image url
     * @return bitmap
     */
    Bitmap get(String url);

    /**
     * @param url    image url
     * @param bitmap image
     */
    void put(String url, Bitmap bitmap);
}
