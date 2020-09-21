package com.textgame.lifecycletests;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    private static final String TAG = "Cycle";
    private final int REQUEST_CODE = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String logText = "A long time ago in a galaxy far, far away....";

        Log.d(TAG, "onCreate: " + logText);
        Toast.makeText(this, logText, Toast.LENGTH_SHORT).show();

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString().trim();

                if(!s.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, ItsMe.class);

                    intent.putExtra("message", s);
                    intent.putExtra("no", 71);
                    //startActivity(intent); if you don't expect to receive data back
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "You fucked up!!!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE) {
            if( resultCode == RESULT_OK) {
                assert data != null;
                String m = data.getStringExtra("wave_back").trim();
                Toast.makeText(MainActivity.this, m, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        String logText = "Troubled, you look, Skywalker...";

        Log.d(TAG, "onStart: " + logText);
        Toast.makeText(this, "Troubled, you look, Skywalker...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String logText = "New Hope";

        Log.d(TAG, "onResume: " + logText);
        Toast.makeText(this, logText, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        String logText = "I have a bad feeling about this...";

        Log.d(TAG, "onPause: " + logText);
        Toast.makeText(this, logText, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        String logText = "Luke, I'm your father";

        Log.d(TAG, "onStop: " + logText);
        Toast.makeText(this, logText, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String logText = "There are always two, a master and an apprentice.";

        Log.d(TAG, "onDestroy: " + logText);
        Toast.makeText(this, logText, Toast.LENGTH_SHORT).show();
    }
}
