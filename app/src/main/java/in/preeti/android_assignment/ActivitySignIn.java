package in.preeti.android_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by preeti on 29/12/17.
 */

public class ActivitySignIn extends AppCompatActivity {

    private EditText mEdtUsername,mEdtPassword;
    private Button mBtnSignIn;
    private DBManager mDBmanager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_signin);

        mDBmanager=new DBManager(ActivitySignIn.this,"UserData.db",null,1);

        mEdtUsername= (EditText) findViewById(R.id.edtUserEmail);
        mEdtPassword= (EditText) findViewById(R.id.edtUserPassword);
        mBtnSignIn= (Button) findViewById(R.id.btnSignIn);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {

        String email=mEdtUsername.getText().toString();
        String password=mEdtPassword.getText().toString();

        if (!(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) || email.isEmpty()){

            mEdtUsername.setError("Invalid Email");
        }else if (password.isEmpty() || password.length()<8){

            mEdtPassword.setError("Invalid Password");


        }else if (!mDBmanager.checkUser(email,password)){
            Toast.makeText(ActivitySignIn.this,"Login Failed",Toast.LENGTH_SHORT).show();


        }else {
            Toast.makeText(ActivitySignIn.this,"Login Successful",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ActivitySignIn.this,MainActivity.class);
            startActivity(intent);
            mEdtUsername.setText(null);
            mEdtPassword.setText(null);
        }
    }

}
