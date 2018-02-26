package pankaj.android.mvplogindemo.model;

import android.text.TextUtils;

import pankaj.android.mvplogindemo.presenter.LoginPresenter;
import pankaj.android.mvplogindemo.view.LoginView;

/**
 * Created by myT on 2/26/2018.
 */

public class PresenterImpl implements LoginPresenter {

    LoginView mLoginView;

    public PresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
    }

    @Override
    public void performLogin(String userName, String password) {

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            mLoginView.loginValidation();
        } else {
            if (userName.equals("admin") && password.equals("admin")){
                mLoginView.loginSuccess();
            } else {
                mLoginView.loginError();
            }
        }
    }
}
