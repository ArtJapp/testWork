
package mrth.legion.joprst;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Label {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("label_with_op")
    @Expose
    private String labelWithOp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLabelWithOp() {
        return labelWithOp;
    }

    public void setLabelWithOp(String labelWithOp) {
        this.labelWithOp = labelWithOp;
    }

}
