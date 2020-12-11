package android.example.com.pembimbingintern.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Model.Daily;
import android.example.com.pembimbingintern.R;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.MyViewHolder> {

    List<Daily> dailyList;
    Context context;
    TextView pembimbing,kegiatan, catatan,bahasan,belum;
    SharedPreferences sharedPreferences;
    ImageView img;
    Button tutup,simpan;
    String urlImage;
    SignaturePad signaturePad;
    Bitmap bitmap;
    int path;

    public DailyAdapter(List<Daily> dailyList, Context context) {
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
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pembimbing",dailyList.get(position).getPembimbing());
                editor.putString("kegiatan",dailyList.get(position).getKegiatan());
                editor.putString("bahasan",dailyList.get(position).getPokok_bahasan());
                editor.putString("catatan",dailyList.get(position).getCatatan());
                editor.putString("image",dailyList.get(position).getImg());
                editor.putString("stat",dailyList.get(position).getStat());
                editor.apply();
                showDialog();
            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_daily);
        kegiatan=dialog.findViewById(R.id.kegiatan);
        catatan=dialog.findViewById(R.id.catatan);
        TextView txtState=dialog.findViewById(R.id.txtStat);
        bahasan=dialog.findViewById(R.id.bahasan);
        img=dialog.findViewById(R.id.ttd);
        belum=dialog.findViewById(R.id.belum);
        kegiatan.setText(sharedPreferences.getString("kegiatan", "Tidak Ada"));
        bahasan.setText(sharedPreferences.getString("bahasan", "Tidak Ada"));
        catatan.setText(sharedPreferences.getString("catatan", "Belum Ada"));
        txtState.setText(sharedPreferences.getString("stat", "Belum Ada"));
        urlImage=sharedPreferences.getString("image", "Belum Diperiksa");

        if (urlImage.equals("Belum Diperiksa")){

        } else{
            belum.setVisibility(View.INVISIBLE);
            img.setVisibility(View.VISIBLE);
            final String urlGambarBerita = "http://192.168.43.22:81/apimagang/uploads/" +urlImage ;
            Picasso.get().load(urlGambarBerita).into(img);
        }

        tutup=dialog.findViewById(R.id.tutup);
        tutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

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
