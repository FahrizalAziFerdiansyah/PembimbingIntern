package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelMhs {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Mahasiswa mMahasiswa;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mahasiswa getmMahasiswa() {
        return mMahasiswa;
    }

    public void setmMahasiswa(Mahasiswa mMahasiswa) {
        this.mMahasiswa = mMahasiswa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
