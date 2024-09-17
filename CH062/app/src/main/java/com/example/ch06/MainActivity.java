package com.example.ch06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener{

    String start="台南";
    String At="台北";
    String price="0";
    String direction="北上";

    int to_position;
    String all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner start_city = findViewById(R.id.start_city);
        start_city.setOnItemSelectedListener(this);
        RadioGroup ticket = findViewById(R.id.ticket);
        ticket.setOnCheckedChangeListener(this);
        RadioGroup upordown = findViewById(R.id.upordown);
        upordown.setOnCheckedChangeListener(this);
        ListView final_city=findViewById(R.id.final_city);
        final_city.setOnItemClickListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Spinner start_city=findViewById(R.id.start_city);
        RadioGroup upordown = findViewById(R.id.upordown);
        String[] tempset1={"台北","桃園","新竹","台中","嘉義","台南"};
        String[] tempset2={"桃園","新竹","台中","嘉義","台南","高雄"};
        String[] temp;
        if(upordown.getCheckedRadioButtonId() == R.id.northup)
            {
                temp=tempset2;
                direction="北上";
            }
        else {
            temp = tempset1;
            direction = "南下";
        }
        ArrayAdapter<String> tempAd = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,temp);
        tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        start_city.setAdapter(tempAd);

        RadioGroup ticket = findViewById(R.id.ticket);
        double p;
        p=Double.parseDouble(price);
        double p_temp=Double.parseDouble(price);

        if(ticket.getCheckedRadioButtonId()==R.id.half) {
            p_temp=p/2;
            TextView txv=(TextView)findViewById(R.id.txv);
            all=direction+start+At+"票價為"+String.valueOf(p_temp)+"元";
            txv.setText(all);
        }
        else if(ticket.getCheckedRadioButtonId()==R.id.group) {
            p_temp=p*0.95;
            TextView txv=(TextView)findViewById(R.id.txv);
            all=direction+start+At+"票價為"+String.valueOf(p_temp)+"元";
            txv.setText(all);
        }
        else if(ticket.getCheckedRadioButtonId()==R.id.full){
            p = Double.parseDouble(price);
            price=String.valueOf(p);
            TextView txv=(TextView)findViewById(R.id.txv);
            all=direction+start+At+"票價為"+price+"元";
            txv.setText(all);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView final_city=(ListView)findViewById(R.id.final_city);
        TextView txv=findViewById(R.id.txv);
        TextView text=(TextView) view;
        String item2=text.getText().toString();
        TextView fin=(TextView) findViewById(R.id.fin);


        At=item2;
        fin.setText("終點:"+At);
        if(start.equals("台北") && At.equals("桃園") || At.equals("台北") && start.equals("桃園"))
            price="160";
        if(start.equals("台北") && At.equals("新竹") || At.equals("台北") && start.equals("新竹"))
            price="290";
        if(start.equals("台北") && At.equals("台中") || At.equals("台北") && start.equals("台中"))
            price="700";
        if(start.equals("台北") && At.equals("嘉義") || At.equals("台北") && start.equals("嘉義"))
            price="1080";
        if(start.equals("台北") && At.equals("台南") || At.equals("台北") && start.equals("台南"))
            price="1350";
        if(start.equals("台北") && At.equals("高雄") || At.equals("台北") && start.equals("高雄"))
            price="1490";

        if(start.equals("桃園") && At.equals("新竹") || At.equals("桃園") && start.equals("新竹"))
            price="130";
        if(start.equals("桃園") && At.equals("台中") || At.equals("桃園") && start.equals("台中"))
            price="540";
        if(start.equals("桃園") && At.equals("嘉義") || At.equals("桃園") && start.equals("嘉義"))
            price="920";
        if(start.equals("桃園") && At.equals("台南") || At.equals("桃園") && start.equals("台南"))
            price="1190";
        if(start.equals("桃園") && At.equals("高雄") || At.equals("桃園") && start.equals("高雄"))
            price="1330";

        if(start.equals("新竹") && At.equals("台中") || At.equals("新竹") && start.equals("台中"))
            price="410";
        if(start.equals("新竹") && At.equals("嘉義") || At.equals("新竹") && start.equals("嘉義"))
            price="790";
        if(start.equals("新竹") && At.equals("台南") || At.equals("新竹") && start.equals("台南"))
            price="1060";
        if(start.equals("新竹") && At.equals("高雄") || At.equals("新竹") && start.equals("高雄"))
            price="1200";

        if(start.equals("台中") && At.equals("嘉義") || At.equals("台中") && start.equals("嘉義"))
            price="380";
        if(start.equals("台中") && At.equals("台南") || At.equals("台中") && start.equals("台南"))
            price="650";
        if(start.equals("台中") && At.equals("高雄") || At.equals("台中") && start.equals("高雄"))
            price="790";

        if(start.equals("台南") && At.equals("高雄") || At.equals("台南") && start.equals("高雄"))
            price="140";

        /*all=direction+start+At+"票價為"+price+"元";
        txv.setText(all);*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView txv=(TextView) view;
        String item=txv.getText().toString();
        TextView sta=(TextView) findViewById(R.id.sta);
        start=item;
        to_position=position;
        sta.setText("起點:"+start);

        ListView final_city=(ListView) findViewById(R.id.final_city);
        //北上
        String[] tmp1={"台北"};String []tmp2={"台北","桃園"};String []tmp3={"台北","桃園","新竹"};
        String[] tmp4={"台北","桃園","新竹","台中"};String[] tmp5={"台北","桃園","新竹","台中","嘉義"};
        String[] tmp6={"台北","桃園","新竹","台中","嘉義","台南"};
        //南下;
        String[] tmp7={"高雄"};String[] tmp8={"台南","高雄"};String[] tmp9={"嘉義","台南","高雄"};
        String[] tmp10={"台中","嘉義","台南","高雄"}; String[] tmp11={"新竹","台中","嘉義","台南","高雄"};
        String[] tmp12={"桃園","新竹","台中","嘉義","台南","高雄"};

        String[] tmp={"台北","桃園","新竹","台中","嘉義","台南","高雄"};

       if(start.equals("台北") && direction.equals("南下"))tmp=tmp12;
        else if(start.equals("桃園") && direction.equals("北上"))tmp=tmp1;
        else if(start.equals("桃園") && direction.equals("南下"))tmp=tmp11;
        else if(start.equals("新竹") && direction.equals("北上"))tmp=tmp2;
        else if(start.equals("新竹") && direction.equals("南下"))tmp=tmp10;
        else if(start.equals("台中") && direction.equals("北上"))tmp=tmp3;
        else if(start.equals("台中") && direction.equals("南下"))tmp=tmp9;
        else if(start.equals("嘉義") && direction.equals("北上"))tmp=tmp4;
        else if(start.equals("嘉義") && direction.equals("南下"))tmp=tmp8;
        else if(start.equals("台南") && direction.equals("北上"))tmp=tmp5;
        else if(start.equals("台南") && direction.equals("南下"))tmp=tmp7;
        else if(start.equals("高雄"))tmp=tmp6;



        ArrayAdapter<String> d_temp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,tmp);
        d_temp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final_city.setAdapter(d_temp);
        findViewById(R.id.final_city).setVisibility(View.VISIBLE);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}