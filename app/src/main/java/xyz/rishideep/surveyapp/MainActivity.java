package xyz.rishideep.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import xyz.rishideep.surveyapp.Auth.AccountSettings;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button bt_submit;
    RadioButton radioButton;

    //Question 1
    TextView tv_question1;
    EditText et_answer1;
    String tv_question1_StringEncode, et_answer1_String;

    //Question 2
    TextView tv_question2;
    EditText et_answer2;
    String tv_question2_StringEncode, et_answer2_String;

    //Question 3
    TextView tv_question3;
    RadioGroup rg_3;
    String tv_question3_StringEncode, rb_answer3_String;

    //Question 4
    TextView tv_question4;
    RadioGroup rg_4;
    String tv_question4_StringEncode, rb_answer4_String;

    //Question 5
    TextView tv_question5;
    EditText et_answer5;
    String tv_question5_StringEncode, et_answer5_String;

    //Question 6
    TextView tv_question6;
    EditText et_answer6;
    String tv_question6_StringEncode, et_answer6_String;

    //Question 7
    TextView tv_question7;
    EditText et_answer7_child1, et_answer7_child2, et_answer7_child3, et_answer7_others;
    EditText et_answer7_age1, et_answer7_age2, et_answer7_age3, et_answer7_ageOthers;
    String tv_question7_StringEncode;
    String et_answer7_child1_String, et_answer7_child2_String, et_answer7_child3_String, et_answer7_others_String;
    String et_answer7_age1_String, et_answer7_age2_String, et_answer7_age3_String, et_answer7_ageOthers_String;

    //Question 8
    TextView tv_question8;
    RadioGroup rg_8;
    EditText et_answer8_male, et_answer8_female;
    String tv_question8_StringEncode, rb_answer8_String, et_answer8_male_String, et_answer8_female_String;

    //Question 9
    TextView tv_question9;
    EditText et_answer9_motherName, et_answer9_edStatusMN, et_answer9_fatherName, et_answer9_edStatusFN, et_answer9_gaurdianName, et_answer9_edStatusGN;
    String tv_question9_StringEncode;
    String et_answer9_motherName_String, et_answer9_fatherName_String, et_answer9_gaurdianName_String;
    String et_answer9_edStatusMN_String, et_answer9_edStatusFN_String, et_answer9_edStatusGN_String;

//    //Question 10
//    TextView tv_question10;
//    String tv_question10_StringEncode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        et_answer1 = findViewById(R.id.et_answer1);

        bt_submit = findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_answer1_String = et_answer1.getText().toString();
                databaseReference = firebaseDatabase.getReference(et_answer1_String);
                if (et_answer1_String.isEmpty() || et_answer1_String.length() == 0 || et_answer1_String.equals("") || et_answer1_String == null) {
                    databaseReference = firebaseDatabase.getReference().push();
                }
                question01();
                question02();
                question03();
                question04();
                question05();
                question06();
                question07();
                question08();
                question09();
            }
        });
    }

    void question01() {
        tv_question1 = findViewById(R.id.tv_question1);
        tv_question1_StringEncode = EncodeString(tv_question1.getText().toString());

        // NAME OF THE STUDENT
        et_answer1 = findViewById(R.id.et_answer1);
        et_answer1_String = et_answer1.getText().toString();
        if (et_answer1_String.isEmpty()) {
            databaseReference.child(tv_question1_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question1_StringEncode).setValue(et_answer1_String);
        }
    }

    void question02() {
        tv_question2 = findViewById(R.id.tv_question2);
        tv_question2_StringEncode = EncodeString(tv_question2.getText().toString());

        // AGE OF THE STUDENT
        et_answer2 = findViewById(R.id.et_answer2);
        et_answer2_String = et_answer2.getText().toString();
        if (et_answer2_String.isEmpty()) {
            databaseReference.child(tv_question2_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question2_StringEncode).setValue(et_answer2_String);
        }
    }

    void question03() {
        tv_question3 = findViewById(R.id.tv_question3);
        tv_question3_StringEncode = EncodeString(tv_question3.getText().toString());

        // GENDER
        rg_3 = findViewById(R.id.rg_3);
        if (rg_3.getCheckedRadioButtonId() != -1) {
            int selectedId3 = rg_3.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId3);
            rb_answer3_String = radioButton.getText().toString();
            databaseReference.child(tv_question3_StringEncode).setValue(rb_answer3_String);
        } else {
            databaseReference.child(tv_question3_StringEncode).setValue("");
        }
    }

    void question04() {
        tv_question4 = findViewById(R.id.tv_question4);
        tv_question4_StringEncode = EncodeString(tv_question4.getText().toString());

        // CASTE
        rg_4 = findViewById(R.id.rg_4);
        if (rg_4.getCheckedRadioButtonId() != -1) {
            int selectedId4 = rg_4.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId4);
            rb_answer4_String = radioButton.getText().toString();
            databaseReference.child(tv_question4_StringEncode).setValue(rb_answer4_String);
        } else {
            databaseReference.child(tv_question4_StringEncode).setValue("");
        }
    }

    void question05() {
        tv_question5 = findViewById(R.id.tv_question5);
        tv_question5_StringEncode = EncodeString(tv_question5.getText().toString());

        //CURRENT EDUCATION / EDUCATION RECEIVED
        et_answer5 = findViewById(R.id.et_answer5);
        et_answer5_String = et_answer5.getText().toString();
        if (et_answer5_String.isEmpty()) {
            databaseReference.child(tv_question5_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question5_StringEncode).setValue(et_answer5_String);
        }
    }

    void question06() {
        tv_question6 = findViewById(R.id.tv_question6);
        tv_question6_StringEncode = EncodeString(tv_question6.getText().toString());

        //PLACE OF SCHOOL
        et_answer6 = findViewById(R.id.et_answer6);
        et_answer6_String = et_answer6.getText().toString();
        if (et_answer6_String.isEmpty()) {
            databaseReference.child(tv_question6_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question6_StringEncode).setValue(et_answer6_String);
        }
    }

    void question07() {
        tv_question7 = findViewById(R.id.tv_question7);
        tv_question7_StringEncode = EncodeString(tv_question7.getText().toString());

        //CHILD 1
        et_answer7_child1 = findViewById(R.id.et_answer7_child1);
        et_answer7_child1_String = et_answer7_child1.getText().toString();
        if (et_answer7_child1_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").setValue(et_answer7_child1_String);
        }

        //AGE (CHILD 1)
        et_answer7_age1 = findViewById(R.id.et_answer7_age1);
        et_answer7_age1_String = et_answer7_age1.getText().toString();
        if (et_answer7_age1_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Age (Child 1)").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Age (Child 1)").setValue(et_answer7_age1_String);
        }

        //CHILD 2
        et_answer7_child2 = findViewById(R.id.et_answer7_child2);
        et_answer7_child2_String = et_answer7_child2.getText().toString();
        if (et_answer7_child2_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").setValue(et_answer7_child2_String);
        }

        //AGE (CHILD 2)
        et_answer7_age2 = findViewById(R.id.et_answer7_age2);
        et_answer7_age2_String = et_answer7_age2.getText().toString();
        if (et_answer7_age2_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Age (Child 2)").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Age (Child 2)").setValue(et_answer7_age2_String);
        }

        //CHILD 3
        et_answer7_child3 = findViewById(R.id.et_answer7_child3);
        et_answer7_child3_String = et_answer7_child3.getText().toString();
        if (et_answer7_child3_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").setValue(et_answer7_child3_String);
        }

        //AGE (CHILD 3)
        et_answer7_age3 = findViewById(R.id.et_answer7_age3);
        et_answer7_age3_String = et_answer7_age3.getText().toString();
        if (et_answer7_age3_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Age (Child 3)").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Age (Child 3)").setValue(et_answer7_age3_String);
        }

        //OTHERS
        et_answer7_others = findViewById(R.id.et_answer7_others);
        et_answer7_others_String = et_answer7_others.getText().toString();
        if (et_answer7_others_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Others").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Others").setValue(et_answer7_others_String);
        }

        //AGE (OTHERS)
        et_answer7_ageOthers = findViewById(R.id.et_answer7_ageOthers);
        et_answer7_ageOthers_String = et_answer7_ageOthers.getText().toString();
        if (et_answer7_ageOthers_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Age (Others)").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Age (Others)").setValue(et_answer7_ageOthers_String);
        }
    }

    void question08() {
        tv_question8 = findViewById(R.id.tv_question8);
        tv_question8_StringEncode = EncodeString(tv_question8.getText().toString());

        //YES (or) NO
        rg_8 = findViewById(R.id.rg_8);
        if (rg_8.getCheckedRadioButtonId() != -1) {
            int selectedId3 = rg_8.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId3);
            rb_answer8_String = radioButton.getText().toString();
            databaseReference.child(tv_question8_StringEncode).child("Yes (or) No").setValue(rb_answer8_String);
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Yes (or) No").setValue("");
        }

        //MALE (nos.)
        et_answer8_male = findViewById(R.id.et_answer8_male);
        et_answer8_male_String = et_answer8_male.getText().toString();
        if (et_answer8_male_String.isEmpty()) {
            databaseReference.child(tv_question8_StringEncode).child("Male (nos)").setValue("");
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Male (nos)").setValue(et_answer8_male_String);
        }

        //FEMALE (nos.)
        et_answer8_female = findViewById(R.id.et_answer8_female);
        et_answer8_female_String = et_answer8_female.getText().toString();
        if (et_answer8_female_String.isEmpty()) {
            databaseReference.child(tv_question8_StringEncode).child("Female (nos)").setValue("");
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Female (nos)").setValue(et_answer8_female_String);
        }
    }

    void question09() {
        tv_question9 = findViewById(R.id.tv_question9);
        tv_question9_StringEncode = EncodeString(tv_question9.getText().toString());

        //MOTHER NAME
        et_answer9_motherName = findViewById(R.id.et_answer9_motherName);
        et_answer9_motherName_String = et_answer9_motherName.getText().toString();
        if (et_answer9_motherName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Mother Name").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Mother Name").setValue(et_answer9_motherName_String);
        }

        //EDUCATIONAL STATUS (MOTHER)
        et_answer9_edStatusMN = findViewById(R.id.et_answer9_edStatusMN);
        et_answer9_edStatusMN_String = et_answer9_edStatusMN.getText().toString();
        if (et_answer9_edStatusMN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Educational Status (Mother)").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Educational Status (Mother)").setValue(et_answer9_edStatusMN_String);
        }

        //FATHER NAME
        et_answer9_fatherName = findViewById(R.id.et_answer9_fatherName);
        et_answer9_fatherName_String = et_answer9_fatherName.getText().toString();
        if (et_answer9_fatherName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Father Name").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Father Name").setValue(et_answer9_fatherName_String);
        }

        //EDUCATIONAL STATUS (FATHER)
        et_answer9_edStatusFN = findViewById(R.id.et_answer9_edStatusFN);
        et_answer9_edStatusFN_String = et_answer9_edStatusFN.getText().toString();
        if (et_answer9_edStatusFN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Educational Status (Father)").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Educational Status (Father)").setValue(et_answer9_edStatusFN_String);
        }

        //GUARDIAN NAME
        et_answer9_gaurdianName = findViewById(R.id.et_answer9_gaurdianName);
        et_answer9_gaurdianName_String = et_answer9_gaurdianName.getText().toString();
        if (et_answer9_gaurdianName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Guardian Name").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Guardian Name").setValue(et_answer9_gaurdianName_String);
        }

        //EDUCATIONAL STATUS (FATHER)
        et_answer9_edStatusGN = findViewById(R.id.et_answer9_edStatusGN);
        et_answer9_edStatusGN_String = et_answer9_edStatusGN.getText().toString();
        if (et_answer9_edStatusGN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Educational Status (Guardian)").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Educational Status (Guardian)").setValue(et_answer9_edStatusGN_String);
        }
    }

    public static String EncodeString(String string) {
        return string.replaceAll("[./]", ",");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.account_settings) {
            Intent intent = new Intent(MainActivity.this, AccountSettings.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
