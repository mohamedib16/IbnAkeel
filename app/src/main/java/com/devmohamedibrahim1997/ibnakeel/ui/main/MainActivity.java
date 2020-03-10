package com.devmohamedibrahim1997.ibnakeel.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.ui.viewmodel.SharedViewModel;

public class MainActivity extends AppCompatActivity {


    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(savedInstanceState);
        initSharedViewModel();
        initActionBar();
    }

    private void init(Bundle savedInstanceState) {
        if(savedInstanceState ==  null){
            getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new LoginFragment()).commit();
        }
    }

    private void initSharedViewModel() {
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
    }

    private void initActionBar(){
        if(getSupportActionBar() != null){
            sharedViewModel.getActionBarTitleLiveData().observe(this, title -> {
                if (title.equals("app_name")) {
                    getSupportActionBar().setTitle(getString(R.string.app_name));
                }else{
                    getSupportActionBar().setTitle(title);
                    getSupportActionBar().setHomeButtonEnabled(true);
                    getSupportActionBar().setHo
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.register:
                Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}