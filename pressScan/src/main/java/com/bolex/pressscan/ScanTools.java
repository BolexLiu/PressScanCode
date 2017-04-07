package com.bolex.pressscan;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Bolex on 2017/3/27.
 */

public class ScanTools {

  public   interface ScanCall {
        void getCode(String code);
    }

    /**
     * 扫描当前View上的二维码
     * @param mView
     * @param mScanCall
     */
    public static void scanCode(View mView, ScanCall mScanCall){
        Bitmap bitmap = Bitmap.createBitmap(mView.getWidth(), mView.getHeight(), Bitmap.Config.RGB_565);
        final Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.rgb(0xf1, 0xf1, 0xf1));
        mView.draw(canvas);
        if (bitmap != null) {
            //todo:调用扫描
            String code = scanBitmap(bitmap);
            mScanCall.getCode(code);
        }
    }

    /**
     * 解析二维码
     * @param bitmap
     * @return
     */
    public static String scanBitmap(Bitmap bitmap) {
        Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
        RGBLuminanceSource rgbLuminanceSource = new RGBLuminanceSource(bitmap);
        //将图片转换成二进制图片
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(rgbLuminanceSource));
        //初始化解析对象
        QRCodeReader reader = new QRCodeReader();
        //开始解析
        Result result = null;
        try {
            result = reader.decode(binaryBitmap, hints);
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (result != null) {
            return result.getText();
        } else {
            return "";
        }

    }


}
