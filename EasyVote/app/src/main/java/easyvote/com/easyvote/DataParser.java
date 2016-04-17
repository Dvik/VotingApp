package easyvote.com.easyvote;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by vishwesh on 16/3/16.
 */
public class DataParser {
    ArrayList<String> subList = new ArrayList<>();
    public int parseSignUp(Context context, JSONObject jsonObject) {
        try {
            /*String error = jsonObject.getString("error");
            String status = jsonObject.getString("status");
            if (error.equals("true"))
                return -1;
            else {
                if (status.equals("1"))*/ {

                    JSONArray message = jsonObject.getJSONArray("result");
                //Toast.makeText(context, String.valueOf(message.length()) + "vbnm", Toast.LENGTH_LONG).show();

                if (jsonObject.get("success").equals("1"))
                {
                    Toast.makeText(context,"Logged in",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context,HomeActivity.class);
                    ((RegisterActivity) context).startActivity(intent);
                }else
                {
                    Toast.makeText(context,"Please try again",Toast.LENGTH_SHORT).show();
                }


                    return 1;
                }/* else {
                    return 2;
                }*/
            } catch (JSONException e1) {
            e1.printStackTrace();
        }



      return -1;
    }
    public int parseLogin(Context context, JSONObject jsonObject) {
        try {
            /*String error = jsonObject.getString("error");
            String status = jsonObject.getString("status");
            if (error.equals("true"))
                return -1;
            else {
                if (status.equals("1"))*/ {

                JSONArray message = jsonObject.getJSONArray("result");
                //Toast.makeText(context, String.valueOf(message.length()) + "vbnm", Toast.LENGTH_LONG).show();

                if (jsonObject.get("success")=="1")
                {
                    Intent intent = new Intent(context,HomeActivity.class);
                    ((RegisterActivity) context).startActivity(intent);
                }else
                {
                    Toast.makeText(context,"Please try again, invalid inputs",Toast.LENGTH_SHORT).show();
                }


                return 1;
            }/* else {
                    return 2;
                }*/
        } catch (JSONException e1) {
            e1.printStackTrace();
        }



        return -1;
    }


}
