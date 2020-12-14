package android.example.com.pembimbingintern.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.example.com.pembimbingintern.Adapter.DailyPendampingAdapter;
import android.example.com.pembimbingintern.Model.Daily;
import android.example.com.pembimbingintern.Model.GetDaily;
import android.example.com.pembimbingintern.Model.PostPutDelPengajuan;
import android.example.com.pembimbingintern.R;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity<ApiInterface> extends AppCompatActivity {
    CircleImageView img;
    TextView namaMhs,jurusanMhs,kampusMhs,ipkMhs,fileMhs,status;
    Button btnstatus,btnSimpan;
    Spinner spnStatus;
    String nim;
    LayoutInflater inflater;
    ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);


        Toolbar toolbar = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail Mahasiswa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailMahasiswaActivity.this, HomePendampingActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        img=findViewById(R.id.img);
        namaMhs=findViewById(R.id.namaMhs);
        jurusanMhs=findViewById(R.id.jurusanMhs);
        kampusMhs=findViewById(R.id.kampusMhs);
        ipkMhs=findViewById(R.id.ipkMhs);
        fileMhs=findViewById(R.id.file);
        status=findViewById(R.id.status);
        btnstatus=findViewById(R.id.btnStatus);
        mRecyclerView = (RecyclerView) findViewById(R.id.dailyMhs);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mIntent = getIntent();
        namaMhs.setText(mIntent.getStringExtra("nama"));
        jurusanMhs.setText(mIntent.getStringExtra("jurusan"));
        kampusMhs.setText(mIntent.getStringExtra("kampus"));
        ipkMhs.setText(mIntent.getStringExtra("ipk"));
        fileMhs.setText(mIntent.getStringExtra("file"));
        status.setText(mIntent.getStringExtra("status"));
        nim=mIntent.getStringExtra("nim");
        final String urlGambarBerita = "http://192.168.43.224/apimagang/uploads/" + mIntent.getStringExtra("foto");
        Picasso.get().load(urlGambarBerita).into(img);
        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        fileMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(v.getContext(), BacaActivity.class);
                a.putExtra("file",mIntent.getStringExtra("file") );
                a.putExtra("nama", mIntent.getStringExtra("nama") );
                a.putExtra("jurusan", mIntent.getStringExtra("jurusan") );
                a.putExtra("kampus", mIntent.getStringExtra("kampus") );
                a.putExtra("status", mIntent.getStringExtra("status") );
                a.putExtra("ipk", mIntent.getStringExtra("ipk"));
                a.putExtra("foto", mIntent.getStringExtra("foto") );
                a.putExtra("nim", mIntent.getStringExtra("nim") );
                v.getContext().startActivity(a);
            }
        });

        dailyMhs();
    }

    private void dailyMhs() {
        Call<GetDaily> dailyCall = mApiInterface.postDaily(nim);
        dailyCall.enqueue(new Callback<GetDaily>() {
            @Override
            public void onResponse(Call<GetDaily> call, Response<GetDaily>
                    response) {
                List<Daily> dailyList = response.body().getDailyList();
//                Log.d("Retrofit Get", "Jumlah data Kontak: " +
//                        String.valueOf(dailyList.size()));
                mAdapter = new DailyPendampingAdapter(dailyList, DetailMahasiswaActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDaily> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(DetailMahasiswaActivity.this);
        dialog.setContentView(R.layout.dialog_status);
        spnStatus=dialog.findViewById(R.id.spnStatus);
        btnSimpan=dialog.findViewById(R.id.simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<PostPutDelPengajuan> pengajuanCall=mApiInterface.putPengajuan(spnStatus.getSelectedItem().toString(),nim);
                pengajuanCall.enqueue(new Callback<PostPutDelPengajuan>() {
                    @Override
                    public void onResponse(Call<PostPutDelPengajuan> call, Response<PostPutDelPengajuan> response) {
                        Toast.makeText(DetailMahasiswaActivity.this,"Status mahasiswa berhasil dirubah",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(dialog.getContext(),HomePendampingActivity.class);
                        DetailMahasiswaActivity.this.startActivity(intent);
                        dialog.dismiss();

                    }

                    @Override
                    public void onFailure(Call<PostPutDelPengajuan> call, Throwable t) {
                        Toast.makeText(DetailMahasiswaActivity.this,"Status mahasiswa berhasil dirubah",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(dialog.getContext(),HomePendampingActivity.class);
                        DetailMahasiswaActivity.this.startActivity(intent);
                        dialog.dismiss();
                    }
                });
            }
        });

        dialog.show();



    }

    private static class ApiClient {
    }

    private class GetDaily {
    }
}
