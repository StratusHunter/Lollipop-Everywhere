package com.stratushunter.lollipopeverywhere.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.stratushunter.lollipopeverywhere.R;

/**
 * Created by Terence Baker on 23/10/14.
 */
public abstract class ToolbarActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    public abstract int getLayoutRes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initialiseView();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        initialiseView();
    }

    protected void initialiseView() {

        setContentView(getLayoutRes());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {

            setSupportActionBar(mToolbar);
        }
    }

    protected Toolbar getToolbar() {

        return mToolbar;
    }
}
