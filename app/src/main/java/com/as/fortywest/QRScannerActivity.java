package com.as.fortywest;

/**
 * Created by slock on 3/28/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.as.fortywest.adapter.ProductGridAdapter;
import com.as.fortywest.dummy.DummyContent;
import com.as.fortywest.model.Product;
import com.as.fortywest.model.ResponseResult;
import com.as.fortywest.ui.BaseScannerActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.drakeet.materialdialog.MaterialDialog;

import static com.as.fortywest.util.LogUtils.LOGE;
import static com.as.fortywest.util.LogUtils.LOGI;
import static com.as.fortywest.util.LogUtils.makeLogTag;

public class QRScannerActivity extends BaseScannerActivity implements ZXingScannerView.ResultHandler {
    private final String TAG = makeLogTag(QRScannerActivity.class);
    private ZXingScannerView mScannerView;
    private MaterialDialog mMaterialDialog;
    private ArrayList<Product> products;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_qr_scanner);
        setupToolbar();

        mMaterialDialog = new MaterialDialog(this);

        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZXingScannerView(this) {
            @Override
            protected IViewFinder createViewFinderView(Context context) {
                return new CustomViewFinderView(context);
            }
        };
        contentFrame.addView(mScannerView);

        // Init data
        new ProductsAsynTask().execute();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        LOGE(TAG + "_handler", rawResult.getText()); // Prints scan results
        LOGE(TAG + "_handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        if(rawResult.getText() != ""){
            scanningProcess(Integer.parseInt(rawResult.getText()));
        }

        // Open scanning back in 2 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(QRScannerActivity.this);
            }
        }, 2000);
    }

    private static class CustomViewFinderView extends ViewFinderView {
        public static final String TRADE_MARK_TEXT = "";
        public static final int TRADE_MARK_TEXT_SIZE_SP = 40;
        public final Paint PAINT = new Paint();

        public CustomViewFinderView(Context context) {
            super(context);
            init();
        }

        public CustomViewFinderView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            PAINT.setColor(Color.WHITE);
            PAINT.setAntiAlias(true);
            float textPixelSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                    TRADE_MARK_TEXT_SIZE_SP, getResources().getDisplayMetrics());
            PAINT.setTextSize(textPixelSize);
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawTradeMark(canvas);
        }

        private void drawTradeMark(Canvas canvas) {
            Rect framingRect = getFramingRect();
            float tradeMarkTop;
            float tradeMarkLeft;
            if (framingRect != null) {
                tradeMarkTop = framingRect.bottom + PAINT.getTextSize() + 10;
                tradeMarkLeft = framingRect.left;
            } else {
                tradeMarkTop = 10;
                tradeMarkLeft = canvas.getHeight() - PAINT.getTextSize() - 10;
            }
            canvas.drawText(TRADE_MARK_TEXT, tradeMarkLeft, tradeMarkTop, PAINT);
        }
    }

    private class ProductsAsynTask extends AsyncTask<String, String, String> {
        protected String doInBackground(String... arg0) {
            String jsonData = DummyContent.loadProductJSONFromAsset(getApplicationContext());
            final GsonBuilder builder = new GsonBuilder();
            final Gson gson = builder.create();

            // Parse Object Data
            ResponseResult responseResult = gson.fromJson(jsonData, ResponseResult.class);
            products = responseResult.products;
            return jsonData;
        }
    }

    private Product currentProduct;
    private void setCurrentProduct(Product product){
        currentProduct = product;
    }
    private Product getCurrentProduct(){
        return currentProduct;
    }

    private void scanningProcess(int productId) {
        LOGI(TAG, "scanningProcess");
        Product selectedProduct = null;
        if (products != null && products.size() > 0) {
            for(Product product : products ) {
                if(product.getId() == productId){
                    selectedProduct = product;
                    break;
                }
            }
            if(selectedProduct != null){
                setCurrentProduct(selectedProduct);
                mMaterialDialog.setTitle("Product Detection")
                        .setMessage("Do you want to view product?")
                        .setPositiveButton("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // mMaterialDialog
                                mMaterialDialog.dismiss();

                                LOGE(TAG + "_intent", String.valueOf(getCurrentProduct().getId()));

                                //Create intent
                                Intent intent = new Intent(getApplicationContext(), ProductViewActivity.class);
                                intent.putExtra(ProductViewActivity.PRODUCT_ITEM, getCurrentProduct());
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("CANCEL", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();

                            }
                        });
                mMaterialDialog.show();
            }else {
                mMaterialDialog.setTitle("Product Not Found")
                        .setMessage("Do you want to try again scanning product?")
                        .setPositiveButton("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();

                            }
                        })
                        .setNegativeButton("CANCEL", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();

                            }
                        });
                mMaterialDialog.show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Cannot load product gallery at this time", Toast.LENGTH_SHORT).show();
        }
    }
}