package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAkun {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Akun> listDataAkun;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Akun> getListDataAkun() {
        return listDataAkun;
    }

    public void setListDataAkun(List<Akun> listDataAkun) {
        this.listDataAkun = listDataAkun;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
