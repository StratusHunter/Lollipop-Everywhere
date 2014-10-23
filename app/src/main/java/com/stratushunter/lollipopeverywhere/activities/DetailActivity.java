package com.stratushunter.lollipopeverywhere.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stratushunter.lollipopeverywhere.R;
import com.stratushunter.lollipopeverywhere.classes.ViewModel;

/**
 * Created by Terence Baker on 23/10/14.
 */
public class DetailActivity extends ToolbarActivity {

    public static String TRANSITION_VIEW = "transition_view";
    private static String EXTRA_VIEW_MODEL = "view_model";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ViewModel model = getIntent().getParcelableExtra(EXTRA_VIEW_MODEL);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent_black)));
        getSupportActionBar().setTitle(model.getText());

        getToolbar().setAlpha(0);
        getToolbar().animate().alpha(1).setDuration(1000);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        ViewCompat.setTransitionName(imageView, TRANSITION_VIEW);
        Picasso.with(this).load(model.getImage()).into(imageView);
    }

    @Override
    public int getLayoutRes() {

        return R.layout.activity_detail;
    }

    public static void startActivity(Activity activity, ViewModel model, ImageView transitionView) {

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionView, TRANSITION_VIEW);
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_VIEW_MODEL, model);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
