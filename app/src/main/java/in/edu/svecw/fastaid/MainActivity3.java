package in.edu.svecw.fastaid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import in.edu.svecw.fastaid.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}