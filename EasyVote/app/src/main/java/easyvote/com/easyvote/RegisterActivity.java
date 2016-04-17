package easyvote.com.easyvote;

import android.content.Intent;
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.email_sign_up_button:
                if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty()
                        &&!password.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() )
                {
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
}
