package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDaily {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Daily> dailyList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Daily> getDailyList() {
        return dailyList;
    }

    public void setDailyList(List<Daily> dailyList) {
        this.dailyList = dailyList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
