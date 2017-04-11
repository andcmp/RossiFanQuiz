package com.example.android.rossifanquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    RadioGroup birthGroup;
    RadioGroup yamahaYearGroup;
    RadioGroup titlesGroup;
    RadioGroup liveryGroup;

    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        birthGroup = (RadioGroup) findViewById(R.id.birthGroup);
        yamahaYearGroup = (RadioGroup) findViewById(R.id.yamahaYearGroup);
        titlesGroup = (RadioGroup) findViewById(R.id.titlesGroup);
        liveryGroup = (RadioGroup) findViewById(R.id.liveryGroup);

    }

    public void submitQuiz(View view) {
        // Question 1: Birth Date
        //Check if there's any answer
        if(birthGroup.getCheckedRadioButtonId() != -1) {
            RadioButton radioBirthYear = (RadioButton) birthGroup.findViewById(birthGroup.getCheckedRadioButtonId());
            String birthYear = radioBirthYear.getText().toString();
            if (birthYear.equals("1979")) {
                points = points + 1;
            }
        }

        // Question 2: RaceNumber
        EditText raceNumberField = (EditText) findViewById(R.id.raceNumberText);
        String raceNumber = raceNumberField.getText().toString();
        if (raceNumber.equals("46")) {
            points = points + 1;
        }

        // Question 3: NickNames
        CheckBox nicknameCheckbox1 = (CheckBox) findViewById(R.id.nickCheckBox_1);
        boolean theDoctor = nicknameCheckbox1.isChecked();

        CheckBox nicknameCheckbox2 = (CheckBox) findViewById(R.id.nickCheckBox_2);
        boolean theManiac = nicknameCheckbox2.isChecked();

        CheckBox nicknameCheckbox3 = (CheckBox) findViewById(R.id.nickCheckBox_3);
        boolean theGoat = nicknameCheckbox3.isChecked();

        CheckBox nicknameCheckbox4 = (CheckBox) findViewById(R.id.nickCheckBox_4);
        boolean Capirex = nicknameCheckbox4.isChecked();

        if (theDoctor == true && theGoat == true && theManiac == false && Capirex == false) {
            points = points + 1;
        }

        // Question 4: Yamaha Year
        //Check if there's any answer
        if (yamahaYearGroup.getCheckedRadioButtonId() != -1) {
            RadioButton radioYamahaYear = (RadioButton) yamahaYearGroup.findViewById(yamahaYearGroup.getCheckedRadioButtonId());
            String yamahaYear = radioYamahaYear.getText().toString();
            if (yamahaYear.equals("2004")) {
                points = points + 1;
            }
        }

        //Question 5: World Championship Titles
        //Check if there's any answer
        if (titlesGroup.getCheckedRadioButtonId() != -1) {
            RadioButton radioTitles = (RadioButton) titlesGroup.findViewById(titlesGroup.getCheckedRadioButtonId());
            String titles = radioTitles.getText().toString();
            if (titles.equals("9")) {
                points = points + 1;
            }
        }

        //Question 6: Teams
        CheckBox teamHonda = (CheckBox) findViewById(R.id.teamHonda);
        boolean honda = teamHonda.isChecked();

        CheckBox teamSuzuki = (CheckBox) findViewById(R.id.teamSuzuki);
        boolean suzuki = teamSuzuki.isChecked();

        CheckBox teamDucati = (CheckBox) findViewById(R.id.teamDucati);
        boolean ducati = teamDucati.isChecked();

        CheckBox teamYamaha = (CheckBox) findViewById(R.id.teamYamaha);
        boolean yamaha = teamYamaha.isChecked();

        if (honda == true && ducati == true && yamaha == true && suzuki == false) {
            points = points + 1;
        }

        //Question 7: Livery
        //Check if there's any answer
        if (liveryGroup.getCheckedRadioButtonId() != -1) {
            RadioButton radioLivery = (RadioButton) findViewById(liveryGroup.getCheckedRadioButtonId());
            String livery = radioLivery.getText().toString();
            if (livery.equals("2007 Assen")) {
                points = points + 1;
            }
        }

        // Question 8: Jorge
        EditText jorgeField = (EditText) findViewById(R.id.rivals);
        String jorge = jorgeField.getText().toString();
        if (jorge.toLowerCase().contains("lorenzo")) {
            points = points + 1;
        }

        // Question 9: Player Name
        EditText playerField = (EditText) findViewById(R.id.player);
        String player = playerField.getText().toString();

        Toast.makeText(ScrollingActivity.this, getString(R.string.toast_message, player, points), Toast.LENGTH_SHORT).show();
        points = 0;
    }

    public void reset (View view) {
        //Clear Birtday Radio Button
        birthGroup.clearCheck();
        //Clear Race Number EditText
        EditText raceNumberField = (EditText) findViewById(R.id.raceNumberText);
        raceNumberField.setText("");
        //Clear NickName Checkboxes
        CheckBox nicknameCheckbox1 = (CheckBox) findViewById(R.id.nickCheckBox_1);
        if (nicknameCheckbox1.isChecked()) {
            nicknameCheckbox1.setChecked(false);
        }
        CheckBox nicknameCheckbox2 = (CheckBox) findViewById(R.id.nickCheckBox_2);
        if (nicknameCheckbox2.isChecked()) {
            nicknameCheckbox1.setChecked(false);
        }
        CheckBox nicknameCheckbox3 = (CheckBox) findViewById(R.id.nickCheckBox_3);
        if (nicknameCheckbox3.isChecked()) {
            nicknameCheckbox3.setChecked(false);
        }
        CheckBox nicknameCheckbox4 = (CheckBox) findViewById(R.id.nickCheckBox_4);
        if (nicknameCheckbox4.isChecked()) {
            nicknameCheckbox4.setChecked(false);
        }
        //Clear Yamaha year Radio Button
        yamahaYearGroup.clearCheck();
        //Cleat Titles Radio Button
        titlesGroup.clearCheck();
        //Clear Team Checkboxes
        CheckBox teamHonda = (CheckBox) findViewById(R.id.teamHonda);
        if (teamHonda.isChecked()) {
            teamHonda.setChecked(false);
        }
        CheckBox teamSuzuki = (CheckBox) findViewById(R.id.teamSuzuki);
        if (teamSuzuki.isChecked()) {
            teamSuzuki.setChecked(false);
        }
        CheckBox teamDucati = (CheckBox) findViewById(R.id.teamDucati);
        if (teamDucati.isChecked()) {
            teamDucati.setChecked(false);
        }
        CheckBox teamYamaha = (CheckBox) findViewById(R.id.teamYamaha);
        if (teamYamaha.isChecked()) {
            teamYamaha.setChecked(false);
        }
        //Clear Livery Radio Button
        liveryGroup.clearCheck();
        //Clear Rival EidtText
        EditText jorgeField = (EditText) findViewById(R.id.rivals);
        jorgeField.setText("");
        //Clear Player EidtText
        EditText playerField = (EditText) findViewById(R.id.player);
        playerField.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
