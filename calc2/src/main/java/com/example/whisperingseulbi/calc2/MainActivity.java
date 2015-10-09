package com.example.whisperingseulbi.calc2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button[] numButtons = new Button[10];
    Button btnAdd, btnSub, btnMul, btnDiv;
    EditText edit1, edit2;
    TextView textResult;
    String num1, num2;
    Integer result;
    Integer[] numBtnIDs = {R.id.Btn0, R.id.Btn1,R.id.Btn2,R.id.Btn3,R.id.Btn4,R.id.Btn5,R.id.Btn6,R.id.Btn7,R.id.Btn8,R.id.Btn9};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title);
        edit1=(EditText)findViewById(R.id.Edit1);
        edit2=(EditText)findViewById(R.id.Edit2);
        btnAdd=(Button)findViewById(R.id.BtnAdd);
        btnSub=(Button)findViewById(R.id.BtnSub);
        btnMul=(Button)findViewById(R.id.BtnMul);
        btnDiv=(Button)findViewById(R.id.BtnDiv);
        textResult=(TextView)findViewById(R.id.TxtResult);
        for(i=0;i<numBtnIDs.length;i++){
            numButtons[i]=(Button)findViewById(numBtnIDs[i]);
        }
        for(i=0;i<numBtnIDs.length;i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(edit1.isFocused()==true){
                        num1=edit1.getText().toString()+numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused()==true){
                        num2=edit2.getText().toString()+numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),R.string.empty,Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void btnArith_OnClick(View v){
        num1=edit1.getText().toString();
        num2=edit2.getText().toString();
            try {
                switch(v.getId()) {
                    case R.id.BtnAdd:
                        result = Integer.parseInt(num1) + Integer.parseInt(num2);
                        textResult.setText(getResources().getText(R.string.CalResult)+" "+result.toString());
                        break;
                    case R.id.BtnSub:
                        result = Integer.parseInt(num1) - Integer.parseInt(num2);
                        textResult.setText(getResources().getText(R.string.CalResult)+" "+result.toString());
                        break;
                    case R.id.BtnMul:
                        result = Integer.parseInt(num1) * Integer.parseInt(num2);
                        textResult.setText(getResources().getText(R.string.CalResult)+" "+result.toString());
                        break;
                    case R.id.BtnDiv:
                        if(Integer.parseInt(num2)==0){
                            Toast.makeText(getApplicationContext(),R.string.cannotdiv0,Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            result = Integer.parseInt(num1) / Integer.parseInt(num2);
                            textResult.setText(getResources().getText(R.string.CalResult)+" "+result.toString());
                            break;
                        }
                }
            }
            catch(NumberFormatException e){
                Toast.makeText(getApplicationContext(),R.string.notnumber,Toast.LENGTH_SHORT).show();

        }
    }
}
