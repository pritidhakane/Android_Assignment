package in.preeti.android_assignment;

import java.io.Serializable;

/**
 * Created by preeti on 29/12/17.
 */

public class JsonData implements Serializable {

    private String mid,mname,mphonenumber,msubject;

    public JsonData() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphonenumber() {
        return mphonenumber;
    }

    public void setMphonenumber(String mphonenumber) {
        this.mphonenumber = mphonenumber;
    }

    public String getMsubject() {
        return msubject;
    }

    public void setMsubject(String msubject) {
        this.msubject = msubject;
    }
}
