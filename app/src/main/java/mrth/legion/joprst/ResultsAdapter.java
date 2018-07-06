/*
package mrth.legion.joprst;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import mrth.legion.joprst.presenters.ResultsPresenter;
import mrth.legion.joprst.views.ResultView;
import mrth.legion.joprst.views.ResultsView;

public class ResultsAdapter extends MvpBaseAdapter */
/*implements ResultsView *//*
 {

    List<Item> items;

    private int mSelection = -1;

    public ResultsAdapter(MvpDelegate<?> parentDelegate) {
        super(parentDelegate, String.valueOf(0));
        items = new ArrayList<>();
    }

    @Override
    public int getCount() {
        if (items == null)
        {
            return 0;
        }
        return items.size();
    }

    public void setResults(List<Item> itemes) {
        Log.d("Pis", "Items as result setting");
        this.items = new ArrayList<>();
        this.items.addAll(itemes);
        Log.d("Pis", "Items as result setted, notifying data set changed");
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        if (items != null) {
            return items.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
       */
/* if (items != null) {
            if ()
            return Integer.parseInt(items.get(position).getCacheId());
        }*//*

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResultHolder holder;
        if (convertView != null) {
            holder = (ResultHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
            holder = new ResultHolder(convertView);
            convertView.setTag(holder);
        }
        final Item item = (Item) getItem(position);
        holder.bind(position, item);
        return convertView;
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

        @ProvidePresenter
        ResultPresenter provideResultPresenter() {
            System.out.println("result presenter provided");
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
            notifyDataSetChanged();
        }

        void bind(int position, Item item) {
            System.out.print("Start binding");
            if (getMvpDelegate() != null) {
                getMvpDelegate().onSaveInstanceState();
                getMvpDelegate().onDetach();
                getMvpDelegate().onDestroyView();
                mMvpDelegate = null;
            }
            mItem = item;
            System.out.println("creating getMvpDelegate");
            getMvpDelegate().onCreate();
            getMvpDelegate().onAttach();

            view.setBackgroundResource(position == mSelection ? R.color.colorAccent : android.R.color.transparent );
            System.out.print("Finish binding");

        }

        MvpDelegate getMvpDelegate() {
            System.out.println("Start getMvpDelegate");
            if (mItem == null) {
                return null;
            }
            if (mMvpDelegate == null) {
                mMvpDelegate = new MvpDelegate<>(this);
                mMvpDelegate.setParentDelegate(ResultsAdapter.this.getMvpDelegate(), mItem.getCacheId());
            }
            System.out.println("Finish getMvpDelegate");
            return  mMvpDelegate;
        }
    }
}
*/
