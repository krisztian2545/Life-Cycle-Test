package com.textgame.lifecycletests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ItsMe extends AppCompatActivity {

    private TextView welcomeMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_its_me);

        welcomeMess = findViewById(R.id.textView);

//        if(getIntent().getStringExtra("message") != null) {
//            String message = getIntent().getStringExtra("message");
//            welcomeMess.setText(message);
//            Toast.makeText(ItsMe.this, "no: " + getIntent().getIntExtra("no", 0), Toast.LENGTH_LONG ).show();
//        }
        
        Bundle extras = getIntent().getExtras();
        
        if(extras != null) {
            welcomeMess.setText(extras.getString("message"));
            Toast.makeText(ItsMe.this, "nooooooooooooo: " + extras.getInt("no"), Toast.LENGTH_LONG ).show();
        }

        // if you want to return data to the activity that started this
        welcomeMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("wave_back", "hi");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
