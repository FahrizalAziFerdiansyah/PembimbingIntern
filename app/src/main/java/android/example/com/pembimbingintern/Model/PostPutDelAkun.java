package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelAkun {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Akun mAkun;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Akun getmAkun() {
        return mAkun;
    }

    public void setmAkun(Akun mAkun) {
        this.mAkun = mAkun;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
