package mrth.legion.joprst;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import mrth.legion.joprst.presenters.SearchPresenter;
import mrth.legion.joprst.views.ResultViewHolder;

public class ResultAdapter extends MvpRecyclerListAdapter<mrth.legion.joprst.Item, SearchPresenter, ResultViewHolder> {

    @NonNull
    @Override
    protected SearchPresenter createPresenter(@NonNull mrth.legion.joprst.Item model) {
        SearchPresenter presenter = new SearchPresenter();
        presenter.setModel(model);
        return presenter;
    }

    @NonNull
    @Override
    protected Object getModelId(@NonNull mrth.legion.joprst.Item model) {
        return model.getTitle();
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResultViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false));
    }
}
