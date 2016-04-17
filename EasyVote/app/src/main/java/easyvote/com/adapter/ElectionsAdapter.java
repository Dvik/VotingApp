
package easyvote.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import easyvote.com.SessionManager;
import easyvote.com.easyvote.R;
import easyvote.com.model.Election;
import easyvote.com.model.Election;

/**
 * Created by Divya on 12/11/2015.
 */

public class ElectionsAdapter extends RecyclerView.Adapter<ElectionsAdapter.ViewHolder> {

    private ArrayList<Election> electionList = new ArrayList<Election>();
    SessionManager session;

    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_name,textView2_place,textView3_date,textView4_time;


        public ViewHolder(LinearLayout v) {
            super(v);

            textView_name = (TextView) v.findViewById(R.id.textView_name);
            textView2_place = (TextView) v.findViewById(R.id.textView2_place);
            textView3_date = (TextView) v.findViewById(R.id.textView3_date);
            textView4_time = (TextView) v.findViewById(R.id.textView4_time);
        }
    }

    public void add(int position, Election election) {
        electionList.add(position, election);
        notifyItemInserted(position);
    }

    public void remove(Election item) {
        int position = electionList.indexOf(item);
        electionList.remove(position);
        notifyItemRemoved(position);
    }

    public void updateList(ArrayList<Election> data) {
        electionList = data;
        notifyDataSetChanged();
    }

    public ElectionsAdapter(Context context) {
        this.context = context;
        session = new SessionManager(context);
    }

    @Override
    public ElectionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.election_row, parent, false);
        ViewHolder vh = new ViewHolder((LinearLayout)v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Election r = electionList.get(position);

        holder.textView_name.setText(r.name);
        holder.textView2_place.setText(r.place);

        holder.textView3_date.setText(r.date);
        holder.textView4_time.setText(r.timings);
        holder.textView_name.setText(r.name);





    }


    @Override
    public int getItemCount() {
        return electionList.size();

    }
}
