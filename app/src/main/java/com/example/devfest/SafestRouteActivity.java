package com.example.devfest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SafestRouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safest_route);

        // Dummy shelter data for demonstration
        List<Shelter> shelters = new ArrayList<>();
        shelters.add(new Shelter("Shelter 1", 37.7749, -122.4194));
        shelters.add(new Shelter("Shelter 2", 34.0522, -118.2437));

        // Set up RecyclerView for Safest Route
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SafestRouteAdapter adapter = new SafestRouteAdapter(shelters);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new SafestRouteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Shelter shelter) {
                openGoogleMaps(shelter.getLatitude(), shelter.getLongitude(), shelter.getName());
            }
        });
    }

    private void openGoogleMaps(double latitude, double longitude, String shelterName) {
        Uri gmmIntentUri = Uri.parse("geo:35.8,10.5?q=35.8,10.10");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        try {
            startActivity(mapIntent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            // Handle the exception
            Toast.makeText(getApplicationContext(), "Google Maps app not installed", Toast.LENGTH_SHORT).show();

            // If Google Maps is not installed, open the map URL in a browser
            String mapUrl = "https://www.google.com/maps/search/?api=1&query=pharmacies";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl));

            PackageManager packageManager = getPackageManager();
            if (browserIntent.resolveActivity(packageManager) != null) {
                startActivity(browserIntent);
            } else {
                Toast.makeText(getApplicationContext(), "No app available to handle the request", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
