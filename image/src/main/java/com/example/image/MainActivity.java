package com.example.image;

import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    Switch swtAgree;
    RadioGroup rGroup1;
    RadioButton rdoJellybean, rdoKitkat, rdoLollipop;
    Button btnExit;
    ImageView imgVer;
    LinearLayout visibleGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        visibleGroup=(LinearLayout)findViewById(R.id.visiblegroup);
        text1 = (TextView)findViewById(R.id.Text1);
        rGroup1=(RadioGroup)findViewById(R.id.Rgroup1);
        swtAgree=(Switch)findViewById(R.id.swtAgree);
        rdoJellybean=(RadioButton)findViewById(R.id.RdoJellyBean);
        rdoKitkat=(RadioButton)findViewById(R.id.RdoKitKat);
        rdoLollipop=(RadioButton)findViewById(R.id.RdoLollipop);
        btnExit =(Button)findViewById(R.id.BtnExit);
        imgVer=(ImageView)findViewById(R.id.imgVer);
    }
    public void switch_onChange(View v){
        if(swtAgree.isChecked()==true){
            visibleGroup.setVisibility(android.view.View.VISIBLE);
        }
        else{
            visibleGroup.setVisibility(android.view.View.INVISIBLE);
        }
    }
    public void btn_onClick(View v){
        switch(v.getId()){
            case R.id.BtnExit:
                finish();
                break;
            case R.id.BtnReset:
                rdoJellybean.setChecked(false);
                rdoKitkat.setChecked(false);
                rdoLollipop.setChecked(false);
                imgVer.setImageResource(0);
                swtAgree.setChecked(false);
                visibleGroup.setVisibility(android.view.View.INVISIBLE);
                break;
        }
    }
    public void radio_onClick(View v){
        switch(rGroup1.getCheckedRadioButtonId()){
            case R.id.RdoJellyBean:
                imgVer.setImageResource(R.drawable.jellybean);
                break;
            case R.id.RdoKitKat:
                imgVer.setImageResource(R.drawable.kitkat);
                break;
            case R.id.RdoLollipop:
                imgVer.setImageResource(R.drawable.lollipop);
                break;
            default:
                Toast.makeText(getApplicationContext(),"버전 먼저 선택하세요",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
