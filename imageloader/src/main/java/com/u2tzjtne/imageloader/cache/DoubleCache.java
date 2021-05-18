package com.u2tzjtne.imageloader.cache;

import android.graphics.Bitmap;

/**
 * @author u2tzjtne
 */
public class DoubleCache implements ImageCache {
    private MemoryCache memoryCache = new MemoryCache();
    private DiskCache diskCache = new DiskCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }
}
