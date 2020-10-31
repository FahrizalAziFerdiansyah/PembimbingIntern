package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelPendamping {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pendamping mPendamping;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pendamping getmPendamping() {
        return mPendamping;
    }

    public void setmPendamping(Pendamping mPendamping) {
        this.mPendamping = mPendamping;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
