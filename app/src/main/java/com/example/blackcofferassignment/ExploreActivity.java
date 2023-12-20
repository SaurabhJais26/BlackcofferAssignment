package com.example.blackcofferassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExploreActivity extends AppCompatActivity {

    TextView greetingText,addressText,refineText,profileName,profileAddress,profileDistance,profileInterests,profileAboutMe,profileName2,profileAddress2,profileDistance2,profileInterests2,profileAboutMe2;
    Button inviteButton;
    ImageView filterIcon,menuIcon,refineIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        refineIcon = findViewById(R.id.refineIcon);

        refineIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExploreActivity.this,RefineActivity.class);
                startActivity(intent);
            }
        });

    }
}