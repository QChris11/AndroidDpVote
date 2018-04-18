package com.kencin.exam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
import android.view.View;
import android.content.Intent;

public class Vote extends AppCompatActivity {
    private Spinner spinner_filed,spinner_major;
    ArrayAdapter <String> adapter_filed,adapter_major;
    private List<String> list_filed;
    String major[][]={{"音乐","舞蹈","动画"},{"英语","日语","德语","法语"},{"机械工程","光学工程","材料工程"}};
    private ImageView IG1;
    int resID1=R.drawable.pc1;
    int resID2=R.drawable.pc2;
    int resID3=R.drawable.pc3;
    int resID4=R.drawable.pc4;
    int resID5=R.drawable.pc5;
    int resID6=R.drawable.pc6;
    int resID7=R.drawable.pc7;
    int resID8=R.drawable.pc8;
    int resID9=R.drawable.pc9;
    int resID10=R.drawable.pc10;
    private Button b_vote;
    private Button b_look;
    private String BarName[] ={"音乐","舞蹈","动画","英语","日语","德语","法语","机械工程","光学工程","材料工程"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        spinner_filed=findViewById(R.id.spinner_filed);
        spinner_major=findViewById(R.id.spinner_major);
        IG1=findViewById(R.id.IG);
        initDatas();
        adapter_filed=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_filed);
        spinner_filed.setAdapter(adapter_filed);

        spinner_filed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter_major=new ArrayAdapter<String>(Vote.this,android.R.layout.simple_list_item_1,major[position]);//通过二维数组及position的值动态决定下级菜单的数据源
                adapter_major.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);//设置下拉显示样式
                spinner_major.setAdapter(adapter_major);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_major.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {        //设置各专业对应图像
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String position2 =spinner_major.getSelectedItem().toString();
                if(position2==BarName[0])
                    IG1.setImageResource(resID1);
                else if(position2==BarName[1])
                    IG1.setImageResource(resID2);
                else if(position2==BarName[2])
                    IG1.setImageResource(resID3);
                else if(position2==BarName[3])
                    IG1.setImageResource(resID4);
                else if(position2==BarName[4])
                    IG1.setImageResource(resID5);
                else if(position2==BarName[5])
                    IG1.setImageResource(resID6);
                else if(position2==BarName[6])
                    IG1.setImageResource(resID7);
                else if(position2==BarName[7])
                    IG1.setImageResource(resID8);
                else if(position2==BarName[8])
                    IG1.setImageResource(resID9);
                else if(position2==BarName[9])
                    IG1.setImageResource(resID10);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b_look=findViewById(R.id.b_look);          //查看投票按钮
        b_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vote.this,Votelook.class);    //连接两个Activity
                intent.putExtra("a","");              // 因为Votelook里面有getVote方法，所以加上了这个语句，其实没什么用
                startActivity(intent);
            }
        });

        b_vote=findViewById(R.id.b_vote);       //投票按钮
        b_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String position2 =spinner_major.getSelectedItem().toString();     //获得专业名称到position2
                Intent intent = new Intent(Vote.this,Votelook.class);
                intent.putExtra("a",position2);       //传出去专业名称
                startActivity(intent);
            }
        });
    }


    private void initDatas() {
        list_filed=new ArrayList<String>();
        list_filed.add("艺术");
        list_filed.add("语言");
        list_filed.add("工程");

    }
}
