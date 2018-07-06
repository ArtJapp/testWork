package mrth.legion.joprst.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.App;
import mrth.legion.joprst.R;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.presenters.ResultPresenter;

public class DetailsFragment extends MvpAppCompatFragment implements ResultView {
    public static final String ARGS_RESULT = "argsResult";
    @InjectPresenter
    ResultPresenter resultPresenter;

    private Item item;

    @BindView(R.id.textResult)
    TextView textView;

    /*@BindView(R.id.imageResult)
    ImageView imageView;*/

    @ProvidePresenter
    ResultPresenter provideResultPresenter() {
        item = (Item) getArguments().get(ARGS_RESULT);
        System.out.println("Provide ResultPresenter");
        return new ResultPresenter(item);
    }

    @Override
    public void setResultItemTitle(String name) {
        Log.d("Not missed text", "Hello " + name);
        textView.setText(name);
    }

    @Override
    public void setResultItemImage(String pictureURL) {
 //       App.getPicasso().load(pictureURL).into(imageView);
        Log.d("Missed picture", "Hello, " + pictureURL);
    }


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.itemview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

}
