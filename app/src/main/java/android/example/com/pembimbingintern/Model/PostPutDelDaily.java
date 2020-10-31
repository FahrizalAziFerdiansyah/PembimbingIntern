package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelDaily {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pengajuan mPengajuan;
    @SerializedName("message")
    String message;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pengajuan getmPengajuan() {
        return mPengajuan;
    }

    public void setmPengajuan(Pengajuan mPengajuan) {
        this.mPengajuan = mPengajuan;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
