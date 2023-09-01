package in.edu.svecw.fastaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private static final String SMS_MESSAGE = "Emergency! Please help!"; // Change this to your emergency message
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    public void sendSOS(View view) {
        EditText editText=findViewById(R.id.emergencyNumberEditText);
        String PHONE_NUMBER=editText.getText().toString();

        Toast.makeText(getApplicationContext(),"Emergency message sent!",Toast.LENGTH_SHORT).show();
        // Make a phone call to the emergency number
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + PHONE_NUMBER));
        startActivity(callIntent);

        PendingIntent sentIntent = PendingIntent.getBroadcast(getApplicationContext(),0,new Intent("SMS_SENT"),0);
        // Send an SMS message to the emergency number
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(PHONE_NUMBER, null, SMS_MESSAGE, null, null);
    }
}

