package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llHome,llSupermarket,llOrder,llMine;
    private ImageView ivHome,ivSupermarket,ivOrder,ivMine;
    private TextView tvHome,tvSupermarket,tvOrder,tvMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        llHome = findViewById(R.id.ll_home);
        llSupermarket = findViewById(R.id.ll_supermarket);
        llOrder = findViewById(R.id.ll_order);
        llMine = findViewById(R.id.ll_mine);

        ivHome = findViewById(R.id.iv_home);
        ivSupermarket = findViewById(R.id.iv_supermarket);
        ivOrder = findViewById(R.id.iv_order);
        ivMine = findViewById(R.id.iv_mine);

        tvHome = findViewById(R.id.tv_home);
        tvSupermarket = findViewById(R.id.tv_supermarket);
        tvOrder = findViewById(R.id.tv_order);
        tvMine =findViewById(R.id.tv_mine);
    }

    private void initEvent() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new HomeFragment());
        fragmentTransaction.commit();

        ivHome.setImageResource(R.drawable.home_blue);

        llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new HomeFragment());
                fragmentTransaction.commit();

                ivHome.setImageResource(R.drawable.home_blue);
                ivSupermarket.setImageResource(R.drawable.supermarket);
                ivOrder.setImageResource(R.drawable.order);
                ivMine.setImageResource(R.drawable.mine);
            }
        });

        llSupermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new SupermarketFragment());
                fragmentTransaction.commit();

                ivHome.setImageResource(R.drawable.home);
                ivSupermarket.setImageResource(R.drawable.supermarket_blue);
                ivOrder.setImageResource(R.drawable.order);
                ivMine.setImageResource(R.drawable.mine);
            }
        });

        llOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new OrderFragment());
                fragmentTransaction.commit();

                ivHome.setImageResource(R.drawable.home);
                ivSupermarket.setImageResource(R.drawable.supermarket);
                ivOrder.setImageResource(R.drawable.order_blue);
                ivMine.setImageResource(R.drawable.mine);
            }
        });

        llMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new MineFragment());
                fragmentTransaction.commit();

                ivHome.setImageResource(R.drawable.home);
                ivSupermarket.setImageResource(R.drawable.supermarket);
                ivOrder.setImageResource(R.drawable.order);
                ivMine.setImageResource(R.drawable.mine_blue);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}