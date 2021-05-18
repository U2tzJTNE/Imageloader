package com.u2tzjtne.imageloader.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author u2tzjtne
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> lruCache;

    public MemoryCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 1/4 maxMemory
        final int cacheSize = maxMemory / 4;
        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String url, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return lruCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        lruCache.put(url, bitmap);
    }
}
