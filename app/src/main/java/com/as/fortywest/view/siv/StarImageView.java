package com.as.fortywest.view.siv;

import android.content.Context;
import android.util.AttributeSet;

import com.as.fortywest.R;
import com.as.fortywest.view.siv.shader.ShaderHelper;
import com.as.fortywest.view.siv.shader.SvgShader;

public class StarImageView extends ShaderImageView {

    public StarImageView(Context context) {
        super(context);
    }

    public StarImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StarImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public ShaderHelper createImageViewHelper() {
        return new SvgShader(R.raw.imgview_star);
    }
}
