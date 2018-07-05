package mrth.legion.joprst.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import mrth.legion.joprst.presenters.ResultPresenter;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ResultView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setResultItemTitle(String name);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setResultItemImage(String pictureURL);

}
