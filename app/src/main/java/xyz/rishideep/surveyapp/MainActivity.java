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

    //  init. for QUESTION 1
    TextView tv_question1;
    EditText et_answer1;
    String tv_question1_StringEncode, et_answer1_String;

    //  init. for QUESTION 2
    TextView tv_question2;
    EditText et_answer2;
    String tv_question2_StringEncode, et_answer2_String;

    //  init. for QUESTION 3
    TextView tv_question3;
    RadioGroup rg_3;
    String tv_question3_StringEncode, rb_answer3_String;

    //  init. for QUESTION 4
    TextView tv_question4;
    RadioGroup rg_4;
    String tv_question4_StringEncode, rb_answer4_String;

    //  init. for QUESTION 5
    TextView tv_question5;
    EditText et_answer5;
    String tv_question5_StringEncode, et_answer5_String;

    //  init. for QUESTION 6
    TextView tv_question6;
    EditText et_answer6;
    String tv_question6_StringEncode, et_answer6_String;

    //  init. for QUESTION 7
    TextView tv_question7;
    EditText et_answer7_child1, et_answer7_child2, et_answer7_child3, et_answer7_others;
    EditText et_answer7_age1, et_answer7_age2, et_answer7_age3, et_answer7_ageOthers;
    String tv_question7_StringEncode;
    String et_answer7_child1_String, et_answer7_child2_String, et_answer7_child3_String, et_answer7_others_String;
    String et_answer7_age1_String, et_answer7_age2_String, et_answer7_age3_String, et_answer7_ageOthers_String;

    //  init. for QUESTION 8
    TextView tv_question8;
    RadioGroup rg_8;
    EditText et_answer8_male, et_answer8_female;
    String tv_question8_StringEncode, rb_answer8_String, et_answer8_male_String, et_answer8_female_String;

    //  init. for QUESTION 9
    TextView tv_question9;
    EditText et_answer9_motherName, et_answer9_edStatusMN, et_answer9_fatherName, et_answer9_edStatusFN, et_answer9_gaurdianName, et_answer9_edStatusGN;
    String tv_question9_StringEncode;
    String et_answer9_motherName_String, et_answer9_fatherName_String, et_answer9_gaurdianName_String;
    String et_answer9_edStatusMN_String, et_answer9_edStatusFN_String, et_answer9_edStatusGN_String;

    //  init. for QUESTION 10
    TextView tv_question10;
    String tv_question10_StringEncode;
    //  Father
    TextView tv_question10_father_noe, tv_question10_father_sm;
    EditText et_answer10_father_mi;
    RadioGroup rg_10_father_noe, rg_10_father_sm;
    String tv_question10_father_noe_StringEncode, tv_question10_father_sm_StringEncode;
    String rb_answer10_father_noe_String, rb_answer10_father_sm_String, et_answer10_father_mi_String;
    //  Mother
    TextView tv_question10_mother_noe, tv_question10_mother_sm;
    EditText et_answer10_mother_mi;
    RadioGroup rg_10_mother_noe, rg_10_mother_sm;
    String tv_question10_mother_noe_StringEncode, tv_question10_mother_sm_StringEncode;
    String rb_answer10_mother_noe_String, rb_answer10_mother_sm_String, et_answer10_mother_mi_String;
    //  Person1
    TextView tv_question10_person1_noe, tv_question10_person1_sm;
    EditText et_answer10_person1_mi;
    RadioGroup rg_10_person1_noe, rg_10_person1_sm;
    String tv_question10_person1_noe_StringEncode, tv_question10_person1_sm_StringEncode;
    String rb_answer10_person1_noe_String, rb_answer10_person1_sm_String, et_answer10_person1_mi_String;
    //  Person1
    TextView tv_question10_person2_noe, tv_question10_person2_sm;
    EditText et_answer10_person2_mi;
    RadioGroup rg_10_person2_noe, rg_10_person2_sm;
    String tv_question10_person2_noe_StringEncode, tv_question10_person2_sm_StringEncode;
    String rb_answer10_person2_noe_String, rb_answer10_person2_sm_String, et_answer10_person2_mi_String;
    //  Person1
    TextView tv_question10_person3_noe, tv_question10_person3_sm;
    EditText et_answer10_person3_mi;
    RadioGroup rg_10_person3_noe, rg_10_person3_sm;
    String tv_question10_person3_noe_StringEncode, tv_question10_person3_sm_StringEncode;
    String rb_answer10_person3_noe_String, rb_answer10_person3_sm_String, et_answer10_person3_mi_String;

    //  init. for QUESTION 11
    TextView tv_question11;
    RadioGroup rg_11;
    String tv_question11_StringEncode, rb_answer11_String;

    //  init. for QUESTION 12
    TextView tv_question12;
    RadioGroup rg_12;
    String tv_question12_StringEncode, rb_answer12_String;

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
                question01();   //  01. NAME OF THE STUDENT
                question02();   //  02. AGE OF THE STUDENT
                question03();   //  03. GENDER
                question04();   //  04. CASTE
                question05();   //  05. CURRENT EDUCATION / EDUCATION RECEIVED
                question06();   //  06. PLACE OF THE SCHOOL
                question07();   //  07. NO OF SCHOOL GOING CHILDREN IN THE FAMILY
                question08();   //  08. ARE THERE ANY SCHOOL DROPOUT IN TH FAMILY? (CHILDREN)
                question09();   //  09. EDUCATION STATUS OF THE PARENTS
                question10();   //  10. OCCUPATION AND INCOME OF THE PARENTS AND FAMILY MEMBERS
                question11();   //  11. OWNERSHIP OF THE HOUSE
                question12();   //  12. TYPE OF HOUSE
            }
        });
    }

    void question01() {
        tv_question1 = findViewById(R.id.tv_question1);
        tv_question1_StringEncode = EncodeString(tv_question1.getText().toString());

        //  NAME OF THE STUDENT
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

        //  AGE OF THE STUDENT
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

        //  GENDER
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

        //  CASTE
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

        //  CURRENT EDUCATION / EDUCATION RECEIVED
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

        //  PLACE OF SCHOOL
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

        //  CHILD 1
        et_answer7_child1 = findViewById(R.id.et_answer7_child1);
        et_answer7_child1_String = et_answer7_child1.getText().toString();
        if (et_answer7_child1_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Name").setValue(et_answer7_child1_String);
        }

        //  AGE (CHILD 1)
        et_answer7_age1 = findViewById(R.id.et_answer7_age1);
        et_answer7_age1_String = et_answer7_age1.getText().toString();
        if (et_answer7_age1_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Age").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Age").setValue(et_answer7_age1_String);
        }

        //  CHILD 2
        et_answer7_child2 = findViewById(R.id.et_answer7_child2);
        et_answer7_child2_String = et_answer7_child2.getText().toString();
        if (et_answer7_child2_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Name").setValue(et_answer7_child2_String);
        }

        //  AGE (CHILD 2)
        et_answer7_age2 = findViewById(R.id.et_answer7_age2);
        et_answer7_age2_String = et_answer7_age2.getText().toString();
        if (et_answer7_age2_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Age").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Age").setValue(et_answer7_age2_String);
        }

        //  CHILD 3
        et_answer7_child3 = findViewById(R.id.et_answer7_child3);
        et_answer7_child3_String = et_answer7_child3.getText().toString();
        if (et_answer7_child3_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Name").setValue(et_answer7_child3_String);
        }

        //  AGE (CHILD 3)
        et_answer7_age3 = findViewById(R.id.et_answer7_age3);
        et_answer7_age3_String = et_answer7_age3.getText().toString();
        if (et_answer7_age3_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Age").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Age").setValue(et_answer7_age3_String);
        }

        //  OTHERS
        et_answer7_others = findViewById(R.id.et_answer7_others);
        et_answer7_others_String = et_answer7_others.getText().toString();
        if (et_answer7_others_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Name").setValue(et_answer7_others_String);
        }

        //  AGE (OTHERS)
        et_answer7_ageOthers = findViewById(R.id.et_answer7_ageOthers);
        et_answer7_ageOthers_String = et_answer7_ageOthers.getText().toString();
        if (et_answer7_ageOthers_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Age").setValue("");
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Age").setValue(et_answer7_ageOthers_String);
        }
    }

    void question08() {
        tv_question8 = findViewById(R.id.tv_question8);
        tv_question8_StringEncode = EncodeString(tv_question8.getText().toString());

        //  YES (or) NO
        rg_8 = findViewById(R.id.rg_8);
        if (rg_8.getCheckedRadioButtonId() != -1) {
            int selectedId8 = rg_8.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId8);
            rb_answer8_String = radioButton.getText().toString();
            databaseReference.child(tv_question8_StringEncode).child("Yes (or) No").setValue(rb_answer8_String);
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Yes (or) No").setValue("");
        }

        //  MALE (nos.)
        et_answer8_male = findViewById(R.id.et_answer8_male);
        et_answer8_male_String = et_answer8_male.getText().toString();
        if (et_answer8_male_String.isEmpty()) {
            databaseReference.child(tv_question8_StringEncode).child("Male (nos)").setValue("");
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Male (nos)").setValue(et_answer8_male_String);
        }

        //  FEMALE (nos.)
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

        //  MOTHER NAME
        et_answer9_motherName = findViewById(R.id.et_answer9_motherName);
        et_answer9_motherName_String = et_answer9_motherName.getText().toString();
        if (et_answer9_motherName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Name").setValue(et_answer9_motherName_String);
        }

        //  EDUCATIONAL STATUS (MOTHER)
        et_answer9_edStatusMN = findViewById(R.id.et_answer9_edStatusMN);
        et_answer9_edStatusMN_String = et_answer9_edStatusMN.getText().toString();
        if (et_answer9_edStatusMN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Educational Status").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Educational Status").setValue(et_answer9_edStatusMN_String);
        }

        //  FATHER NAME
        et_answer9_fatherName = findViewById(R.id.et_answer9_fatherName);
        et_answer9_fatherName_String = et_answer9_fatherName.getText().toString();
        if (et_answer9_fatherName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Name").setValue(et_answer9_fatherName_String);
        }

        //  EDUCATIONAL STATUS (FATHER)
        et_answer9_edStatusFN = findViewById(R.id.et_answer9_edStatusFN);
        et_answer9_edStatusFN_String = et_answer9_edStatusFN.getText().toString();
        if (et_answer9_edStatusFN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Educational Status").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Educational Status").setValue(et_answer9_edStatusFN_String);
        }

        //  GUARDIAN NAME
        et_answer9_gaurdianName = findViewById(R.id.et_answer9_gaurdianName);
        et_answer9_gaurdianName_String = et_answer9_gaurdianName.getText().toString();
        if (et_answer9_gaurdianName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Name").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Name").setValue(et_answer9_gaurdianName_String);
        }

        //  EDUCATIONAL STATUS (FATHER)
        et_answer9_edStatusGN = findViewById(R.id.et_answer9_edStatusGN);
        et_answer9_edStatusGN_String = et_answer9_edStatusGN.getText().toString();
        if (et_answer9_edStatusGN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Educational Status").setValue("");
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Educational Status").setValue(et_answer9_edStatusGN_String);
        }
    }

    void question10() {
        tv_question10 = findViewById(R.id.tv_question10);
        tv_question10_StringEncode = EncodeString(tv_question10.getText().toString());

        //  FATHER
        //  NATURE OF EMPLOYMENT
        tv_question10_father_noe = findViewById(R.id.tv_question10_father_noe);
        tv_question10_father_noe_StringEncode = EncodeString(tv_question10_father_noe.getText().toString());
        rg_10_father_noe = findViewById(R.id.rg_10_father_noe);
        if (rg_10_father_noe.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_father_noe.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_father_noe_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Father").child(tv_question10_father_noe_StringEncode).setValue(rb_answer10_father_noe_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Father").child(tv_question10_father_noe_StringEncode).setValue("");
        }

        //  SALARY MODE
        tv_question10_father_sm = findViewById(R.id.tv_question10_father_sm);
        tv_question10_father_sm_StringEncode = EncodeString(tv_question10_father_sm.getText().toString());
        rg_10_father_sm = findViewById(R.id.rg_10_father_sm);
        if (rg_10_father_sm.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_father_sm.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_father_sm_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Father").child(tv_question10_father_sm_StringEncode).setValue(rb_answer10_father_sm_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Father").child(tv_question10_father_sm_StringEncode).setValue("");
        }

        //  MONTHLY INCOME
        et_answer10_father_mi = findViewById(R.id.et_answer10_father_mi);
        et_answer10_father_mi_String = et_answer10_father_mi.getText().toString();
        if (et_answer10_father_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Father").child("Monthly Income (Rs)").setValue("");
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Father").child("Monthly Income (Rs)").setValue(et_answer10_father_mi_String);
        }

        //  MOTHER
        //  NATURE OF EMPLOYMENT
        tv_question10_mother_noe = findViewById(R.id.tv_question10_mother_noe);
        tv_question10_mother_noe_StringEncode = EncodeString(tv_question10_mother_noe.getText().toString());
        rg_10_mother_noe = findViewById(R.id.rg_10_mother_noe);
        if (rg_10_mother_noe.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_mother_noe.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_mother_noe_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Mother").child(tv_question10_mother_noe_StringEncode).setValue(rb_answer10_mother_noe_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child(tv_question10_mother_noe_StringEncode).setValue("");
        }

        //  SALARY MODE
        tv_question10_mother_sm = findViewById(R.id.tv_question10_mother_sm);
        tv_question10_mother_sm_StringEncode = EncodeString(tv_question10_mother_sm.getText().toString());
        rg_10_mother_sm = findViewById(R.id.rg_10_mother_sm);
        if (rg_10_mother_sm.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_mother_sm.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_mother_sm_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Mother").child(tv_question10_mother_sm_StringEncode).setValue(rb_answer10_mother_sm_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child(tv_question10_mother_sm_StringEncode).setValue("");
        }

        //  MONTHLY INCOME
        et_answer10_mother_mi = findViewById(R.id.et_answer10_mother_mi);
        et_answer10_mother_mi_String = et_answer10_mother_mi.getText().toString();
        if (et_answer10_mother_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child("Monthly Income (Rs)").setValue("");
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child("Monthly Income (Rs)").setValue(et_answer10_mother_mi_String);
        }

        //  PERSON1
        //  NATURE OF EMPLOYMENT
        tv_question10_person1_noe = findViewById(R.id.tv_question10_person1_noe);
        tv_question10_person1_noe_StringEncode = EncodeString(tv_question10_person1_noe.getText().toString());
        rg_10_person1_noe = findViewById(R.id.rg_10_person1_noe);
        if (rg_10_person1_noe.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_person1_noe.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_person1_noe_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child(tv_question10_person1_noe_StringEncode).setValue(rb_answer10_person1_noe_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child(tv_question10_person1_noe_StringEncode).setValue("");
        }

        //  SALARY MODE
        tv_question10_person1_sm = findViewById(R.id.tv_question10_person1_sm);
        tv_question10_person1_sm_StringEncode = EncodeString(tv_question10_person1_sm.getText().toString());
        rg_10_person1_sm = findViewById(R.id.rg_10_person1_sm);
        if (rg_10_person1_sm.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_person1_sm.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_person1_sm_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child(tv_question10_person1_sm_StringEncode).setValue(rb_answer10_person1_sm_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child(tv_question10_person1_sm_StringEncode).setValue("");
        }

        //  MONTHLY INCOME
        et_answer10_person1_mi = findViewById(R.id.et_answer10_person1_mi);
        et_answer10_person1_mi_String = et_answer10_person1_mi.getText().toString();
        if (et_answer10_person1_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child("Monthly Income (Rs)").setValue("");
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child("Monthly Income (Rs)").setValue(et_answer10_person1_mi_String);
        }

        //  PERSON2
        //  NATURE OF EMPLOYMENT
        tv_question10_person2_noe = findViewById(R.id.tv_question10_person2_noe);
        tv_question10_person2_noe_StringEncode = EncodeString(tv_question10_person2_noe.getText().toString());
        rg_10_person2_noe = findViewById(R.id.rg_10_person2_noe);
        if (rg_10_person2_noe.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_person2_noe.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_person2_noe_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child(tv_question10_person2_noe_StringEncode).setValue(rb_answer10_person2_noe_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child(tv_question10_person2_noe_StringEncode).setValue("");
        }

        //  SALARY MODE
        tv_question10_person2_sm = findViewById(R.id.tv_question10_person2_sm);
        tv_question10_person2_sm_StringEncode = EncodeString(tv_question10_person2_sm.getText().toString());
        rg_10_person2_sm = findViewById(R.id.rg_10_person2_sm);
        if (rg_10_person2_sm.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_person2_sm.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_person2_sm_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child(tv_question10_person2_sm_StringEncode).setValue(rb_answer10_person2_sm_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child(tv_question10_person2_sm_StringEncode).setValue("");
        }

        //  MONTHLY INCOME
        et_answer10_person2_mi = findViewById(R.id.et_answer10_person2_mi);
        et_answer10_person2_mi_String = et_answer10_person2_mi.getText().toString();
        if (et_answer10_person2_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child("Monthly Income (Rs)").setValue("");
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child("Monthly Income (Rs)").setValue(et_answer10_person2_mi_String);
        }

        //  PERSON3
        //  NATURE OF EMPLOYMENT
        tv_question10_person3_noe = findViewById(R.id.tv_question10_person3_noe);
        tv_question10_person3_noe_StringEncode = EncodeString(tv_question10_person3_noe.getText().toString());
        rg_10_person3_noe = findViewById(R.id.rg_10_person3_noe);
        if (rg_10_person3_noe.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_person3_noe.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_person3_noe_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child(tv_question10_person3_noe_StringEncode).setValue(rb_answer10_person3_noe_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child(tv_question10_person3_noe_StringEncode).setValue("");
        }

        //  SALARY MODE
        tv_question10_person3_sm = findViewById(R.id.tv_question10_person3_sm);
        tv_question10_person3_sm_StringEncode = EncodeString(tv_question10_person3_sm.getText().toString());
        rg_10_person3_sm = findViewById(R.id.rg_10_person3_sm);
        if (rg_10_person3_sm.getCheckedRadioButtonId() != -1) {
            int selectedId10 = rg_10_person3_sm.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId10);
            rb_answer10_person3_sm_String = radioButton.getText().toString();
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child(tv_question10_person3_sm_StringEncode).setValue(rb_answer10_person3_sm_String);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child(tv_question10_person3_sm_StringEncode).setValue("");
        }

        //  MONTHLY INCOME
        et_answer10_person3_mi = findViewById(R.id.et_answer10_person3_mi);
        et_answer10_person3_mi_String = et_answer10_person3_mi.getText().toString();
        if (et_answer10_person3_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child("Monthly Income (Rs)").setValue("");
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child("Monthly Income (Rs)").setValue(et_answer10_person3_mi_String);
        }
    }

    void question11() {
        tv_question11 = findViewById(R.id.tv_question11);
        tv_question11_StringEncode = EncodeString(tv_question11.getText().toString());

        //  OWNERSHIP OF THE HOUSE
        rg_11 = findViewById(R.id.rg_11);
        if (rg_11.getCheckedRadioButtonId() != -1) {
            int selectedId11 = rg_11.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId11);
            rb_answer11_String = radioButton.getText().toString();
            databaseReference.child(tv_question11_StringEncode).setValue(rb_answer11_String);
        } else {
            databaseReference.child(tv_question11_StringEncode).setValue("");
        }
    }

    void question12() {
        tv_question12 = findViewById(R.id.tv_question12);
        tv_question12_StringEncode = EncodeString(tv_question12.getText().toString());

        //  TYPE OF HOUSE
        rg_12 = findViewById(R.id.rg_12);
        if (rg_12.getCheckedRadioButtonId() != -1) {
            int selectedId12 = rg_12.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId12);
            rb_answer12_String = radioButton.getText().toString();
            databaseReference.child(tv_question12_StringEncode).setValue(rb_answer12_String);
        } else {
            databaseReference.child(tv_question12_StringEncode).setValue("");
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
