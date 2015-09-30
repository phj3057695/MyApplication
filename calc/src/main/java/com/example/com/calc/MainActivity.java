package com.example.com.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    Button btnAdd, btnSub, btnMul, btnDiv,btnMod, btnSetdec;
    TextView textResult,textFormatString;
    String num1, num2, format, fstring;
    Double result;
    DecimalFormat df = new DecimalFormat("0.");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기 어플");
        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);
        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);
        btnMod = (Button)findViewById(R.id.BtnMod);
        btnSetdec = (Button)findViewById(R.id.BtnSetDec);
        textResult=(TextView)findViewById(R.id.TextResult);
        textFormatString=(TextView)findViewById(R.id.txtFormatString);

        btnSetdec.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fstring = "0.";
                format = textFormatString.getText().toString();
                try {
                    for (int i = 0; i < Integer.parseInt(format); i++) {
                        fstring = fstring + "#";
                    }
                    df.applyPattern(fstring);
                    if(Integer.parseInt(format) == 0){
                        Toast.makeText(getApplicationContext(), "정수만 나타냅니다.", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "소숫점 " + format + "째 자리까지 나타냅니다.", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "숫자 입력란이 비어 있습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + df.format(result).toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"숫자 입력란이 비어 있습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + df.format(result).toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"숫자 입력란이 비어 있습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);

                    textResult.setText("계산 결과 : " + df.format(result).toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"숫자 입력란이 비어 있습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try {
                    if(Double.parseDouble(num2)==0.0){
                        Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다.",Toast.LENGTH_LONG).show();
                    }
                    else {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + df.format(result).toString());
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"숫자 입력란이 비어 있습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try {
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + df.format(result).toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"숫자 입력란이 비어 있습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
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
