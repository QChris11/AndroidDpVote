package com.kencin.exam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import java.util.Comparator;
import java.util.Arrays;

class xp {                                                   //ProgressBar类
    int p;                                //票数
    String name;                          //名字
    public xp(int a, String b){
        this.p=a;
        this.name=b;
    }

}
class mycmp implements Comparator<xp>            //从小到大排序函数
{

    public int compare(xp A, xp B)
    {
        if(A.p>B.p)
            return 1;
        else return -1;
    }
}

class mycmp2 implements Comparator<xp>              //从大到小排序函数
{

    public int compare(xp A, xp B)
    {
        if(A.p<B.p)
            return 1;
        else return -1;
    }
}




public class Votelook extends AppCompatActivity {

    private TextView musicText;
    private TextView danceText;
    private TextView animateText;
    private TextView englishText;
    private TextView japaneseText;
    private TextView germanText;
    private TextView franceText;
    private TextView macheText;
    private TextView lightText;
    private TextView materialText;
    private TextView[] MyText={musicText,danceText,animateText,englishText,japaneseText,germanText,franceText,macheText,lightText,materialText};
    private ProgressBar musicBar;
    private ProgressBar danceBar;
    private ProgressBar animateBar;
    private ProgressBar englishBar;
    private ProgressBar japaneseBar;
    private ProgressBar germanBar;
    private ProgressBar franceBar;
    private ProgressBar macheBar;
    private ProgressBar lightBar;
    private ProgressBar materialBar;
    private ProgressBar[] MyBar={musicBar,danceBar,animateBar,englishBar,japaneseBar,germanBar,franceBar,macheBar,lightBar,materialBar};
    private String BarName[] ={"音乐","舞蹈","动画","英语","日语","德语","法语","机械工程","光学工程","材料工程"};
    private TextView No1;
    private TextView No2;
    private TextView No3;
    private TextView No4;
    private TextView No5;
    private TextView No6;
    private TextView No7;
    private TextView No8;
    private TextView No9;
    private TextView No10;
    private TextView[] No={No1,No1,No3,No4,No5,No6,No7,No8,No9,No10};

    xp a[]=new xp[10];             //10个ProgressBar
    int[] c= new int[10];



    private Button LtoS;
    private Button StoL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votelook);
        MyText[0] = findViewById(R.id.musicText);
        MyBar[0] = findViewById(R.id.musicBar);
        MyText[1] = findViewById(R.id.danceText);
        MyBar[1] = findViewById(R.id.danceBar);
        MyText[2] = findViewById(R.id.animateText);
        MyBar[2] = findViewById(R.id.animateBar);
        MyText[3] = findViewById(R.id.englishText);
        MyBar[3] = findViewById(R.id.englishBar);
        MyText[4] = findViewById(R.id.japaneseText);
        MyBar[4] = findViewById(R.id.japaneseBar);
        MyText[5] = findViewById(R.id.germanText);
        MyBar[5] = findViewById(R.id.germanBar);
        MyText[6] = findViewById(R.id.franceText);
        MyBar[6] = findViewById(R.id.franceBar);
        MyText[7] = findViewById(R.id.macheText);
        MyBar[7] = findViewById(R.id.macheBar);
        MyText[8] = findViewById(R.id.lightText);
        MyBar[8] = findViewById(R.id.lightBar);
        MyText[9] = findViewById(R.id.materialText);
        MyBar[9] = findViewById(R.id.materialBar);
        No[0]=findViewById(R.id.No1);
        No[1]=findViewById(R.id.No2);
        No[2]=findViewById(R.id.No3);
        No[3]=findViewById(R.id.No4);
        No[4]=findViewById(R.id.No5);
        No[5]=findViewById(R.id.No6);
        No[6]=findViewById(R.id.No7);
        No[7]=findViewById(R.id.No8);
        No[8]=findViewById(R.id.No9);
        No[9]=findViewById(R.id.No10);


        Intent intent =getIntent();
        String name = intent.getStringExtra("a");

        for(int i =0;i<=9;i++)      //设置原本顺序
        {
            MyText[i].setText(MyBar[i].getProgress()+"票");
            if(name.equals(BarName[i]))
            {
                MyBar[i].incrementProgressBy(1);
                MyText[i].setText(MyBar[i].getProgress()+"票");
            }
        }



        for(int i=0;i<=9;i++)      //获取值到xp类
        {
//            int c[i] = new Vote().count[i];
            c[i] = MyBar[i].getProgress();
            a[i] = new xp (c[i],BarName[i]);
        }

        StoL=findViewById(R.id.StoL);
        StoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(a,0,10,new mycmp());
                for(int i =0;i<=9;i++)
                {
                    No[i].setText(a[i].name+"  ");                 //设置名字
                    MyText[i].setText(""+a[i].p);             //设置投票数字
                    MyBar[i].setProgress(a[i].p);             //设置进度条
                }
            }
        });


        LtoS=findViewById(R.id.LtoS);
        LtoS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(a,0,10,new mycmp2());
                for(int i =0;i<=9;i++)
                {
                    No[i].setText(a[i].name+"  ");                 //设置名字
                    MyText[i].setText(""+a[i].p);             //设置投票数字
                    MyBar[i].setProgress(a[i].p);             //设置进度条
                }
            }
        });
    }
}
