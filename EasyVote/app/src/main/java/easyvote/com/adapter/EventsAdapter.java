package lnmiit.madclub.plinth.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Model.ModelEvents;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 12/31/2015.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    ArrayList<ModelEvents> modelArrayList = new ArrayList<>();
    Context context;

    public EventsAdapter(ArrayList<ModelEvents> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {
        ModelEvents modelEvents = modelArrayList.get(position);
        holder.name.setText(modelEvents.name);
        if(holder.name.equals("Negotio")){
            holder.image.setBackgroundResource(modelEvents.image);
        }else {
            holder.image.setImageResource(modelEvents.image);
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView1);
            image = (ImageView) itemView.findViewById(R.id.imageView1);
        }
    }

}
