package com.u2tzjtne.imageloader.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author u2tzjtne
 */
public class DiskCache implements ImageCache {
    private String cacheDir = Environment.getDownloadCacheDirectory().getAbsolutePath() + "/";

    public DiskCache() {

    }

    public DiskCache(String cacheDir) {
        if (TextUtils.isEmpty(cacheDir)) {
            return;
        }
        this.cacheDir = cacheDir;
    }

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
