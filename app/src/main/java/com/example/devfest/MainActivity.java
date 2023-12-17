package com.example.devfest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardMedicalEmergencies = findViewById(R.id.cardMedicalEmergencies);
        CardView cardBombAlert = findViewById(R.id.cardBombAlert);
        CardView cardAttackAlert = findViewById(R.id.cardAttackAlert);
        CardView cardSafestRoute = findViewById(R.id.cardSafestRoute);

        // Set click listeners for CardViews
        cardMedicalEmergencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MedicalEmergenciesActivity.class));
            }
        });

        cardBombAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Bomb Alert
                showConfirmationDialog("Bomb Alert", "Have there been a bomb?");
            }
        });

        cardAttackAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Attack Alert
                showConfirmationDialog("Attack Alert", "Has there been an attack?");
            }
        });

        cardSafestRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Safest Route
                startActivity(new Intent(MainActivity.this, SafestRouteActivity.class));
            }
        });
    }

    private void showConfirmationDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }
}
