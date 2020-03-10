package com.devmohamedibrahim1997.ibnakeel.ui.main;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.databinding.FragmentLoginBinding;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import java.util.Objects;

public class LoginFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private FragmentLoginBinding loginBinding;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        init();
        initProgressDialog();
        return loginBinding.getRoot();
    }

    private void init() {
        sharedViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        loginBinding.loginButton.setOnClickListener(view -> {
            UIUtil.hideKeyboard(getActivity());
            login();
        });
    }
    
    private void initProgressDialog(){
        progressDialog = new ProgressDialog(getActivity(),R.style.MyTheme);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
    }

    private void login(){
        progressDialog.show();
        String userId = Objects.requireNonNull(loginBinding.userId.getText()).toString();
        String userPassword = Objects.requireNonNull(loginBinding.userPassword.getText()).toString();

        sharedViewModel.login(userId,userPassword).observe(getViewLifecycleOwner(), response -> {
            progressDialog.dismiss();
            if(response.equals("success")){
                getParentFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new MainFragment()).commit();
            }else{
                Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
            }
        });
    }
}