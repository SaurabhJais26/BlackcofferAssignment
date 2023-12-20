package com.example.blackcofferassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RefineActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    ImageView back_button;
    SeekBar distanceSeekbar;
//    TextView toolTip;
    Button saveExplore,coffeeButton,businessButton,hobbiesButton,friendshipButton,moviesButton,diningButton,datingButton,matrimonyButton;
    private TextView tooltip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);
        distanceSeekbar = findViewById(R.id.seekBar);
        tooltip = findViewById(R.id.tooltip);
        distanceSeekbar.setOnSeekBarChangeListener(this);

        Spinner availabilitySpinner = findViewById(R.id.availability_spinner);
        String[] availabilityOptions = {"Available | Hey Let Us Connect", "Away | Stay Discrete And Watch", "Busy | Do Not Disturb I will catch up later", "SOS | Emergency! Need Assistance! Help"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, availabilityOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        availabilitySpinner.setAdapter(adapter);

        availabilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle item selection here
                String selectedOption = availabilityOptions[position];
                // Do something with the selected option
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RefineActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });

        saveExplore = findViewById(R.id.saveButton);
        saveExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RefineActivity.this,ExploreActivity.class);
                startActivity(intent);
            }
        });



        coffeeButton = findViewById(R.id.coffee_button);
        businessButton = findViewById(R.id.business_button);
        hobbiesButton = findViewById(R.id.hobbies_button);
        friendshipButton = findViewById(R.id.friendship_button);
        moviesButton = findViewById(R.id.movies_button);
        diningButton = findViewById(R.id.dining_button);
        datingButton = findViewById(R.id.dating_button);
        matrimonyButton = findViewById(R.id.matrimony_button);


        setupToggleButton(coffeeButton,R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(businessButton, R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(hobbiesButton, R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(friendshipButton, R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(moviesButton, R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(diningButton, R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(datingButton, R.drawable.selected_button_background, R.drawable.default_button_background);
        setupToggleButton(matrimonyButton, R.drawable.selected_button_background, R.drawable.default_button_background);

        TextInputEditText editTextStatus = findViewById(R.id.editTextStatus);
        final TextView characterCount = findViewById(R.id.characterCount);

        editTextStatus.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int currentCount = s.length();
                characterCount.setText(currentCount + "/250");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private void setupToggleButton(final Button button, final int selectedColor, final int defaultColor) {
        button.setTag(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = (boolean) button.getTag();
                isSelected = !isSelected; // Toggle the state
                button.setTag(isSelected);

                if (isSelected) {
                    button.setBackgroundResource(selectedColor);
                    button.setTextColor(getResources().getColor(R.color.white));
                } else {
                    button.setBackgroundResource(defaultColor);
                    button.setTextColor(getResources().getColor(R.color.textColor));
                }
            }
        });
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tooltip.setText(String.valueOf(progress));
        int thumbX = (int) (seekBar.getThumb().getBounds().exactCenterX() + seekBar.getX());
        int tooltipX = thumbX - (tooltip.getWidth() / 2);
        tooltip.setX(tooltipX);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tooltip.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}