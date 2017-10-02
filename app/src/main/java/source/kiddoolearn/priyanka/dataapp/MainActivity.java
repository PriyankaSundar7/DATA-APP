package source.kiddoolearn.priyanka.dataapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2,b3;
    DataManipulate ds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds=new DataManipulate(this);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e1.requestFocus();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result=ds.insertData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                if(result==true)
                {
                    Toast.makeText(MainActivity.this, "Successfull",Toast.LENGTH_LONG ).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Unsuccessfull", Toast.LENGTH_LONG).show();
                }

            }


        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=ds.getData();
                if(res.getCount()==0)
                    showAlert("Error","No data to display");
                StringBuffer buff=new StringBuffer();
                while(res.moveToNext())
                {
                    buff.append("FIRSTNAME:"+res.getString(1)+"\n");
                    buff.append("LASTNAME:"+res.getString(2)+"\n");
                    buff.append("ID:"+res.getString(0)+"\n");

                    // buff.append("MARKS:"+res.getString(3)+"\n");
                }
                showAlert("error",buff.toString());
            }
        });



    }
    public void showAlert(String title,String msg)
    {
        AlertDialog.Builder dbr=new AlertDialog.Builder(this);
        dbr.setTitle(title);
        dbr.setMessage(msg);
        dbr.show();


    }
}
