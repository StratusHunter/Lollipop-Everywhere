package com.stratushunter.lollipopeverywhere.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.stratushunter.lollipopeverywhere.R;
import com.stratushunter.lollipopeverywhere.adapters.RecyclerAdapter;
import com.stratushunter.lollipopeverywhere.classes.ViewModel;
import com.stratushunter.lollipopeverywhere.interfaces.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends ToolbarActivity {

    private static final String MOCK_URL = "http://lorempixel.com/800/400/cats/";

    private GridLayoutManager mGridLayoutManager;
    private int mGridSpan = 1;

    @Override
    protected void initialiseView() {

        super.initialiseView();

        mGridLayoutManager = new GridLayoutManager(this, mGridSpan);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true); //To optimize the list if it has fixed size cells
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(createList(), new OnRecyclerViewItemClickListener<ViewModel>() {

            @Override
            public void onItemClick(View view, ViewModel viewModel) {

                ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                DetailActivity.startActivity(RecyclerActivity.this, viewModel, imageView);
            }
        }));
    }

    private List<ViewModel> createList() {

        List<ViewModel> items = new ArrayList<ViewModel>();

        for (int i = 0; i < 20; i++) {

            String url = MOCK_URL + ((i % 10) + 1);
            items.add(new ViewModel("Item " + (i + 1), url));
        }

        return items;
    }

    @Override
    public int getLayoutRes() {

        return R.layout.activity_recycler;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.recycler, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_toggle_grid) {

            mGridSpan = (mGridLayoutManager.getSpanCount() % 2 == 0) ? 1 : 2;
            mGridLayoutManager.setSpanCount(mGridSpan);
            mGridLayoutManager.requestLayout();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
