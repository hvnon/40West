package com.as.fortywest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.as.fortywest.fragment.OfflineCatalogFragment;
import com.as.fortywest.model.OfflineCatalogModal;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import static com.as.fortywest.util.LogUtils.LOGD;
import static com.as.fortywest.util.LogUtils.LOGE;
import static com.as.fortywest.util.LogUtils.LOGI;
import static com.as.fortywest.util.LogUtils.LOGW;
import static com.as.fortywest.util.LogUtils.makeLogTag;

public class PDFViewActivity extends AppCompatActivity {
    private static final String TAG = makeLogTag(PDFViewActivity.class);
    private PDFView pdfView;
    private Integer pageNumber = 1;
    private String pdfName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data = getIntent().getExtras();

        if(data != null){
            OfflineCatalogModal catalog = data.getParcelable(OfflineCatalogFragment.TAG_OFFLINE_CATALOG_OBJECT_PARCELABLE);
            pdfName = catalog.getmAssetName();

            pdfView = (PDFView) findViewById(R.id.pdfview);
            OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
                @Override
                public void onPageChanged(int page, int pageCount) {
                    pageNumber = page;
                    setTitle(String.format("%s %s / %s", pdfName, page, pageCount));
                }
            };

            pdfView.fromAsset(pdfName)
                    .defaultPage(pageNumber)
                    .onPageChange(onPageChangeListener)
                    .load();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
