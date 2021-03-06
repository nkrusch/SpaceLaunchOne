package io.github.nkrusch.spacelaunchone.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.squareup.picasso.Transformation;

/**
 * Create blurred image w/ picasso
 *
 * USAGE:
 *
 * Picasso.get()
 *   .load(imageUri)
 *   .transform(new BlurTransform(context, 25))
 *   .into(mImageView);
 */
public class BlurTransform implements Transformation {
    private static final int UP_LIMIT = 25;
    private static final int LOW_LIMIT = 1;
    private final Context context;
    private final int blurRadius;

    public BlurTransform(Context context, int radius) {
        this.context = context;

        if (radius < LOW_LIMIT) {
            this.blurRadius = LOW_LIMIT;
        } else this.blurRadius = Math.min(radius, UP_LIMIT);
    }

    @Override
    public Bitmap transform(Bitmap source) {

        Bitmap blurredBitmap = Bitmap.createBitmap(source);
        RenderScript renderScript = RenderScript.create(context);

        Allocation input = Allocation.createFromBitmap(
                renderScript, source,
                Allocation.MipmapControl.MIPMAP_FULL,
                Allocation.USAGE_SCRIPT);

        Allocation output = Allocation.createTyped(
                renderScript, input.getType());

        ScriptIntrinsicBlur script = ScriptIntrinsicBlur
                .create(renderScript, Element.U8_4(renderScript));

        script.setInput(input);
        script.setRadius(blurRadius);
        script.forEach(output);
        output.copyTo(blurredBitmap);

        return blurredBitmap;
    }

    @Override
    public String key() {
        return "blurred";
    }
}
