
package mrth.legion.joprst;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagemap {

    @SerializedName("(key)")
    @Expose
    private List<Key_> key = null;

    public List<Key_> getKey() {
        return key;
    }

    public void setKey(List<Key_> key) {
        this.key = key;
    }

}
