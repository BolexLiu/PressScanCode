package com.bolex.pressscan;
import java.io.FileNotFoundException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.zxing.LuminanceSource;

public class RGBLuminanceSource extends LuminanceSource {
    private final byte[] luminances;

    public RGBLuminanceSource(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        //得到图片的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //得到图片的像素
        int[] pixels = new int[width * height];
        //
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        //为了测量纯解码速度,我们将整个图像灰度阵列前面,这是一样的通道
        // YUVLuminanceSource在现实应用。
        //得到像素大小的字节数
        luminances = new byte[width * height];
        //得到图片每点像素颜色
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                int pixel = pixels[offset + x];
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                //当某一点三种颜色值相同时，相应字节对应空间赋值为其值
                if (r == g && g == b) {
                    luminances[offset + x] = (byte) r;
                } 
                //其它情况字节空间对应赋值为：
                else {  
                    luminances[offset + x] = (byte) ((r + g + g + b) >> 2);
                }
            }
        }
    }


    @Override
    public byte[] getMatrix() {
        return luminances;
    }

    @Override
    public byte[] getRow(int arg0, byte[] arg1) {
        if (arg0 < 0 || arg0 >= getHeight()) {
            throw new IllegalArgumentException(
                    "Requested row is outside the image: " + arg0);
        }
        int width = getWidth();
        if (arg1 == null || arg1.length < width) {
            arg1 = new byte[width];
        }
        System.arraycopy(luminances, arg0 * width, arg1, 0, width);
        return arg1;
    }

}