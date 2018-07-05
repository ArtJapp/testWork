package mrth.legion.joprst.views;

import java.util.List;

import mrth.legion.joprst.models.Item;
public interface MainView {
    void showResults(List<Item> results);
    void showEmpty();
}
