
package mrth.legion.joprst.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Key_ {

    @SerializedName("(key)")
    @Expose
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
