package pankaj.android.mvplogindemo.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pankaj.android.mvplogindemo.R;
import pankaj.android.mvplogindemo.model.PresenterImpl;
import pankaj.android.mvplogindemo.presenter.LoginPresenter;
import pankaj.android.mvplogindemo.view.LoginView;

public class MainActivity extends Activity implements View.OnClickListener, LoginView {


    private EditText userName;
    private EditText password;
    private AppCompatButton login;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);

        login.setOnClickListener(this);

        mLoginPresenter = new PresenterImpl(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        String Username = userName.getText().toString();
        String Password = password.getText().toString();
        mLoginPresenter.performLogin(Username,Password);
    }

    @Override
    public void loginValidation() {

        Toast.makeText(getApplicationContext(),"Please Enter userName and password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(),"Login Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(),"Login Failure", Toast.LENGTH_SHORT).show();
    }
}

