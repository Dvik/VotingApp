package easyvote.com.easyvote;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by vishwesh on 16/3/16.
 */
public class HttpCall {
    int result;

    public void getRegisterData(final Context context, String name, String email,String phone, String password){
        RequestParams requestParams = new RequestParams();
        requestParams.put("name", name);
        requestParams.put("email", email);
        requestParams.put("phone", phone);
        requestParams.put("password", password);
        requestParams.put("register", "");


        EndPoints.getRegisterData(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        /*if (service != null)
                            service.stopSelf();*/
                        //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        Log.e("response", response.toString());
                        result = new DataParser().parseSignUp(context, response);
                        /*if (result == 1) {
                            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
                        } else if (result == -1) {
                            Toast.makeText(context, "No updates", Toast.LENGTH_SHORT).show();
                        }*/
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        //Log.e("error", errorResponse.toString() + " vishwesh");
                    }
                }
        );
    }
    public void getLogin(final Context context, String email, String password){
        RequestParams requestParams = new RequestParams();
        requestParams.put("email", email);
        requestParams.put("password", password);
        requestParams.put("login", "");


        Log.e("inGetLogin",password);

        EndPoints.getLoginData(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        /*if (service != null)
                            service.stopSelf();*/
                        //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        Log.e("response", response.toString());
                        result = new DataParser().parseLogin(context, response);
                        /*if (result == 1) {
                            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
                        } else if (result == -1) {
                            Toast.makeText(context, "No updates", Toast.LENGTH_SHORT).show();
                        }*/
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        //Log.e("error", errorResponse.toString() + " vishwesh");
                    }
                }
        );
    }


}

