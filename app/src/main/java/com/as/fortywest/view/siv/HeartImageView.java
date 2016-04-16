package com.as.fortywest.view.siv;

import android.content.Context;
import android.util.AttributeSet;

import com.as.fortywest.R;
import com.as.fortywest.view.siv.shader.ShaderHelper;
import com.as.fortywest.view.siv.shader.SvgShader;

public class HeartImageView extends ShaderImageView {

    public HeartImageView(Context context) {
        super(context);
    }

    public HeartImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeartImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public ShaderHelper createImageViewHelper() {
        return new SvgShader(R.raw.imgview_heart, SvgShader.BORDER_TYPE_FILL);
    }
}
