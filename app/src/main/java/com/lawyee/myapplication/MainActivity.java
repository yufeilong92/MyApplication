package com.lawyee.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2, spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        //加载省份列表
        loadProvince();
        //设置spinner1的监听事件
        spinner1.setOnItemSelectedListener(new Spinner1ClickListener());
        //加载城市列表
        loadCity();
        //设置spinner2的监听事件
        spinner2.setOnItemSelectedListener(new Spinner2ClickListener());
        //加载区域列表
        loadGZArea();
        //设置spinner3的监听事件
        spinner3.setOnItemSelectedListener(new Spinner3ClickListener());
    }

    /**
     * 加载省份列表
     */
    public void loadProvince() {
        String[] array1 = new String[]{"请选择", "广东省"};
        SpinnerAdapter adapterOne = new SpinnerAdapter(this, array1, R.layout.a);
        spinner1.setAdapter(adapterOne);
    }

    /**
     * 加载城市列表
     */
    public void loadCity() {
        String[] array2 = new String[]{"请选择", "广州市", "深圳市"};
        SpinnerAdapter modelTwo = new SpinnerAdapter(this, array2, R.layout.a);
        spinner2.setAdapter(modelTwo);
    }

    /**
     * 加载广州区域列表
     */
    public void loadGZArea() {
        String[] array3 = new String[]{"请选择", "天河区", "越秀区", "荔湾区", "海珠区", "萝岗区", "白云区", "黄埔区", "花都区"};
        SpinnerAdapter modelThree = new SpinnerAdapter(this, array3, R.layout.a);
        spinner3.setAdapter(modelThree);
    }

    /**
     * 加载深圳区域列表
     */
    public void loadSZArea() {
        String[] array3 = new String[]{"请选择", "龙岗区", "南山区", "福田区", "罗湖区", "盐田区", "宝安区"};
        SpinnerAdapter modelThree = new SpinnerAdapter(this, array3, R.layout.a);
        spinner3.setAdapter(modelThree);
    }

    /**
     * Spinner1点击事件
     */
    public class Spinner1ClickListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String str = (String) adapterView.getItemAtPosition(i);
            //判断是否选择城市，如果没有选择那么就隐藏Spinner2,Spinner3两个下拉框，否则显示Spinner2下拉框，继续隐藏Spinner3
            if (str.equals("请选择")) {
                spinner2.setVisibility(View.INVISIBLE);
                spinner3.setVisibility(View.INVISIBLE);
            } else {
                spinner2.setVisibility(View.VISIBLE);

                //将第二个下拉框的选项重新设置为选中“请选择”这个选项。
                spinner2.setSelection(0);
            }

            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    /**
     * Spinner2点击事件
     */
    public class Spinner2ClickListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String str = (String) adapterView.getItemAtPosition(i);
            if (str.equals("请选择")) {
                spinner3.setVisibility(View.INVISIBLE);
            } else {
                //显示第三个Spinner3
                spinner3.setVisibility(View.VISIBLE);

                if (str.equals("深圳市")) {
                    //重新加载深圳区域列表
                    loadSZArea();
                } else if (str.equals("广州市")) {
                    //重新加载广州区域列表
                    loadGZArea();
                }
            }
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    /**
     * Spinner3点击事件
     */
    public class Spinner3ClickListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String str = (String) adapterView.getItemAtPosition(i);
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}