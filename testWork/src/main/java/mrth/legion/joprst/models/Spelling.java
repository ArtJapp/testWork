
package mrth.legion.joprst;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spelling {

    @SerializedName("correctedQuery")
    @Expose
    private String correctedQuery;
    @SerializedName("htmlCorrectedQuery")
    @Expose
    private String htmlCorrectedQuery;

    public String getCorrectedQuery() {
        return correctedQuery;
    }

    public void setCorrectedQuery(String correctedQuery) {
        this.correctedQuery = correctedQuery;
    }

    public String getHtmlCorrectedQuery() {
        return htmlCorrectedQuery;
    }

    public void setHtmlCorrectedQuery(String htmlCorrectedQuery) {
        this.htmlCorrectedQuery = htmlCorrectedQuery;
    }

}
