package android.example.com.pembimbingintern.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Activity.DetailPendampingActivity;
import android.example.com.pembimbingintern.Model.Daily;
import android.example.com.pembimbingintern.R;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyPendampingAdapter extends RecyclerView.Adapter<DailyPendampingAdapter.MyViewHolder> {

    List<Daily> dailyList;
    Context context;
    TextView pembimbing,kegiatan, catatan,bahasan,belum,txtBuat,txtUpload;
    SharedPreferences sharedPreferences;
    ImageView img;
    Button tutup,simpan,btnSave,btnClear,btnPilih;
    LinearLayout lineTtd,lineUpload;
    String urlImage;
    SignaturePad signaturePad;
    Bitmap bitmap;
    int path;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};


    public DailyPendampingAdapter(List<Daily> dailyList, Context context) {
        this.dailyList = dailyList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        sharedPreferences = context.getSharedPreferences("remember", Context.MODE_PRIVATE);
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mPokokBahasan.setText(dailyList.get(position).getPokok_bahasan());
        holder.mPendamping.setText(dailyList.get(position).getPembimbing());
        holder.mTanggal.setText(dailyList.get(position).getTgl_daily());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), DetailPendampingActivity.class);
                mIntent.putExtra("id_daily",dailyList.get(position).getId_daily());
                mIntent.putExtra("pembimbing",dailyList.get(position).getPembimbing());
                mIntent.putExtra("kegiatan",dailyList.get(position).getKegiatan());
                mIntent.putExtra("bahasan",dailyList.get(position).getPokok_bahasan());
                mIntent.putExtra("status",dailyList.get(position).getStat());
                mIntent.putExtra("image",dailyList.get(position).getImg());
                v.getContext().startActivity(mIntent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return (dailyList == null) ? 0 : dailyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  mPokokBahasan, mPendamping,mTanggal,mImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mPokokBahasan=itemView.findViewById(R.id.txt_bahasan);
            mTanggal=itemView.findViewById(R.id.txt_tanggal);
            mPendamping=itemView.findViewById(R.id.pendamping);
        }
    }



}
