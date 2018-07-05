package mrth.legion.joprst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.views.FrameMyLayout;
import mrth.legion.joprst.views.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView, View.OnClickListener {

    private ResultAdapter adapter;
   // @InjectPresenter
   // MainPresenter presenter;

    @BindView(R.id.btnSearch) Button btnSubmit;
    @BindView(R.id.etSearchField) EditText etSearchField;
    @BindView(R.id.activity_home_layout)
    FrameMyLayout frameMyLayout;
    @BindView(R.id.activity_home_list_view_repositories)
    ListView mRepositoriesListView;
    @BindView(R.id.activity_home_text_view_no_repositories)
    TextView mNoRepositoriesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
    //        presenter = new MainPresenter();
        } else {
   //        presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        adapter = new ResultAdapter(getMvpDelegate());
        frameMyLayout.setListViewChild(mRepositoriesListView);
      //  frameMyLayout.setOnRefreshListener(() -> presenter.);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
  //      recyclerView.setLayoutManager(layoutManager);

        btnSubmit.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnSearch) {
   //         presenter.bindView(this, etSearchField.getText().toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
  //      presenter.bindView(this, "");
    }

    @Override
    protected void onPause() {
        super.onPause();
 //       presenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
   //     PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @StateStrategyType(AddToEndSingleStrategy.class)

    public void showResults(List<Item> results) {
 //       adapter.clearAndAddAll(results);
    }

    @Override
    public void showItems(List<Item> results) {

    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "Nothing found", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addItems(List<Item> items) {

    }

    @Override
    public void onStartLoading() {

    }

    @Override
    public void onFinishLoading() {

    }
}
