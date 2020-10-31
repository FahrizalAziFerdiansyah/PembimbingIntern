package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetPengajuan {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Pengajuan> pengajuanList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Pengajuan> getPengajuanList() {
        return pengajuanList;
    }

    public void setPengajuanList(ArrayList<Pengajuan> pengajuanList) {
        this.pengajuanList = pengajuanList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
