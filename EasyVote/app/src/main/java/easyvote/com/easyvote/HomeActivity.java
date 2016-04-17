package easyvote.com.easyvote;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by vishwesh on 17/4/16.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import easyvote.com.SessionManager;
import easyvote.com.adapter.ElectionsAdapter;
import easyvote.com.model.Election;
import easyvote.com.model.User;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rv;
    ElectionsAdapter adapter;
    SessionManager session;
    ProgressBar uploadProgressBar;
    String id;
    ArrayList<Election> electionsList;
    CoordinatorLayout coordinatorLayout1;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(this);


        session = new SessionManager(getApplicationContext());

        electionsList = new ArrayList<Election>();

        rv = (RecyclerView) findViewById(R.id.main_recycler);

        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rv.setLayoutManager(llm);

        adapter = new ElectionsAdapter(HomeActivity.this.getApplicationContext());
        adapter.updateList(electionsList);
        rv.setAdapter(adapter);

        JsonObject json = new JsonObject();

        progressDialog.setMessage("Loading elections list..");
        progressDialog.show();
        Ion.with(getApplicationContext())
                .load("GET", Config.mainURL + "/getAllElections.php")
                .setJsonObjectBody(json)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        progressDialog.dismiss();
                        try {
                            if (result.size() == 0) {

                            } else {

                                for (int i = 0; i < result.size(); i++) {
                                    try {
                                        JsonObject jObj = result.get(i).getAsJsonObject();


                                        String id = jObj.get("id").getAsString();
                                        String name = jObj.get("name").getAsString();
                                        String place = jObj.get("place").getAsString();
                                        String date = jObj.get("date").getAsString();
                                        String timings = jObj.get("timings").getAsString();
                                        String positionId = jObj.get("positionId").getAsString();
                                        String organiserId = jObj.get("organiserId").getAsString();



                                        electionsList.add(new Election(id, name, place, date, timings,positionId,organiserId));

                                    } catch (Exception te) {


                                    }


                                }
                                adapter.notifyDataSetChanged();
                            }


                        }
                        catch (Exception ert)
                        {

                        }
                    }
                });

    }

}