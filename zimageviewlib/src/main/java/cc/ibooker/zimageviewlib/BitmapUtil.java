package cc.ibooker.zimageviewlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * Bitmap管理类
 *
 * @author 邹峰立
 */
public class BitmapUtil {
    /**
     * Drawable转换成一个Bitmap
     *
     * @param drawable drawable对象
     */
    public static Bitmap drawableToBitmap(@NonNull Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 调整图片的色相，饱和度，灰度
     *
     * @param srcBitmap  Bitmap原图
     * @param rotate     色相值
     * @param saturation 饱和度
     * @param scale      灰度
     */
    public static Bitmap modifyBitmap(Bitmap srcBitmap, float rotate, float saturation, float scale) {
        // 调整色相
        ColorMatrix rotateMatrix = new ColorMatrix();
        rotateMatrix.setRotate(0, rotate);
        rotateMatrix.setRotate(1, rotate);
        rotateMatrix.setRotate(2, rotate);

        // 调整色彩饱和度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        // 调整灰度
        ColorMatrix scaleMatrix = new ColorMatrix();
        scaleMatrix.setScale(scale, scale, scale, 1);

        // 叠加效果
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.postConcat(rotateMatrix);
        colorMatrix.postConcat(saturationMatrix);
        colorMatrix.postConcat(scaleMatrix);

        // 创建一个大小相同的空白Bitmap
        Bitmap dstBitmap = Bitmap.createBitmap(
                srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        // 载入Canvas，Paint
        Canvas canvas = new Canvas(dstBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        // 绘图
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        return dstBitmap;
    }
}
