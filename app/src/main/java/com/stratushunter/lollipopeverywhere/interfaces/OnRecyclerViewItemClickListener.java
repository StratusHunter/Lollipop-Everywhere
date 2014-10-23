package com.stratushunter.lollipopeverywhere.interfaces;

import android.view.View;

/**
 * Created by Terence Baker on 23/10/14.
 */
public interface OnRecyclerViewItemClickListener<Model> {

    public void onItemClick(View view, Model model);
}
