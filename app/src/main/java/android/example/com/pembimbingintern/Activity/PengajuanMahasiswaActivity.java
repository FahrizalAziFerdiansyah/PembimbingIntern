package android.example.com.pembimbingintern.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Adapter.PengajuanAdapter;
import android.example.com.pembimbingintern.Model.GetPengajuan;
import android.example.com.pembimbingintern.Model.Pengajuan;
import android.example.com.pembimbingintern.R;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengajuanMahasiswaActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String id_pendamping;
    LinearLayout lineKosong;
    ArrayList<Pengajuan> pengajuanList = null;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajuan_mahasiswa);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pengajuan PKL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PengajuanMahasiswaActivity.this, HomePendampingActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        sharedPreferences = PengajuanMahasiswaActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        id_pendamping= sharedPreferences.getString("id_pendamping", "fail");
        mRecyclerView = (RecyclerView) findViewById(R.id.list_mhs);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        lineKosong=findViewById(R.id.lineKosong);
        Refresh();

    }

    private void Refresh() {
        Call<GetPengajuan> getPengajuanCall=mApiInterface.postPendamping(id_pendamping);
        getPengajuanCall.enqueue(new Callback<GetPengajuan>() {
            @Override
            public void onResponse(Call<GetPengajuan> call, Response<GetPengajuan> response) {
                pengajuanList= response.body().getPengajuanList();
                Log.d("Retrofit Get", "Jumlah data Item: " + pengajuanList.size());
                if (pengajuanList.size()==0){
                    lineKosong.setVisibility(View.VISIBLE);
                    mRecyclerView.setVisibility(View.GONE);
                } else {
                    lineKosong.setVisibility(View.GONE);
                }
                mAdapter=new PengajuanAdapter(pengajuanList,getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPengajuan> call, Throwable t) {

            }
        });

    }
}
