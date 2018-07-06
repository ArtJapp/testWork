package mrth.legion.joprst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.presenters.ResultsPresenter;
import mrth.legion.joprst.views.ResultsView;

public class MainActivity extends MvpAppCompatActivity implements ResultsView {

   // private ResultsAdapter adapter;
    private ResViewAdapter adaptered;
    @InjectPresenter
    ResultsPresenter presenter;

    @BindView(R.id.btnSearch) Button btnSubmit;
    @BindView(R.id.etSearchField) EditText etSearchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adaptered = new ResViewAdapter(getApplicationContext());
        adaptered = new ResViewAdapter(getApplicationContext());

        RecyclerView v = findViewById(R.id.resultList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        v.setAdapter(adaptered);
        v.setLayoutManager(layoutManager);
        btnSubmit.setOnClickListener(v1 -> presenter.loadResults(etSearchField.getText().toString()));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showItems(List<Item> results) {

        adaptered.setResults(results);
        adaptered.notifyDataSetChanged();
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "Nothing found", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addItems(List<Item> items) {
        adaptered.setResults(items);
    }

    @Override
    public void onStartLoading() {

    }

    @Override
    public void onFinishLoading() {

    }
}
