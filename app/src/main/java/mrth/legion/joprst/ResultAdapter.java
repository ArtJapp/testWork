package mrth.legion.joprst;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.presenters.ResultPresenter;
import mrth.legion.joprst.views.ResultView;

public class ResultAdapter extends MvpBaseAdapter {
//    @InjectPresenter(type = PresenterType.WEAK, tag=ResultPresenter.TAG)
    ResultPresenter presenter;

    List<Item> items;

    private int mSelection = -1;

    @NonNull
    @ProvidePresenter
    protected ResultPresenter createPresenter(@NonNull Item model) {
        presenter = new ResultPresenter(model);
        return presenter;
    }

    public ResultAdapter(MvpDelegate<?> parentDelegate) {
        super(parentDelegate, String.valueOf(0));
        items = new ArrayList<>();
    }

    @Override
    public int getCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    private void dataSetChanged() {
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int i) {
        if (items != null) {
            return items.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        if (items == null) {
            return 0;
        } else {
            return Integer.parseInt(((Item) getItem(i)).getCacheId());
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ResultHolder resultViewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview, viewGroup, false);
            resultViewHolder = new ResultHolder(view);
            view.setTag(resultViewHolder);
        } else {
            resultViewHolder = (ResultHolder) view.getTag();
        }
        return view;
    }

    public void setSelection(int selection) {
        mSelection = selection;

        notifyDataSetChanged();
    }

    public class ResultHolder implements ResultView {

        @InjectPresenter
        ResultPresenter mResultPresenter;

        private Item mItem;

        View view;

        @BindView(R.id.textResult)
        TextView resultText;
        @BindView(R.id.imageResult)
        ImageView resultImage;

        private MvpDelegate mMvpDelegate;

        ResultPresenter provideResultPresenter() {
            return new ResultPresenter(mItem);
        }

        ResultHolder(View view) {
            this.view = view;

            ButterKnife.bind(this, view);
        }


        @Override
        public void setResultItemTitle(String name) {
            this.resultText.setText(name);
        }

        @Override
        public void setResultItemImage(String pictureURL) {
            App.getPicasso().load(pictureURL).into(resultImage);
        }

        void bind(int position, Item item) {
            if (getMvpDelegate() != null) {
                getMvpDelegate().onSaveInstanceState();
                getMvpDelegate().onDetach();
                getMvpDelegate().onDestroyView();
                mMvpDelegate = null;
            }
            mItem = item;

            getMvpDelegate().onCreate();
            getMvpDelegate().onAttach();

            view.setBackgroundResource(position == mSelection ? R.color.colorAccent : android.R.color.transparent );


        }

        MvpDelegate getmMvpDelegate() {
            if (mItem == null) {
                return null;
            } else {
                mMvpDelegate = new MvpDelegate<>(this);
                mMvpDelegate.setParentDelegate(ResultAdapter.this.getMvpDelegate(), mItem.getCacheId());
            }
            return  mMvpDelegate;
        }
    }
}
