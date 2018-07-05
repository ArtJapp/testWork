
package mrth.legion.joprst.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("url")
    @Expose
    private Url url;
    @SerializedName("queries")
    @Expose
    private Queries queries;
    @SerializedName("promotions")
    @Expose
    private List<Promotion> promotions = null;
    @SerializedName("context")
    @Expose
    private Context context;
    @SerializedName("searchInformation")
    @Expose
    private SearchInformation searchInformation;
    @SerializedName("spelling")
    @Expose
    private Spelling spelling;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Queries getQueries() {
        return queries;
    }

    public void setQueries(Queries queries) {
        this.queries = queries;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SearchInformation getSearchInformation() {
        return searchInformation;
    }

    public void setSearchInformation(SearchInformation searchInformation) {
        this.searchInformation = searchInformation;
    }

    public Spelling getSpelling() {
        return spelling;
    }

    public void setSpelling(Spelling spelling) {
        this.spelling = spelling;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
