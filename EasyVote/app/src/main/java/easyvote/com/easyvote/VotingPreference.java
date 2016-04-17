package hp.com.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class VotingPreference extends AppCompatActivity {

    Spinner Ipref,IIpref,IIIpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_pref);
        Ipref=(Spinner)findViewById(R.id.spinner_1stpref);
        IIpref=(Spinner)findViewById(R.id.spinner_2ndpref);
        IIIpref=(Spinner)findViewById(R.id.spinner_3rdpref);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.candidate_names)); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Ipref.setAdapter(spinnerArrayAdapter);
        IIIpref.setAdapter(spinnerArrayAdapter);
        IIpref.setAdapter(spinnerArrayAdapter);

    }
}
