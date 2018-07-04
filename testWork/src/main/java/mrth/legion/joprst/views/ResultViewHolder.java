package mrth.legion.joprst.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mrth.legion.joprst.Image;
import mrth.legion.joprst.Item;
import mrth.legion.joprst.R;
import mrth.legion.joprst.presenters.SearchPresenter;

public class ResultViewHolder extends MvpViewHolder<SearchPresenter> {

    private final TextView resultText;
  //  private final ImageView resultImage;
    public ResultViewHolder(View itemView) {
        super(itemView);
        resultText = itemView.findViewById(R.id.textResult);
       // resultImage = itemView.findViewById(R.id.imageResult);

    }
    public void setResultItems(Item item) {
        this.resultText.setText(item.getTitle());
    }
}
