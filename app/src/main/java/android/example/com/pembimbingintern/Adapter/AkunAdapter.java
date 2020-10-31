package android.example.com.pembimbingintern.Adapter;


import android.example.com.pembimbingintern.Model.Akun;
import android.example.com.pembimbingintern.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AkunAdapter extends RecyclerView.Adapter<AkunAdapter.MyViewHolder> {

    List<Akun> mAkunList;

    public AkunAdapter(List<Akun> mAkunList) {
        this.mAkunList = mAkunList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_akun, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextViewUsername.setText(mAkunList.get(position).getUsername());
        holder.mTextViewPassword.setText(mAkunList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return mAkunList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  mTextViewUsername, mTextViewPassword;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewUsername=itemView.findViewById(R.id.username);
            mTextViewPassword=itemView.findViewById(R.id.password);
        }
    }
}
