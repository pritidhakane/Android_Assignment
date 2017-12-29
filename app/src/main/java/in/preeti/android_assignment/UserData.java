package in.preeti.android_assignment;

import java.io.Serializable;

/**
 * Created by preeti on 29/12/17.
 */

public class UserData implements Serializable {

    private String muserid,muserpassword;

    public UserData(String muserid, String muserpassword) {
        this.muserid = muserid;
        this.muserpassword = muserpassword;
    }

    public String getMuserid() {
        return muserid;
    }

    public void setMuserid(String muserid) {
        this.muserid = muserid;
    }

    public String getMuserpassword() {
        return muserpassword;
    }

    public void setMuserpassword(String muserpassword) {
        this.muserpassword = muserpassword;
    }
}
