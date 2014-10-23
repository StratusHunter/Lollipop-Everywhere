package com.stratushunter.lollipopeverywhere.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.stratushunter.lollipopeverywhere.R;
import com.stratushunter.lollipopeverywhere.classes.ViewModel;
import com.stratushunter.lollipopeverywhere.interfaces.OnRecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by Terence Baker on 23/10/14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private OnRecyclerViewItemClickListener<ViewModel> mItemClickListener;
    private List<ViewModel> mList;

    public RecyclerAdapter(List<ViewModel> items, OnRecyclerViewItemClickListener<ViewModel> itemClickListener) {

        mList = items;
        mItemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_content, parent, false);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mItemClickListener != null) {

                    ViewModel model = (ViewModel) v.getTag();
                    mItemClickListener.onItemClick(v, model);
                }
            }
        });

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ViewModel model = mList.get(position);

        holder.textView.setText(model.getText());

        holder.imageView.setImageBitmap(null);
        Picasso.with(holder.imageView.getContext()).cancelRequest(holder.imageView);
        Picasso.with(holder.imageView.getContext()).load(model.getImage()).into(holder.imageView);

        //Used by the click listener
        holder.itemView.setTag(model);
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {

            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
