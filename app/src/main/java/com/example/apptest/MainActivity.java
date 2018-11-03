package com.example.apptest;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apptest.secondLevel.ApplicationActivity;
import com.example.apptest.secondLevel.CreateActivity;
import com.example.apptest.secondLevel.SearchActivity;
import com.example.apptest.tools.MyData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_to_appliccation,button_create_group, button_search_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_to_appliccation = findViewById(R.id.button_toApplication);
        button_create_group = findViewById(R.id.button_create_group);
        button_search_group = findViewById(R.id.button_to_search_group);
        button_to_appliccation.setOnClickListener(this);
        button_create_group.setOnClickListener(this);
        button_search_group.setOnClickListener(this);
        setDarkStatusIcon(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_toApplication:
                Intent intent = new Intent(this, ApplicationActivity.class);
                startActivity(intent);
                break;
            case R.id.button_create_group:
                intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.button_to_search_group:
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

    MyData[] getDataBean(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        
        MyData[] myData = new MyData[jsonArray.length()];
        for (int i = 0;i<jsonArray.length();i++){
            JSONObject jsO = jsonArray.getJSONObject(i);
            MyData myData1 = new MyData();
            myData1.setName(jsO.getString("name"));
            myData1.setAge(jsO.getString("age"));
            myData[i] = myData1;
        }
        return myData;
    }

}
