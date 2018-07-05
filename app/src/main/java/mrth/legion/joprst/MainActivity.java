package mrth.legion.joprst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.joprst.models.Item;
import mrth.legion.joprst.presenters.MainPresenter;
import mrth.legion.joprst.views.MainView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private ResultAdapter adapter;
    private MainPresenter presenter;

    @BindView(R.id.btnSearch) Button btnSubmit;
    @BindView(R.id.etSearchField) EditText etSearchField;
    @BindView(R.id.rvSearchResults) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            presenter = new MainPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        adapter = new ResultAdapter();
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnSubmit.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnSearch) {
            etSearchField.clearFocus();
            presenter.bindView(this, etSearchField.getText().toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bindView(this, "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @Override
    public void showResults(List<Item> results) {
        adapter.clearAndAddAll(results);
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "Nothing found", Toast.LENGTH_SHORT).show();
    }
}
