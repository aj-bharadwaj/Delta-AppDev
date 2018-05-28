package com.example.ajay.delta1;

import java.util.ArrayList;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int x;
    TextView stone;
    ListView Memory;
    TextView complete;
    Button choose;
    Button reset;
    LinearLayout bg;
    boolean list[] = new boolean[6];
    ArrayList<String> slist;
    ArrayAdapter<String> ada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Memory = (ListView) findViewById(R.id.Memory);
        stone = (TextView) findViewById(R.id.stone);
        choose = (Button) findViewById(R.id.choose);
        reset = (Button) findViewById(R.id.reset);
        bg = this.<LinearLayout>findViewById(R.id.bg);
        slist = new ArrayList<String>();
        ada = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, slist);
        Memory.setAdapter(ada);
        for(x=0;x<6;x++)
            list[x]=false;
    }


    public void Cho(View view)
    {
        bg.setBackgroundColor(Color.BLACK);
        int num = (int) (Math.random() * 6) + 1;
        if (num == 1) {
            stone.setText("Power Stone obtained");
            bg.setBackgroundColor(Color.parseColor("#9932CC"));
            slist.add("Power Stone");
            ada.notifyDataSetChanged();
            list[0] = true;
        }
        else if (num == 2) {
            stone.setText("Space Stone obtained");
            bg.setBackgroundColor(Color.BLUE);
            slist.add("Space Stone");
            ada.notifyDataSetChanged();
            list[1] = true;
        } else if (num == 3) {
            stone.setText("Time Stone obtained");
            bg.setBackgroundColor(Color.GREEN);
            slist.add("Time Stone");
            ada.notifyDataSetChanged();
            list[2] = true;
        } else if (num == 4) {
            stone.setText("Reality Stone obtained");
           bg.setBackgroundColor(Color.RED);
            slist.add("Reality Stone");
            ada.notifyDataSetChanged();
            list[3] = true;
        } else if (num == 5) {
            stone.setText("Soul Stone obtained");
            bg.setBackgroundColor(Color.parseColor("#FF7F24"));
            slist.add("Soul Stone");
            ada.notifyDataSetChanged();
            list[4] = true;
        } else if (num == 6) {
            stone.setText("Mind Stone obtained");
            bg.setBackgroundColor(Color.YELLOW);
            slist.add("Mind Stone");
            ada.notifyDataSetChanged();
            list[5] = true;
        }
        boolean flag = true;
        for (x = 0; x < 6; x++)
            if (list[x]==false)
                flag = false;
        if (flag)
            complete.setText("All the infinity stones have been successfully obtained");
        else
            complete.setText("");
    }

    public void Reset(View view)
    {
        slist.clear();
        ada.notifyDataSetChanged();
        for(x=0; x<6; x++)
            list[x] = false;
    }
}