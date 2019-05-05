package com.example.tugas3_akb11_mochamadrifqi_10116470;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout LayoutDot;
    private TextView[] dotstv;
    private int[] layouts;
    private Button btnNext;
    private Button btnSkip;
    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isFirstTimeStartApp()){
            starMainActivty();
            finish();
        }


        setStatusBarTransparent();

        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        LayoutDot = findViewById(R.id.dotLayout);
        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);


        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                starMainActivty();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPage = viewPager.getCurrentItem()+1;
                if (currentPage < layouts.length){
                    viewPager.setCurrentItem(currentPage);
                }else{
                    starMainActivty();
                }
            }
        });
        layouts = new int[]{R.layout.activity_slide_1,R.layout.activity_slide_2,R.layout.activity_slide_3};
        pagerAdapter = new MyPagerAdapter(layouts, getApplicationContext());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == layouts.length -1){
                    btnNext.setText("FINISH");
                    btnSkip.setVisibility(View.GONE);
                }else{
                    btnNext.setText("Next");
                    btnSkip.setVisibility(View.VISIBLE);
                }

                setDotStatus(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setDotStatus(0);
    }
    private boolean isFirstTimeStartApp(){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag", true);
    }

    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", stt);
        editor.commit();
    }

    private void setDotStatus(int page){
        LayoutDot.removeAllViews();
        dotstv = new TextView[layouts.length];
        for (int i = 0; i < dotstv.length; i++){
            dotstv[i]= new TextView(this);
            dotstv[i].setText(Html.fromHtml("&#8226;"));
            dotstv[i].setTextSize(30);
            dotstv[i].setTextColor(Color.parseColor("#a9b4bb"));
            LayoutDot.addView(dotstv[i]);
        }

        if (dotstv.length>0){
            dotstv[page].setTextColor(Color.parseColor("#ffffff"));
        }
    }
    private void starMainActivty(){
        setFirstTimeStartStatus(false);
        startActivity(new Intent(Welcome.this, Menu.class));
        finish();
    }
    private void setStatusBarTransparent(){
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
