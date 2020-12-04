package android.example.com.pembimbingintern.Activity;

import android.content.Intent;
import android.example.com.pembimbingintern.R;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;


public class BacaActivity extends AppCompatActivity implements DownloadFile.Listener {
    RemotePDFViewPager remotePDFViewPager;
    TextView file;
    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        mIntent = getIntent();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Proposal PKL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(v.getContext(), DetailMahasiswaActivity.class);
                a.putExtra("file",mIntent.getStringExtra("file") );
                a.putExtra("nama", mIntent.getStringExtra("nama") );
                a.putExtra("jurusan", mIntent.getStringExtra("jurusan") );
                a.putExtra("kampus", mIntent.getStringExtra("kampus") );
                a.putExtra("status", mIntent.getStringExtra("status") );
                a.putExtra("foto", mIntent.getStringExtra("foto") );
                a.putExtra("nim", mIntent.getStringExtra("nim") );
                v.getContext().startActivity(a);

            }
        });
        Intent mIntent = getIntent();
       remotePDFViewPager =new RemotePDFViewPager(BacaActivity.this, "http://192.168.43.22:81/apimagang/uploads/"+mIntent.getStringExtra("file"), this);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        PDFPagerAdapter adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(remotePDFViewPager, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }
}
