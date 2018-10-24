package com.example.apptest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.apptest.secondLevel.CreateActivity;
import com.example.apptest.secondLevel.SearchActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_create_group, button_search_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_create_group = findViewById(R.id.button_create_group);
        button_search_group = findViewById(R.id.button_search_group);
        button_create_group.setOnClickListener(this);
        button_search_group.setOnClickListener(this);
        setDarkStatusIcon(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_create_group:
                Intent intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.button_search_group:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
        }

    }

    /**
     * 说明：Android 6.0+ 状态栏图标原生反色操作
     */
    protected void setDarkStatusIcon(boolean dark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = getWindow().getDecorView();
            if (decorView == null) return;

            int vis = decorView.getSystemUiVisibility();
            if (dark) {
                vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            decorView.setSystemUiVisibility(vis);
        }
    }
}
