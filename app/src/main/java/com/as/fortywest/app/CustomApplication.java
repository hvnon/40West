package com.as.fortywest.app;

import android.app.Application;

import com.as.fortywest.BuildConfig;
import com.github.stkent.bugshaker.BugShaker;
import com.github.stkent.bugshaker.flow.dialog.AlertDialogType;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by slock on 3/28/2016.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader imageLoader = ImageLoader.getInstance();
        if (!imageLoader.isInited()) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }

//        BugShaker.get(this)
//                .setEmailAddresses("slocknon@gmail.com")   // required
//                .setEmailSubjectLine("Custom Subject Line") // optional
//                .setAlertDialogType(AlertDialogType.NATIVE) // optional
//                .setLoggingEnabled(BuildConfig.DEBUG)       // optional
//                .setIgnoreFlagSecure(true)                  // optional
//                .assemble()                                 // required
//                .start();                                   // required
    }

}