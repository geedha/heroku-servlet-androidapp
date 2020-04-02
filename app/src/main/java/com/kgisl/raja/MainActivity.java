package com.kgisl.raja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id,name;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText)findViewById(R.id.id);
        name = (EditText)findViewById(R.id.name);
        add = (Button)findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AddStudentTask task = new AddStudentTask();
                task.execute(id.getText().toString(),name.getText().toString());
                Toast.makeText(getApplicationContext(),"Doneee",Toast.LENGTH_LONG).show();
            }
        });
    }
}
