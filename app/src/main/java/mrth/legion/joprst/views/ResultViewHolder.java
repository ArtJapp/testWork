package mrth.legion.joprst.views;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.App;
import mrth.legion.joprst.R;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.presenters.SearchPresenter;

public class ResultViewHolder extends MvpViewHolder<SearchPresenter> implements ResultView {
    @BindView(R.id.textResult) TextView resultText;
    @BindView(R.id.imageResult) ImageView resultImage;
    public ResultViewHolder(View itemView) {
        super(itemView);
        Log.d("Loggy", "Start creating viewholder");
        ButterKnife.bind(itemView);
        resultText = itemView.findViewById(R.id.textResult);
        Log.d("Loggy", "Finish creating viewholder");
        resultImage = itemView.findViewById(R.id.imageResult);

    }
    public void setResultItems(Item item) {
        ButterKnife.bind(itemView);
        Log.d("Loggy", "Start setting result items");
            if (item != null) {
                resultText.setText(item.getTitle());
            } else {
                Log.d("Result View holder says", "empty item");
            }



        Log.d("Loggy", "Finish setting result items");
    }

    @Override
    public void setResultItemTitle(String name) {
        ButterKnife.bind(itemView);

        resultText.setText(name);
    }

    @Override
    public void setResultItemImage(String pictureUrl, String width, String height) {
        ButterKnife.bind(itemView);
        App.getPicasso().load(pictureUrl).into(resultImage);
    }
}
