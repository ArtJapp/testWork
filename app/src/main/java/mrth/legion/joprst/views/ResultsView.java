package mrth.legion.joprst.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import mrth.legion.joprst.models.Item;

public interface ResultsView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showItems(List<Item> results);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showEmpty();

    @StateStrategyType(AddToEndStrategy.class)
    void addItems(List<Item> items);

    void onStartLoading();
    void onFinishLoading();
}
