package in.preeti.android_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by preeti on 29/12/17.
 */

public class ActivitySignUp extends AppCompatActivity {

    private EditText medtuseremail,medtpassword;
    private Button mbtnSignUp;
    private TextView mtxtlogin;
    private DBManager mDBManager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mDBManager=new DBManager(ActivitySignUp.this,"UserData.db",null,1);

        medtuseremail= (EditText) findViewById(R.id.edtuseremail);
        medtpassword= (EditText) findViewById(R.id.edtuserpassword);
        mtxtlogin= (TextView) findViewById(R.id.textlogin);
        mbtnSignUp= (Button) findViewById(R.id.btnsignup);
        mbtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=medtuseremail.getText().toString();
                String password=medtpassword.getText().toString();

                if (!(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches())){

                    medtuseremail.setError("Invalid Email");
                }else if (password.isEmpty() || password.length()<8){
                    medtpassword.setError("Length must be minimum 8 characters");
                }else {

                    UserData userData=new UserData(email,password);
                    mDBManager.addUser(userData);
                    Intent intent=new Intent(ActivitySignUp.this,ActivitySignIn.class);
                    startActivity(intent);
                }



            }
        });


        mtxtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivitySignUp.this,ActivitySignIn.class);
                startActivity(intent);
            }
        });

    }
}
