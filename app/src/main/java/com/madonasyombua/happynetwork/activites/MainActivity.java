package com.madonasyombua.happynetwork.activites;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.madonasyombua.happynetwork.R;
import com.madonasyombua.happynetwork.databinding.ActivityMainBinding;
import com.madonasyombua.happynetwork.fragments.SignInFragment;
import com.scwang.wave.MultiWaveHeader;


public class MainActivity extends AppCompatActivity {

   ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

           if (savedInstanceState == null)
            setFragment(new SignInFragment());
             waveHeader(false);


    }

    void waveHeader(boolean show) {
        if (binding.waveHeader != null) {
            if (show)
                binding.waveHeader.start();
            else {
                binding.waveHeader.stop();
            }
        }
    }

    void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
