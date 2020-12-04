package android.example.com.pembimbingintern.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Activity.DetailMahasiswaActivity;
import android.example.com.pembimbingintern.Model.Pengajuan;
import android.example.com.pembimbingintern.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class PengajuanAdapter extends RecyclerView.Adapter<PengajuanAdapter.MyViewHolder> {

    ArrayList<Pengajuan> pengajuanList;
    Context context;
    TextView pembimbing, kegiatan, catatan, bahasan, belum;
    SharedPreferences sharedPreferences;
    ImageView img;
    Button tutup;
    String urlImage;

    public PengajuanAdapter(ArrayList<Pengajuan> pengajuanList, Context context) {
        this.pengajuanList = pengajuanList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        sharedPreferences = context.getSharedPreferences("remember", Context.MODE_PRIVATE);
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pengajuan, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.txt_judul.setText(pengajuanList.get(position).getNama_mahasiswa());
        holder.txt_keterangan.setText(pengajuanList.get(position).getJurusan());
        final String urlGambarBerita = "http://192.168.43.22:81/apimagang/uploads/" + pengajuanList.get(position).getFoto_mahasiswa();
        Picasso.get().load(urlGambarBerita).into(holder.img);
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), DetailMahasiswaActivity.class);
                mIntent.putExtra("nama", pengajuanList.get(position).getNama_mahasiswa());
                mIntent.putExtra("jurusan", pengajuanList.get(position).getJurusan());
                mIntent.putExtra("kampus", pengajuanList.get(position).getAsal_kampus());
                mIntent.putExtra("file", pengajuanList.get(position).getFile());
                mIntent.putExtra("status", pengajuanList.get(position).getStatus());
                mIntent.putExtra("foto", pengajuanList.get(position).getFoto_mahasiswa());
                mIntent.putExtra("nim", pengajuanList.get(position).getNIM());
                v.getContext().startActivity(mIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return (pengajuanList == null) ? 0 : pengajuanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_judul, txt_keterangan;
        public CircleImageView img;
        public Button detail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_judul = itemView.findViewById(R.id.txt_judul);
            txt_keterangan = itemView.findViewById(R.id.txt_keterangan);
            img = itemView.findViewById(R.id.img);
            detail = itemView.findViewById(R.id.detail);
        }
    }


}
