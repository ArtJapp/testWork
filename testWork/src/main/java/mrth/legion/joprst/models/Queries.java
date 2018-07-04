
package mrth.legion.joprst;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Queries {

    @SerializedName("(key)")
    @Expose
    private List<Key> key = null;

    public List<Key> getKey() {
        return key;
    }

    public void setKey(List<Key> key) {
        this.key = key;
    }

}
