package mrth.legion.joprst;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.models.Image;
import mrth.legion.joprst.models.Item;

public class ResViewAdapter extends RecyclerView.Adapter<ResViewAdapter.ResViewHolder> {
    private List<Item> mItems;
    private Context context;

    public ResViewAdapter(Context context) {
        this.context = context;
        mItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        ResViewHolder viewHolder = new ResViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewHolder holder, int position) {
        holder.bindResult(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setResults(List<Item> itemes) {
        Log.d("Pis", "Items as result setting");
        this.mItems = new ArrayList<>();
        this.mItems.addAll(itemes);
        Log.d("Pis", "Items as result setted, notifying data set changed");
        notifyDataSetChanged();
    }

    public class ResViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textResult)
        TextView text;
        @BindView(R.id.imageResult)
        ImageView imageView;

        @BindView(R.id.pictureLinLay)
        LinearLayout linearLayout;

        private android.content.Context context;
        public ResViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        public void bindResult(Item item) {
            text.setText(item.getTitle());
            App.getPicasso().load(item.getLink()).into(imageView);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

            System.out.println("The width is " + linearLayout.getLayoutParams().width);
            System.out.println("The new height is " + (Integer.parseInt(item.getImage().getThumbnailHeight()) * 1.0 * linearLayout.getLayoutParams().width) / Integer.parseInt(item.getImage().getThumbnailWidth()));
            itemView.getLayoutParams().height = Integer.parseInt(item.getImage().getThumbnailHeight()) * linearLayout.getLayoutParams().width / Integer.parseInt(item.getImage().getThumbnailWidth());
    }
    }
}
