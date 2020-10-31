package android.example.com.pembimbingintern.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Adapter.MhsAdapter;
import android.example.com.pembimbingintern.Model.GetPengajuan;
import android.example.com.pembimbingintern.Model.Pengajuan;
import android.example.com.pembimbingintern.R;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePendampingActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String id_pendamping;
    CardView lihat;
    TextView id, nama, no_hp;
    ApiInterface mApiInterface;
    ImageView imgPengajuan;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pendamping);

//        nama=findViewById(R.id.nama);
//        no_hp=findViewById(R.id.no_hp);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_mhs);
        mLayoutManager = new LinearLayoutManager(this);
        imgPengajuan=findViewById(R.id.imgPengajuan);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        sharedPreferences = HomePendampingActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        id_pendamping= sharedPreferences.getString("id_pendamping","0");
        editor = sharedPreferences.edit();


        imgPengajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PengajuanMahasiswaActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Refresh();

    }

    private void Refresh() {
        Call<GetPengajuan> getPengajuanCall=mApiInterface.postMhs(id_pendamping);
        getPengajuanCall.enqueue(new Callback<GetPengajuan>() {
            @Override
            public void onResponse(Call<GetPengajuan> call, Response<GetPengajuan> response) {
                List<Pengajuan> pengajuanList=response.body().getPengajuanList();
                mAdapter=new MhsAdapter(pengajuanList,getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPengajuan> call, Throwable t) {

            }
        });

    }
}
