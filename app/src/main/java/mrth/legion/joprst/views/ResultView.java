package mrth.legion.joprst.views;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ResultView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setResultItemTitle(String name);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setResultItemImage(String pictureURL);

}
