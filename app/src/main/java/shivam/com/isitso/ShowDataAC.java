package shivam.com.isitso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShowDataAC extends AppCompatActivity {

    int n=0,tot;
    String topic,rdata;
    TextView title,sno,tv;
    ArrayList data= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data_ly);
        tv= (TextView) findViewById(R.id.tv);
        sno= (TextView) findViewById(R.id.sno);
        title= (TextView) findViewById(R.id.topic);
        fatchData();
        doToken();
        n=0;
        showContent();
    }

    public void fatchData(){
        Intent i= this.getIntent();
        topic= i.getStringExtra("topic");
        rdata= i.getStringExtra("data");
        title.setText(topic);
    }

    public void doToken(){
        StringTokenizer st= new StringTokenizer(rdata,"\n");
        while(st.hasMoreTokens()){
            data.add(n++,st.nextToken());
        }
        tot=n;
    }


    public void previous(View v){
        n--;
        showContent();
    }

    public void next(View v){
        n++;
        showContent();
    }


    public void showContent(){
        try {
            String dd = data.get(n).toString();
            tv.setText(dd);
            sno.setText("("+(n+1)+"/"+tot+")");
        }catch (Exception e){
            if(n>=tot)
                n=0;
            else
                n=tot-1;
            showContent();
        }
    }



}
