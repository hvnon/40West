package com.as.fortywest.view.siv;

import android.content.Context;
import android.util.AttributeSet;

import com.as.fortywest.R;
import com.as.fortywest.view.siv.shader.ShaderHelper;
import com.as.fortywest.view.siv.shader.SvgShader;

public class OctogonImageView extends ShaderImageView {

    public OctogonImageView(Context context) {
        super(context);
    }

    public OctogonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OctogonImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public ShaderHelper createImageViewHelper() {
        return new SvgShader(R.raw.imgview_octogon);
    }
}
