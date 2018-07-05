package mrth.legion.joprst.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import mrth.legion.joprst.presenters.BasePresenter;

public abstract class MvpViewHolder<P extends BasePresenter> extends RecyclerView.ViewHolder {
    public P presenter;

    public MvpViewHolder(View itemView) {
        super(itemView);
    }
    public void bindPresenter(P presenter) {
        this.presenter = presenter;
        presenter.bindView(this);
    }

    public void unbindPresenter() {
        presenter = null;
    }
}