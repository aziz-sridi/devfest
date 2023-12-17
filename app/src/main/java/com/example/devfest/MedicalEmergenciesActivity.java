package com.example.devfest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MedicalEmergenciesActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_VOICE_RECORDING = 2;
    private static final int REQUEST_TEXT_INPUT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_emergencies);

        // Initialize views
        Button btnBack = findViewById(R.id.btnBack);
        Button btnCamera = findViewById(R.id.btnCamera);
        Button btnVoiceRecording = findViewById(R.id.btnVoiceRecording);
        Button btnTextInput = findViewById(R.id.btnTextInput);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(MedicalEmergenciesActivity.this, CameraActivity.class);
                startActivityForResult(cameraIntent, REQUEST_CAMERA);
            }
        });

        btnVoiceRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voiceRecordingIntent = new Intent(MedicalEmergenciesActivity.this, VoiceRecordingActivity.class);
                startActivityForResult(voiceRecordingIntent, REQUEST_VOICE_RECORDING);
            }
        });

       }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Handle results from different activities
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAMERA:

                    break;
                case REQUEST_VOICE_RECORDING:

                    break;
                case REQUEST_TEXT_INPUT:
                    break;
            }
        }
    }
}
