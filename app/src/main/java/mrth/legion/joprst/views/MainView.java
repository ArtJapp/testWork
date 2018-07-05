package mrth.legion.joprst.views;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import mrth.legion.joprst.models.Item;

public interface MainView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showResults(List<Item> results);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showEmpty();
}
