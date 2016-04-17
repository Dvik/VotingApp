package easyvote.com.easyvote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Divya on 4/17/2016.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button register,login;
    EditText name,email,phone,password;
    private View mLoginFormView;
    private View mProgressView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

    }

    private void init() {
        register = (Button)findViewById(R.id.email_sign_up_button);
        login = (Button)findViewById(R.id.email_sign_in_button);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        password = (EditText)findViewById(R.id.password);

        register.setOnClickListener(this);
        login.setOnClickListener(this);

        mLoginFormView = findViewById(R.id.register_form);
        mProgressView = findViewById(R.id.register_progress);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.email_sign_up_button:
                if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty()
                        &&!password.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() )
                {
                    showProgress(true);
                    new HttpCall().getRegisterData(RegisterActivity.this,name.getText().toString(),
                            email.getText().toString(),phone.getText().toString(),password.getText().toString());
                }else
                {
                    Snackbar.make(v,"Please enter above cedentrial",Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.email_sign_in_button:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
        }
    }


    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}

