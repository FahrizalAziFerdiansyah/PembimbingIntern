package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPendamping {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Pendamping> pendampingList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pendamping> getPendampingList() {
        return pendampingList;
    }

    public void setPendampingList(List<Pendamping> pendampingList) {
        this.pendampingList = pendampingList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
