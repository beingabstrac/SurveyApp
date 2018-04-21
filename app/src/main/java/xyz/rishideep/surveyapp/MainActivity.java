package xyz.rishideep.surveyapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String android_id;
    Button bt_submit, bt_clearall;
    RadioButton radioButton;
    LinearLayout linearLayout;

    ImageView iv_i_socio_economic_status_01, iv_i_socio_economic_status_02, iv_tv_ii_utilization_of_the_student_welfare_schemes_01, iv_tv_ii_utilization_of_the_student_welfare_schemes_02, iv_tv_iii_socio_economic_growth_of_family_01, iv_tv_iii_socio_economic_growth_of_family_02;
    LinearLayout ll_i_socio_economic_status, ll_ii_utilization_of_the_student_welfare_schemes, ll_iii_socio_economic_growth_of_family;

    //  init. for QUESTIONS
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

    //  init. for QUESTION 13
    TextView tv_question13;
    String tv_question13_StringEncode;
    TextView tv_question13_Q01, tv_question13_Q02, tv_question13_Q03, tv_question13_Q04, tv_question13_Q05, tv_question13_Q06, tv_question13_Q07, tv_question13_Q08, tv_question13_Q09, tv_question13_Q10, tv_question13_Q11, tv_question13_Q12, tv_question13_Q13, tv_question13_Q14, tv_question13_Q15, tv_question13_Q16;
    String tv_question13_Q01_StringEncode, tv_question13_Q02_StringEncode, tv_question13_Q03_StringEncode, tv_question13_Q04_StringEncode, tv_question13_Q05_StringEncode, tv_question13_Q06_StringEncode, tv_question13_Q07_StringEncode, tv_question13_Q08_StringEncode, tv_question13_Q09_StringEncode, tv_question13_Q10_StringEncode, tv_question13_Q11_StringEncode, tv_question13_Q12_StringEncode, tv_question13_Q13_StringEncode, tv_question13_Q14_StringEncode, tv_question13_Q15_StringEncode, tv_question13_Q16_StringEncode;
    RadioGroup rg_13_01, rg_13_02, rg_13_03, rg_13_04, rg_13_05, rg_13_06, rg_13_07, rg_13_08, rg_13_09, rg_13_10, rg_13_11, rg_13_12, rg_13_13, rg_13_14, rg_13_15, rg_13_16;
    String rb_13_01_answer_String, rb_13_02_answer_String, rb_13_03_answer_String, rb_13_04_answer_String, rb_13_05_answer_String, rb_13_06_answer_String, rb_13_07_answer_String, rb_13_08_answer_String, rb_13_09_answer_String, rb_13_10_answer_String, rb_13_11_answer_String, rb_13_12_answer_String, rb_13_13_answer_String, rb_13_14_answer_String, rb_13_15_answer_String, rb_13_16_answer_String;
    EditText et_answer13_01_inw, et_answer13_02_inw, et_answer13_03_inw, et_answer13_04_inw, et_answer13_05_inw, et_answer13_06_inw, et_answer13_07_inw, et_answer13_08_inw, et_answer13_09_inw, et_answer13_10_inw, et_answer13_11_inw, et_answer13_12_inw, et_answer13_13_inw, et_answer13_14_inw, et_answer13_15_inw, et_answer13_16_inw;
    String et_answer13_01_inw_String, et_answer13_02_inw_String, et_answer13_03_inw_String, et_answer13_04_inw_String, et_answer13_05_inw_String, et_answer13_06_inw_String, et_answer13_07_inw_String, et_answer13_08_inw_String, et_answer13_09_inw_String, et_answer13_10_inw_String, et_answer13_11_inw_String, et_answer13_12_inw_String, et_answer13_13_inw_String, et_answer13_14_inw_String, et_answer13_15_inw_String, et_answer13_16_inw_String;

    //  init. for QUESTION 14
    TextView tv_question14;
    String tv_question14_StringEncode;
    TextView tv_question14_Q01, tv_question14_Q02, tv_question14_Q03, tv_question14_Q04, tv_question14_Q05, tv_question14_Q06, tv_question14_Q07, tv_question14_Q08, tv_question14_Q09, tv_question14_Q10, tv_question14_Q11, tv_question14_Q12, tv_question14_Q13, tv_question14_Q14, tv_question14_Q15, tv_question14_Q16;
    String tv_question14_Q01_StringEncode, tv_question14_Q02_StringEncode, tv_question14_Q03_StringEncode, tv_question14_Q04_StringEncode, tv_question14_Q05_StringEncode, tv_question14_Q06_StringEncode, tv_question14_Q07_StringEncode, tv_question14_Q08_StringEncode, tv_question14_Q09_StringEncode, tv_question14_Q10_StringEncode, tv_question14_Q11_StringEncode, tv_question14_Q12_StringEncode, tv_question14_Q13_StringEncode, tv_question14_Q14_StringEncode, tv_question14_Q15_StringEncode, tv_question14_Q16_StringEncode;
    RadioGroup rg_14_01, rg_14_02, rg_14_03, rg_14_04, rg_14_05, rg_14_06, rg_14_07, rg_14_08, rg_14_09, rg_14_10, rg_14_11, rg_14_12, rg_14_13, rg_14_14, rg_14_15, rg_14_16;
    String rb_14_01_answer_String, rb_14_02_answer_String, rb_14_03_answer_String, rb_14_04_answer_String, rb_14_05_answer_String, rb_14_06_answer_String, rb_14_07_answer_String, rb_14_08_answer_String, rb_14_09_answer_String, rb_14_10_answer_String, rb_14_11_answer_String, rb_14_12_answer_String, rb_14_13_answer_String, rb_14_14_answer_String, rb_14_15_answer_String, rb_14_16_answer_String;

    //  init. for QUESTION 15
    TextView tv_question15;
    String tv_question15_StringEncode;
    TextView tv_question15_Q01, tv_question15_Q02, tv_question15_Q03, tv_question15_Q04, tv_question15_Q05, tv_question15_Q06, tv_question15_Q07, tv_question15_Q08, tv_question15_Q09, tv_question15_Q10, tv_question15_Q11, tv_question15_Q12, tv_question15_Q13, tv_question15_Q14, tv_question15_Q15, tv_question15_Q16;
    String tv_question15_Q01_StringEncode, tv_question15_Q02_StringEncode, tv_question15_Q03_StringEncode, tv_question15_Q04_StringEncode, tv_question15_Q05_StringEncode, tv_question15_Q06_StringEncode, tv_question15_Q07_StringEncode, tv_question15_Q08_StringEncode, tv_question15_Q09_StringEncode, tv_question15_Q10_StringEncode, tv_question15_Q11_StringEncode, tv_question15_Q12_StringEncode, tv_question15_Q13_StringEncode, tv_question15_Q14_StringEncode, tv_question15_Q15_StringEncode, tv_question15_Q16_StringEncode;
    EditText et_answer15_01_or, et_answer15_02_or, et_answer15_03_or, et_answer15_04_or, et_answer15_05_or, et_answer15_06_or, et_answer15_07_or, et_answer15_08_or, et_answer15_09_or, et_answer15_10_or, et_answer15_11_or, et_answer15_12_or, et_answer15_13_or, et_answer15_14_or, et_answer15_15_or, et_answer15_16_or;
    String et_answer15_01_or_String, et_answer15_02_or_String, et_answer15_03_or_String, et_answer15_04_or_String, et_answer15_05_or_String, et_answer15_06_or_String, et_answer15_07_or_String, et_answer15_08_or_String, et_answer15_09_or_String, et_answer15_10_or_String, et_answer15_11_or_String, et_answer15_12_or_String, et_answer15_13_or_String, et_answer15_14_or_String, et_answer15_15_or_String, et_answer15_16_or_String;

    //  init. for QUESTION 16
    TextView tv_question16;
    EditText et_answer16;
    String tv_question16_StringEncode, et_answer16_String;

    //  init. for QUESTION 17
    TextView tv_question17;
    EditText et_answer17;
    String tv_question17_StringEncode, et_answer17_String;

    //  init. for QUESTION 18
    TextView tv_question18;
    EditText et_answer18;
    String tv_question18_StringEncode, et_answer18_String;

    //  init. for QUESTION 19
    TextView tv_question19;
    RadioGroup rg_19;
    EditText et_answer19_why;
    String tv_question19_StringEncode, rb_answer19_String, et_answer19_why_String;

    //  init. for QUESTION 20
    TextView tv_question20;
    RadioGroup rg_20;
    EditText et_answer20_mi;
    String tv_question20_StringEncode, rb_answer20_String, et_answer20_mi_String;

    //  init. for QUESTION 21
    TextView tv_question21;
    RadioGroup rg_21;
    EditText et_answer21_mh, et_answer21_why;
    String tv_question21_StringEncode, rb_answer21_String, et_answer21_mh_String, et_answer21_why_String;

    //  init. for QUESTION 22
    TextView tv_question22;
    EditText et_answer22_hm, et_answer22_why;
    String tv_question22_StringEncode, et_answer22_hm_String, et_answer22_why_String;

    //  init. for QUESTION 23
    TextView tv_question23;
    RadioGroup rg_23;
    String tv_question23_StringEncode, rb_answer23_String;

    //  init. for QUESTION 24
    TextView tv_question24;
    EditText et_answer24;
    String tv_question24_StringEncode, et_answer24_String;

    //  init. for QUESTION 25
    TextView tv_question25;
    EditText et_answer25;
    String tv_question25_StringEncode, et_answer25_String;

    //  init. for QUESTION 26
    TextView tv_question26;
    RadioGroup rg_26;
    EditText et_answer26_how, et_answer26_why;
    String tv_question26_StringEncode, rb_answer26_String, et_answer26_how_String, et_answer26_why_String;

    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseDatabase = FirebaseDatabase.getInstance();

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        bt_submit = findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random(System.currentTimeMillis());
                int rand = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
                String srand = Integer.toString(rand);
                databaseReference = firebaseDatabase.getReference(android.os.Build.MODEL + " (" + android_id + ")").child(srand);
                databaseReference.keepSynced(true);

                //  meth. for QUESTIONS
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
                question13();   //  13. WHICH ARE THE FOLLOWING SCHEMES YOU AVAIL
                question14();   //  14. WHICH IS THE LEVEL OF UTILIZATION OF THE FOLLOWING SCHEMES BY YOU
                question15();   //  15. ORDER OR RANK THE FOLLOWING SCHEMES BASED ON THE UTILITY OF THE SCHEME TO YOU
                question16();   //  16. AMONG THE AVAILED SCHEMES, WHICH SCHEMES WERE VERY RELEVANT / USEFUL
                question17();   //  17. AMONG THESE, WHICH SCHEMES WERE MORE SUPPORTIVE TO CONTINUE YOUR SCHOOLING
                question18();   //  18. AMONG THE AVAILED SCHEMES, WHICH SCHEMES WERE COMPLETELY UTILISED BY YOU
                question19();   //  19. HAVE YOU NOT COMPLETELY UTILIZED ANY OF TH SCHEMES
                question20();   //  20. ARE THERE ANY SCHEME WHICH IS BENEFITING THE FAMILY MEMBERS OTHER THAN YOU
                question21();   //  21. HAVE YOU ECONOMICALLY BENEFITED BY AVAILING STUDENT'S WELFARE SCHEMES FOR YOUR KIDS?
                question22();   //  22. DID THESE SCHEMES REDUCE YOUR EXPENDITURE ON YOU KIDS EDUCATION?
                question23();   //  23. DOES THE FAMILY EXPENDITURE INCREASE DUE TO THE PARTICULAR SCHEME
                question24();   //  24. HOW DOES THE SCHEME HELP THE PARENTS OTHER THAN ECONOMICAL ASPECT
                question25();   //  25. HOW DID YOU UTILIZE THE SAVED MONEY BECAUSE OF THESE SCHEMES
                question26();   //  26. DID THE SCHEMES IMPROVE YOUR FAMILY STATUS

                linearLayout = findViewById(R.id.ll_item);
                Snackbar.make(linearLayout, "All the data has been successfully saved!", Snackbar.LENGTH_LONG).show();
            }
        });

        //  ARROW
        //  (ARROW)  I. SOCIO ECONOMIC STATUS
        iv_i_socio_economic_status_01 = findViewById(R.id.iv_i_socio_economic_status_01);
        iv_i_socio_economic_status_02 = findViewById(R.id.iv_i_socio_economic_status_02);

        iv_i_socio_economic_status_01.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
        iv_i_socio_economic_status_01.setVisibility(View.VISIBLE);
        iv_i_socio_economic_status_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_i_socio_economic_status = findViewById(R.id.ll_i_socio_economic_status);
                ll_i_socio_economic_status.setVisibility(View.VISIBLE);
                iv_i_socio_economic_status_01.setVisibility(View.GONE);
                iv_i_socio_economic_status_02.setVisibility(View.VISIBLE);
            }
        });

        iv_i_socio_economic_status_02.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
        iv_i_socio_economic_status_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_i_socio_economic_status = findViewById(R.id.ll_i_socio_economic_status);
                ll_i_socio_economic_status.setVisibility(View.GONE);
                iv_i_socio_economic_status_02.setVisibility(View.GONE);
                iv_i_socio_economic_status_01.setVisibility(View.VISIBLE);
            }
        });

        //  (ARROW)  II. UTILIZATION OF THE STUDENT WELFARE SCHEMES
        iv_tv_ii_utilization_of_the_student_welfare_schemes_01 = findViewById(R.id.iv_tv_ii_utilization_of_the_student_welfare_schemes_01);
        iv_tv_ii_utilization_of_the_student_welfare_schemes_02 = findViewById(R.id.iv_tv_ii_utilization_of_the_student_welfare_schemes_02);

        iv_tv_ii_utilization_of_the_student_welfare_schemes_01.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
        iv_tv_ii_utilization_of_the_student_welfare_schemes_01.setVisibility(View.VISIBLE);
        iv_tv_ii_utilization_of_the_student_welfare_schemes_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_ii_utilization_of_the_student_welfare_schemes = findViewById(R.id.ll_ii_utilization_of_the_student_welfare_schemes);
                ll_ii_utilization_of_the_student_welfare_schemes.setVisibility(View.VISIBLE);
                iv_tv_ii_utilization_of_the_student_welfare_schemes_01.setVisibility(View.GONE);
                iv_tv_ii_utilization_of_the_student_welfare_schemes_02.setVisibility(View.VISIBLE);
            }
        });

        iv_tv_ii_utilization_of_the_student_welfare_schemes_02.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
        iv_tv_ii_utilization_of_the_student_welfare_schemes_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_ii_utilization_of_the_student_welfare_schemes = findViewById(R.id.ll_ii_utilization_of_the_student_welfare_schemes);
                ll_ii_utilization_of_the_student_welfare_schemes.setVisibility(View.GONE);
                iv_tv_ii_utilization_of_the_student_welfare_schemes_02.setVisibility(View.GONE);
                iv_tv_ii_utilization_of_the_student_welfare_schemes_01.setVisibility(View.VISIBLE);
            }
        });

        //  (ARROW)  III. SOCIO ECONOMIC GROWTH OF FAMILY
        iv_tv_iii_socio_economic_growth_of_family_01 = findViewById(R.id.iv_tv_iii_socio_economic_growth_of_family_01);
        iv_tv_iii_socio_economic_growth_of_family_02 = findViewById(R.id.iv_tv_iii_socio_economic_growth_of_family_02);

        iv_tv_iii_socio_economic_growth_of_family_01.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
        iv_tv_iii_socio_economic_growth_of_family_01.setVisibility(View.VISIBLE);
        iv_tv_iii_socio_economic_growth_of_family_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_iii_socio_economic_growth_of_family = findViewById(R.id.ll_iii_socio_economic_growth_of_family);
                ll_iii_socio_economic_growth_of_family.setVisibility(View.VISIBLE);
                iv_tv_iii_socio_economic_growth_of_family_01.setVisibility(View.GONE);
                iv_tv_iii_socio_economic_growth_of_family_02.setVisibility(View.VISIBLE);
            }
        });

        iv_tv_iii_socio_economic_growth_of_family_02.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
        iv_tv_iii_socio_economic_growth_of_family_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_iii_socio_economic_growth_of_family = findViewById(R.id.ll_iii_socio_economic_growth_of_family);
                ll_iii_socio_economic_growth_of_family.setVisibility(View.GONE);
                iv_tv_iii_socio_economic_growth_of_family_02.setVisibility(View.GONE);
                iv_tv_iii_socio_economic_growth_of_family_01.setVisibility(View.VISIBLE);
            }
        });
    }

    //  I. SOCIO ECONOMIC STATUS
    void question01() {
        tv_question1 = findViewById(R.id.tv_question1);
        tv_question1_StringEncode = EncodeString(tv_question1.getText().toString());

        //  NAME OF THE STUDENT
        et_answer1 = findViewById(R.id.et_answer1);
        et_answer1_String = et_answer1.getText().toString();
        if (et_answer1_String.isEmpty()) {
            databaseReference.child(tv_question1_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question1_StringEncode).setValue(et_answer1_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question2_StringEncode).setValue(et_answer2_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question3_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question4_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question5_StringEncode).setValue(et_answer5_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question6_StringEncode).setValue(et_answer6_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Name").setValue(et_answer7_child1_String);
            databaseReference.keepSynced(true);
        }

        //  AGE (CHILD 1)
        et_answer7_age1 = findViewById(R.id.et_answer7_age1);
        et_answer7_age1_String = et_answer7_age1.getText().toString();
        if (et_answer7_age1_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Age").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 1").child("Age").setValue(et_answer7_age1_String);
            databaseReference.keepSynced(true);
        }

        //  CHILD 2
        et_answer7_child2 = findViewById(R.id.et_answer7_child2);
        et_answer7_child2_String = et_answer7_child2.getText().toString();
        if (et_answer7_child2_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Name").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Name").setValue(et_answer7_child2_String);
            databaseReference.keepSynced(true);
        }

        //  AGE (CHILD 2)
        et_answer7_age2 = findViewById(R.id.et_answer7_age2);
        et_answer7_age2_String = et_answer7_age2.getText().toString();
        if (et_answer7_age2_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Age").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 2").child("Age").setValue(et_answer7_age2_String);
            databaseReference.keepSynced(true);
        }

        //  CHILD 3
        et_answer7_child3 = findViewById(R.id.et_answer7_child3);
        et_answer7_child3_String = et_answer7_child3.getText().toString();
        if (et_answer7_child3_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Name").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Name").setValue(et_answer7_child3_String);
            databaseReference.keepSynced(true);
        }

        //  AGE (CHILD 3)
        et_answer7_age3 = findViewById(R.id.et_answer7_age3);
        et_answer7_age3_String = et_answer7_age3.getText().toString();
        if (et_answer7_age3_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Age").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Child 3").child("Age").setValue(et_answer7_age3_String);
            databaseReference.keepSynced(true);
        }

        //  OTHERS
        et_answer7_others = findViewById(R.id.et_answer7_others);
        et_answer7_others_String = et_answer7_others.getText().toString();
        if (et_answer7_others_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Name").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Name").setValue(et_answer7_others_String);
            databaseReference.keepSynced(true);
        }

        //  AGE (OTHERS)
        et_answer7_ageOthers = findViewById(R.id.et_answer7_ageOthers);
        et_answer7_ageOthers_String = et_answer7_ageOthers.getText().toString();
        if (et_answer7_ageOthers_String.isEmpty()) {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Age").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question7_StringEncode).child("Others").child("Age").setValue(et_answer7_ageOthers_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Yes (or) No").setValue("");
            databaseReference.keepSynced(true);
        }

        //  MALE (nos.)
        et_answer8_male = findViewById(R.id.et_answer8_male);
        et_answer8_male_String = et_answer8_male.getText().toString();
        if (et_answer8_male_String.isEmpty()) {
            databaseReference.child(tv_question8_StringEncode).child("Male (nos)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Male (nos)").setValue(et_answer8_male_String);
            databaseReference.keepSynced(true);
        }

        //  FEMALE (nos.)
        et_answer8_female = findViewById(R.id.et_answer8_female);
        et_answer8_female_String = et_answer8_female.getText().toString();
        if (et_answer8_female_String.isEmpty()) {
            databaseReference.child(tv_question8_StringEncode).child("Female (nos)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question8_StringEncode).child("Female (nos)").setValue(et_answer8_female_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Name").setValue(et_answer9_motherName_String);
            databaseReference.keepSynced(true);
        }

        //  EDUCATIONAL STATUS (MOTHER)
        et_answer9_edStatusMN = findViewById(R.id.et_answer9_edStatusMN);
        et_answer9_edStatusMN_String = et_answer9_edStatusMN.getText().toString();
        if (et_answer9_edStatusMN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Educational Status").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Mother").child("Educational Status").setValue(et_answer9_edStatusMN_String);
            databaseReference.keepSynced(true);
        }

        //  FATHER NAME
        et_answer9_fatherName = findViewById(R.id.et_answer9_fatherName);
        et_answer9_fatherName_String = et_answer9_fatherName.getText().toString();
        if (et_answer9_fatherName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Name").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Name").setValue(et_answer9_fatherName_String);
            databaseReference.keepSynced(true);
        }

        //  EDUCATIONAL STATUS (FATHER)
        et_answer9_edStatusFN = findViewById(R.id.et_answer9_edStatusFN);
        et_answer9_edStatusFN_String = et_answer9_edStatusFN.getText().toString();
        if (et_answer9_edStatusFN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Educational Status").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Father").child("Educational Status").setValue(et_answer9_edStatusFN_String);
            databaseReference.keepSynced(true);
        }

        //  GUARDIAN NAME
        et_answer9_gaurdianName = findViewById(R.id.et_answer9_gaurdianName);
        et_answer9_gaurdianName_String = et_answer9_gaurdianName.getText().toString();
        if (et_answer9_gaurdianName_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Name").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Name").setValue(et_answer9_gaurdianName_String);
            databaseReference.keepSynced(true);
        }

        //  EDUCATIONAL STATUS (FATHER)
        et_answer9_edStatusGN = findViewById(R.id.et_answer9_edStatusGN);
        et_answer9_edStatusGN_String = et_answer9_edStatusGN.getText().toString();
        if (et_answer9_edStatusGN_String.isEmpty()) {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Educational Status").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question9_StringEncode).child("Guardian").child("Educational Status").setValue(et_answer9_edStatusGN_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Father").child(tv_question10_father_noe_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Father").child(tv_question10_father_sm_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        }

        //  MONTHLY INCOME
        et_answer10_father_mi = findViewById(R.id.et_answer10_father_mi);
        et_answer10_father_mi_String = et_answer10_father_mi.getText().toString();
        if (et_answer10_father_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Father").child("Monthly Income (Rs)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Father").child("Monthly Income (Rs)").setValue(et_answer10_father_mi_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child(tv_question10_mother_noe_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child(tv_question10_mother_sm_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        }

        //  MONTHLY INCOME
        et_answer10_mother_mi = findViewById(R.id.et_answer10_mother_mi);
        et_answer10_mother_mi_String = et_answer10_mother_mi.getText().toString();
        if (et_answer10_mother_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child("Monthly Income (Rs)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Mother").child("Monthly Income (Rs)").setValue(et_answer10_mother_mi_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child(tv_question10_person1_noe_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child(tv_question10_person1_sm_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        }

        //  MONTHLY INCOME
        et_answer10_person1_mi = findViewById(R.id.et_answer10_person1_mi);
        et_answer10_person1_mi_String = et_answer10_person1_mi.getText().toString();
        if (et_answer10_person1_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child("Monthly Income (Rs)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 1").child("Monthly Income (Rs)").setValue(et_answer10_person1_mi_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child(tv_question10_person2_noe_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child(tv_question10_person2_sm_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        }

        //  MONTHLY INCOME
        et_answer10_person2_mi = findViewById(R.id.et_answer10_person2_mi);
        et_answer10_person2_mi_String = et_answer10_person2_mi.getText().toString();
        if (et_answer10_person2_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child("Monthly Income (Rs)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 2").child("Monthly Income (Rs)").setValue(et_answer10_person2_mi_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child(tv_question10_person3_noe_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child(tv_question10_person3_sm_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        }

        //  MONTHLY INCOME
        et_answer10_person3_mi = findViewById(R.id.et_answer10_person3_mi);
        et_answer10_person3_mi_String = et_answer10_person3_mi.getText().toString();
        if (et_answer10_person3_mi_String.isEmpty()) {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child("Monthly Income (Rs)").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question10_StringEncode).child("Person 3").child("Monthly Income (Rs)").setValue(et_answer10_person3_mi_String);
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question11_StringEncode).setValue("");
            databaseReference.keepSynced(true);
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
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question12_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        }
    }

    //  II. UTILIZATION OF THE STUDENT WELFARE SCHEMES
    void question13() {
        tv_question13 = findViewById(R.id.tv_question13);
        tv_question13_StringEncode = EncodeString(tv_question13.getText().toString());

        //  QUESTION 13 - 01
        tv_question13_Q01 = findViewById(R.id.tv_question13_Q01);
        tv_question13_Q01_StringEncode = EncodeString(tv_question13_Q01.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_01 = findViewById(R.id.rg_13_01);
        if (rg_13_01.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_01.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_01_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q01_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_01_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q01_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_01_inw = findViewById(R.id.et_answer13_01_inw);
        et_answer13_01_inw_String = et_answer13_01_inw.getText().toString();
        if (et_answer13_01_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q01_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q01_StringEncode).child("If no, why?").setValue(et_answer13_01_inw_String);
        }

        //  QUESTION 13 - 02
        tv_question13_Q02 = findViewById(R.id.tv_question13_Q02);
        tv_question13_Q02_StringEncode = EncodeString(tv_question13_Q02.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_02 = findViewById(R.id.rg_13_02);
        if (rg_13_02.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_02.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_02_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q02_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_02_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q02_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_02_inw = findViewById(R.id.et_answer13_02_inw);
        et_answer13_02_inw_String = et_answer13_02_inw.getText().toString();
        if (et_answer13_02_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q02_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q02_StringEncode).child("If no, why?").setValue(et_answer13_02_inw_String);
        }

        //  QUESTION 13 - 03
        tv_question13_Q03 = findViewById(R.id.tv_question13_Q03);
        tv_question13_Q03_StringEncode = EncodeString(tv_question13_Q03.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_03 = findViewById(R.id.rg_13_03);
        if (rg_13_03.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_03.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_03_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q03_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_03_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q03_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_03_inw = findViewById(R.id.et_answer13_03_inw);
        et_answer13_03_inw_String = et_answer13_03_inw.getText().toString();
        if (et_answer13_03_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q03_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q03_StringEncode).child("If no, why?").setValue(et_answer13_03_inw_String);
        }

        //  QUESTION 13 - 04
        tv_question13_Q04 = findViewById(R.id.tv_question13_Q04);
        tv_question13_Q04_StringEncode = EncodeString(tv_question13_Q04.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_04 = findViewById(R.id.rg_13_04);
        if (rg_13_04.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_04.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_04_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q04_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_04_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q04_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_04_inw = findViewById(R.id.et_answer13_04_inw);
        et_answer13_04_inw_String = et_answer13_04_inw.getText().toString();
        if (et_answer13_04_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q04_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q04_StringEncode).child("If no, why?").setValue(et_answer13_04_inw_String);
        }

        //  QUESTION 13 - 05
        tv_question13_Q05 = findViewById(R.id.tv_question13_Q05);
        tv_question13_Q05_StringEncode = EncodeString(tv_question13_Q05.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_05 = findViewById(R.id.rg_13_05);
        if (rg_13_05.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_05.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_05_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q05_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_05_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q05_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_05_inw = findViewById(R.id.et_answer13_05_inw);
        et_answer13_05_inw_String = et_answer13_05_inw.getText().toString();
        if (et_answer13_05_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q05_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q05_StringEncode).child("If no, why?").setValue(et_answer13_05_inw_String);
        }

        //  QUESTION 13 - 06
        tv_question13_Q06 = findViewById(R.id.tv_question13_Q06);
        tv_question13_Q06_StringEncode = EncodeString(tv_question13_Q06.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_06 = findViewById(R.id.rg_13_06);
        if (rg_13_06.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_06.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_06_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q06_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_06_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q06_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_06_inw = findViewById(R.id.et_answer13_06_inw);
        et_answer13_06_inw_String = et_answer13_06_inw.getText().toString();
        if (et_answer13_06_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q06_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q06_StringEncode).child("If no, why?").setValue(et_answer13_06_inw_String);
        }

        //  QUESTION 13 - 07
        tv_question13_Q07 = findViewById(R.id.tv_question13_Q07);
        tv_question13_Q07_StringEncode = EncodeString(tv_question13_Q07.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_07 = findViewById(R.id.rg_13_07);
        if (rg_13_07.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_07.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_07_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q07_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_07_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q07_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_07_inw = findViewById(R.id.et_answer13_07_inw);
        et_answer13_07_inw_String = et_answer13_07_inw.getText().toString();
        if (et_answer13_07_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q07_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q07_StringEncode).child("If no, why?").setValue(et_answer13_07_inw_String);
        }

        //  QUESTION 13 - 08
        tv_question13_Q08 = findViewById(R.id.tv_question13_Q08);
        tv_question13_Q08_StringEncode = EncodeString(tv_question13_Q08.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_08 = findViewById(R.id.rg_13_08);
        if (rg_13_08.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_08.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_08_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q08_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_08_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q08_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_08_inw = findViewById(R.id.et_answer13_08_inw);
        et_answer13_08_inw_String = et_answer13_08_inw.getText().toString();
        if (et_answer13_08_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q08_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q08_StringEncode).child("If no, why?").setValue(et_answer13_08_inw_String);
        }

        //  QUESTION 13 - 09
        tv_question13_Q09 = findViewById(R.id.tv_question13_Q09);
        tv_question13_Q09_StringEncode = EncodeString(tv_question13_Q09.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_09 = findViewById(R.id.rg_13_09);
        if (rg_13_09.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_09.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_09_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q09_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_09_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q09_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_09_inw = findViewById(R.id.et_answer13_09_inw);
        et_answer13_09_inw_String = et_answer13_09_inw.getText().toString();
        if (et_answer13_09_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q09_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q09_StringEncode).child("If no, why?").setValue(et_answer13_09_inw_String);
        }

        //  QUESTION 13 - 10
        tv_question13_Q10 = findViewById(R.id.tv_question13_Q10);
        tv_question13_Q10_StringEncode = EncodeString(tv_question13_Q10.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_10 = findViewById(R.id.rg_13_10);
        if (rg_13_10.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_10.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_10_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q10_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_10_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q10_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_10_inw = findViewById(R.id.et_answer13_10_inw);
        et_answer13_10_inw_String = et_answer13_10_inw.getText().toString();
        if (et_answer13_10_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q10_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q10_StringEncode).child("If no, why?").setValue(et_answer13_10_inw_String);
        }

        //  QUESTION 13 - 11
        tv_question13_Q11 = findViewById(R.id.tv_question13_Q11);
        tv_question13_Q11_StringEncode = EncodeString(tv_question13_Q11.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_11 = findViewById(R.id.rg_13_11);
        if (rg_13_11.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_11.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_11_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q11_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_11_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q11_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_11_inw = findViewById(R.id.et_answer13_11_inw);
        et_answer13_11_inw_String = et_answer13_11_inw.getText().toString();
        if (et_answer13_11_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q11_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q11_StringEncode).child("If no, why?").setValue(et_answer13_11_inw_String);
        }

        //  QUESTION 13 - 12
        tv_question13_Q12 = findViewById(R.id.tv_question13_Q12);
        tv_question13_Q12_StringEncode = EncodeString(tv_question13_Q12.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_12 = findViewById(R.id.rg_13_12);
        if (rg_13_12.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_12.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_12_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q12_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_12_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q12_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_12_inw = findViewById(R.id.et_answer13_12_inw);
        et_answer13_12_inw_String = et_answer13_12_inw.getText().toString();
        if (et_answer13_12_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q12_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q12_StringEncode).child("If no, why?").setValue(et_answer13_12_inw_String);
        }

        //  QUESTION 13 - 13
        tv_question13_Q13 = findViewById(R.id.tv_question13_Q13);
        tv_question13_Q13_StringEncode = EncodeString(tv_question13_Q13.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_13 = findViewById(R.id.rg_13_13);
        if (rg_13_13.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_13.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_13_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q13_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_13_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q13_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_13_inw = findViewById(R.id.et_answer13_13_inw);
        et_answer13_13_inw_String = et_answer13_13_inw.getText().toString();
        if (et_answer13_13_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q13_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q13_StringEncode).child("If no, why?").setValue(et_answer13_13_inw_String);
        }

        //  QUESTION 13 - 14
        tv_question13_Q14 = findViewById(R.id.tv_question13_Q14);
        tv_question13_Q14_StringEncode = EncodeString(tv_question13_Q14.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_14 = findViewById(R.id.rg_13_14);
        if (rg_13_14.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_14.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_14_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q14_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_14_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q14_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_14_inw = findViewById(R.id.et_answer13_14_inw);
        et_answer13_14_inw_String = et_answer13_14_inw.getText().toString();
        if (et_answer13_14_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q14_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q14_StringEncode).child("If no, why?").setValue(et_answer13_14_inw_String);
        }

        //  QUESTION 13 - 15
        tv_question13_Q15 = findViewById(R.id.tv_question13_Q15);
        tv_question13_Q15_StringEncode = EncodeString(tv_question13_Q15.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_15 = findViewById(R.id.rg_13_15);
        if (rg_13_15.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_15.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_15_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q15_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_15_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q15_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_15_inw = findViewById(R.id.et_answer13_15_inw);
        et_answer13_15_inw_String = et_answer13_15_inw.getText().toString();
        if (et_answer13_15_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q15_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q15_StringEncode).child("If no, why?").setValue(et_answer13_15_inw_String);
        }

        //  QUESTION 13 - 16
        tv_question13_Q16 = findViewById(R.id.tv_question13_Q16);
        tv_question13_Q16_StringEncode = EncodeString(tv_question13_Q16.getText().toString());

        //  YES (or) NO (or) NOT APPLICABLE
        rg_13_16 = findViewById(R.id.rg_13_16);
        if (rg_13_16.getCheckedRadioButtonId() != -1) {
            int selectedId13 = rg_13_16.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId13);
            rb_13_16_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q16_StringEncode).child("Yes (or) No (or) Not Applicable").setValue(rb_13_16_answer_String);
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q16_StringEncode).child("Yes (or) No (or) Not Applicable").setValue("");
        }

        //  IF NO, WHY?
        et_answer13_16_inw = findViewById(R.id.et_answer13_16_inw);
        et_answer13_16_inw_String = et_answer13_16_inw.getText().toString();
        if (et_answer13_16_inw_String.isEmpty()) {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q16_StringEncode).child("If no, why?").setValue("");
        } else {
            databaseReference.child(tv_question13_StringEncode).child(tv_question13_Q16_StringEncode).child("If no, why?").setValue(et_answer13_16_inw_String);
        }
    }

    void question14() {
        tv_question14 = findViewById(R.id.tv_question14);
        tv_question14_StringEncode = EncodeString(tv_question14.getText().toString());

        //  QUESTION 14 - 01
        tv_question14_Q01 = findViewById(R.id.tv_question14_Q01);
        tv_question14_Q01_StringEncode = EncodeString(tv_question14_Q01.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_01 = findViewById(R.id.rg_14_01);
        if (rg_14_01.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_01.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_01_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q01_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_01_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q01_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 02
        tv_question14_Q02 = findViewById(R.id.tv_question14_Q02);
        tv_question14_Q02_StringEncode = EncodeString(tv_question14_Q02.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_02 = findViewById(R.id.rg_14_02);
        if (rg_14_02.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_02.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_02_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q02_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_02_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q02_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 03
        tv_question14_Q03 = findViewById(R.id.tv_question14_Q03);
        tv_question14_Q03_StringEncode = EncodeString(tv_question14_Q03.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_03 = findViewById(R.id.rg_14_03);
        if (rg_14_03.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_03.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_03_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q03_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_03_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q03_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 04
        tv_question14_Q04 = findViewById(R.id.tv_question14_Q04);
        tv_question14_Q04_StringEncode = EncodeString(tv_question14_Q04.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_04 = findViewById(R.id.rg_14_04);
        if (rg_14_04.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_04.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_04_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q04_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_04_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q04_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 05
        tv_question14_Q05 = findViewById(R.id.tv_question14_Q05);
        tv_question14_Q05_StringEncode = EncodeString(tv_question14_Q05.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_05 = findViewById(R.id.rg_14_05);
        if (rg_14_05.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_05.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_05_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q05_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_05_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q05_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 06
        tv_question14_Q06 = findViewById(R.id.tv_question14_Q06);
        tv_question14_Q06_StringEncode = EncodeString(tv_question14_Q06.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_06 = findViewById(R.id.rg_14_06);
        if (rg_14_06.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_06.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_06_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q06_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_06_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q06_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 07
        tv_question14_Q07 = findViewById(R.id.tv_question14_Q07);
        tv_question14_Q07_StringEncode = EncodeString(tv_question14_Q07.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_07 = findViewById(R.id.rg_14_07);
        if (rg_14_07.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_07.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_07_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q07_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_07_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q07_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 08
        tv_question14_Q08 = findViewById(R.id.tv_question14_Q08);
        tv_question14_Q08_StringEncode = EncodeString(tv_question14_Q08.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_08 = findViewById(R.id.rg_14_08);
        if (rg_14_08.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_08.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_08_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q08_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_08_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q08_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 09
        tv_question14_Q09 = findViewById(R.id.tv_question14_Q09);
        tv_question14_Q09_StringEncode = EncodeString(tv_question14_Q09.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_09 = findViewById(R.id.rg_14_09);
        if (rg_14_09.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_09.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_09_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q09_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_09_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q09_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 10
        tv_question14_Q10 = findViewById(R.id.tv_question14_Q10);
        tv_question14_Q10_StringEncode = EncodeString(tv_question14_Q10.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_10 = findViewById(R.id.rg_14_10);
        if (rg_14_10.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_10.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_10_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q10_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_10_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q10_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 11
        tv_question14_Q11 = findViewById(R.id.tv_question14_Q11);
        tv_question14_Q11_StringEncode = EncodeString(tv_question14_Q11.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_11 = findViewById(R.id.rg_14_11);
        if (rg_14_11.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_11.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_11_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q11_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_11_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q11_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 12
        tv_question14_Q12 = findViewById(R.id.tv_question14_Q12);
        tv_question14_Q12_StringEncode = EncodeString(tv_question14_Q12.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_12 = findViewById(R.id.rg_14_12);
        if (rg_14_12.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_12.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_12_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q12_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_12_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q12_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 13
        tv_question14_Q13 = findViewById(R.id.tv_question14_Q13);
        tv_question14_Q13_StringEncode = EncodeString(tv_question14_Q13.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_13 = findViewById(R.id.rg_14_13);
        if (rg_14_13.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_13.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_13_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q13_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_13_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q13_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 14
        tv_question14_Q14 = findViewById(R.id.tv_question14_Q14);
        tv_question14_Q14_StringEncode = EncodeString(tv_question14_Q14.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_14 = findViewById(R.id.rg_14_14);
        if (rg_14_14.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_14.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_14_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q14_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_14_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q14_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 15
        tv_question14_Q15 = findViewById(R.id.tv_question14_Q15);
        tv_question14_Q15_StringEncode = EncodeString(tv_question14_Q15.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_15 = findViewById(R.id.rg_14_15);
        if (rg_14_15.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_15.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_15_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q15_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_15_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q15_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }

        //  QUESTION 14 - 16
        tv_question14_Q16 = findViewById(R.id.tv_question14_Q16);
        tv_question14_Q16_StringEncode = EncodeString(tv_question14_Q16.getText().toString());

        //  NOT UTILISED (or) PARTIALLY UTILISED (or) FULLY UTILISED
        rg_14_16 = findViewById(R.id.rg_14_16);
        if (rg_14_16.getCheckedRadioButtonId() != -1) {
            int selectedId14 = rg_14_16.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId14);
            rb_14_16_answer_String = radioButton.getText().toString();
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q16_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue(rb_14_16_answer_String);
        } else {
            databaseReference.child(tv_question14_StringEncode).child(tv_question14_Q16_StringEncode).child("Not Utilised (or) Partially Utilised (or) Fully Utilised").setValue("");
        }
    }

    void question15() {
        tv_question15 = findViewById(R.id.tv_question15);
        tv_question15_StringEncode = EncodeString(tv_question15.getText().toString());

        //  QUESTION 15 - 01
        tv_question15_Q01 = findViewById(R.id.tv_question15_Q01);
        tv_question15_Q01_StringEncode = EncodeString(tv_question15_Q01.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_01_or = findViewById(R.id.et_answer15_01_or);
        et_answer15_01_or_String = et_answer15_01_or.getText().toString();
        if (et_answer15_01_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q01_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q01_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_01_or_String);
        }

        //  QUESTION 15 - 02
        tv_question15_Q02 = findViewById(R.id.tv_question15_Q02);
        tv_question15_Q02_StringEncode = EncodeString(tv_question15_Q02.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_02_or = findViewById(R.id.et_answer15_02_or);
        et_answer15_02_or_String = et_answer15_02_or.getText().toString();
        if (et_answer15_02_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q02_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q02_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_02_or_String);
        }

        //  QUESTION 15 - 03
        tv_question15_Q03 = findViewById(R.id.tv_question15_Q03);
        tv_question15_Q03_StringEncode = EncodeString(tv_question15_Q03.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_03_or = findViewById(R.id.et_answer15_03_or);
        et_answer15_03_or_String = et_answer15_03_or.getText().toString();
        if (et_answer15_03_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q03_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q03_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_03_or_String);
        }

        //  QUESTION 15 - 04
        tv_question15_Q04 = findViewById(R.id.tv_question15_Q04);
        tv_question15_Q04_StringEncode = EncodeString(tv_question15_Q04.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_04_or = findViewById(R.id.et_answer15_04_or);
        et_answer15_04_or_String = et_answer15_04_or.getText().toString();
        if (et_answer15_04_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q04_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q04_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_04_or_String);
        }

        //  QUESTION 15 - 05
        tv_question15_Q05 = findViewById(R.id.tv_question15_Q05);
        tv_question15_Q05_StringEncode = EncodeString(tv_question15_Q05.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_05_or = findViewById(R.id.et_answer15_05_or);
        et_answer15_05_or_String = et_answer15_05_or.getText().toString();
        if (et_answer15_05_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q05_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q05_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_05_or_String);
        }

        //  QUESTION 15 - 06
        tv_question15_Q06 = findViewById(R.id.tv_question15_Q06);
        tv_question15_Q06_StringEncode = EncodeString(tv_question15_Q06.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_06_or = findViewById(R.id.et_answer15_06_or);
        et_answer15_06_or_String = et_answer15_06_or.getText().toString();
        if (et_answer15_06_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q06_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q06_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_06_or_String);
        }

        //  QUESTION 15 - 07
        tv_question15_Q07 = findViewById(R.id.tv_question15_Q07);
        tv_question15_Q07_StringEncode = EncodeString(tv_question15_Q07.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_07_or = findViewById(R.id.et_answer15_07_or);
        et_answer15_07_or_String = et_answer15_07_or.getText().toString();
        if (et_answer15_07_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q07_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q07_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_07_or_String);
        }

        //  QUESTION 15 - 08
        tv_question15_Q08 = findViewById(R.id.tv_question15_Q08);
        tv_question15_Q08_StringEncode = EncodeString(tv_question15_Q08.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_08_or = findViewById(R.id.et_answer15_08_or);
        et_answer15_08_or_String = et_answer15_08_or.getText().toString();
        if (et_answer15_08_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q08_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q08_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_08_or_String);
        }

        //  QUESTION 15 - 09
        tv_question15_Q09 = findViewById(R.id.tv_question15_Q09);
        tv_question15_Q09_StringEncode = EncodeString(tv_question15_Q09.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_09_or = findViewById(R.id.et_answer15_09_or);
        et_answer15_09_or_String = et_answer15_09_or.getText().toString();
        if (et_answer15_09_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q09_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q09_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_09_or_String);
        }

        //  QUESTION 15 - 10
        tv_question15_Q10 = findViewById(R.id.tv_question15_Q10);
        tv_question15_Q10_StringEncode = EncodeString(tv_question15_Q10.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_10_or = findViewById(R.id.et_answer15_10_or);
        et_answer15_10_or_String = et_answer15_10_or.getText().toString();
        if (et_answer15_10_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q10_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q10_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_10_or_String);
        }

        //  QUESTION 15 - 11
        tv_question15_Q11 = findViewById(R.id.tv_question15_Q11);
        tv_question15_Q11_StringEncode = EncodeString(tv_question15_Q11.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_11_or = findViewById(R.id.et_answer15_11_or);
        et_answer15_11_or_String = et_answer15_11_or.getText().toString();
        if (et_answer15_11_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q11_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q11_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_11_or_String);
        }

        //  QUESTION 15 - 12
        tv_question15_Q12 = findViewById(R.id.tv_question15_Q12);
        tv_question15_Q12_StringEncode = EncodeString(tv_question15_Q12.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_12_or = findViewById(R.id.et_answer15_12_or);
        et_answer15_12_or_String = et_answer15_12_or.getText().toString();
        if (et_answer15_12_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q12_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q12_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_12_or_String);
        }

        //  QUESTION 15 - 13
        tv_question15_Q13 = findViewById(R.id.tv_question15_Q13);
        tv_question15_Q13_StringEncode = EncodeString(tv_question15_Q13.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_13_or = findViewById(R.id.et_answer15_13_or);
        et_answer15_13_or_String = et_answer15_13_or.getText().toString();
        if (et_answer15_13_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q13_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q13_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_13_or_String);
        }

        //  QUESTION 15 - 14
        tv_question15_Q14 = findViewById(R.id.tv_question15_Q14);
        tv_question15_Q14_StringEncode = EncodeString(tv_question15_Q14.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_14_or = findViewById(R.id.et_answer15_14_or);
        et_answer15_14_or_String = et_answer15_14_or.getText().toString();
        if (et_answer15_14_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q14_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q14_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_14_or_String);
        }

        //  QUESTION 15 - 15
        tv_question15_Q15 = findViewById(R.id.tv_question15_Q15);
        tv_question15_Q15_StringEncode = EncodeString(tv_question15_Q15.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_15_or = findViewById(R.id.et_answer15_15_or);
        et_answer15_15_or_String = et_answer15_15_or.getText().toString();
        if (et_answer15_15_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q15_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q15_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_15_or_String);
        }

        //  QUESTION 15 - 16
        tv_question15_Q16 = findViewById(R.id.tv_question15_Q16);
        tv_question15_Q16_StringEncode = EncodeString(tv_question15_Q16.getText().toString());

        //  ORDER / RANK [1 to 16]
        et_answer15_16_or = findViewById(R.id.et_answer15_16_or);
        et_answer15_16_or_String = et_answer15_16_or.getText().toString();
        if (et_answer15_16_or_String.isEmpty()) {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q16_StringEncode).child("Order , Rank (1 to 16)").setValue("");
        } else {
            databaseReference.child(tv_question15_StringEncode).child(tv_question15_Q16_StringEncode).child("Order , Rank (1 to 16)").setValue(et_answer15_16_or_String);
        }
    }

    void question16() {
        tv_question16 = findViewById(R.id.tv_question16);
        tv_question16_StringEncode = EncodeString(tv_question16.getText().toString());

        //  AMONG THE AVAILED SCHEMES, WHICH SCHEMES WERE VERY RELEVANT / USEFUL
        et_answer16 = findViewById(R.id.et_answer16);
        et_answer16_String = et_answer16.getText().toString();
        if (et_answer16_String.isEmpty()) {
            databaseReference.child(tv_question16_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question16_StringEncode).setValue(et_answer16_String);
        }
    }

    void question17() {
        tv_question17 = findViewById(R.id.tv_question17);
        tv_question17_StringEncode = EncodeString(tv_question17.getText().toString());

        //  AMONG THESE, WHICH SCHEMES WERE MORE SUPPORTIVE TO CONTINUE YOUR SCHOOLING
        et_answer17 = findViewById(R.id.et_answer17);
        et_answer17_String = et_answer17.getText().toString();
        if (et_answer17_String.isEmpty()) {
            databaseReference.child(tv_question17_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question17_StringEncode).setValue(et_answer17_String);
        }
    }

    void question18() {
        tv_question18 = findViewById(R.id.tv_question18);
        tv_question18_StringEncode = EncodeString(tv_question18.getText().toString());

        //  AMONG THE AVAILED SCHEMES, WHICH SCHEMES WERE COMPLETELY UTILISED BY YOU
        et_answer18 = findViewById(R.id.et_answer18);
        et_answer18_String = et_answer18.getText().toString();
        if (et_answer18_String.isEmpty()) {
            databaseReference.child(tv_question18_StringEncode).setValue("");
        } else {
            databaseReference.child(tv_question18_StringEncode).setValue(et_answer18_String);
        }
    }

    void question19() {
        tv_question19 = findViewById(R.id.tv_question19);
        tv_question19_StringEncode = EncodeString(tv_question19.getText().toString());

        //  YES (or) NO
        rg_19 = findViewById(R.id.rg_19);
        if (rg_19.getCheckedRadioButtonId() != -1) {
            int selectedId19 = rg_19.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId19);
            rb_answer19_String = radioButton.getText().toString();
            databaseReference.child(tv_question19_StringEncode).child("Yes (or) No").setValue(rb_answer19_String);
        } else {
            databaseReference.child(tv_question19_StringEncode).child("Yes (or) No").setValue("");
        }

        //  Why?
        et_answer19_why = findViewById(R.id.et_answer19_why);
        et_answer19_why_String = et_answer19_why.getText().toString();
        if (et_answer19_why_String.isEmpty()) {
            databaseReference.child(tv_question19_StringEncode).child("Why?").setValue("");
        } else {
            databaseReference.child(tv_question19_StringEncode).child("Why?").setValue(et_answer19_why_String);
        }
    }

    void question20() {
        tv_question20 = findViewById(R.id.tv_question20);
        tv_question20_StringEncode = EncodeString(tv_question20.getText().toString());

        //  YES (or) NO
        rg_20 = findViewById(R.id.rg_20);
        if (rg_20.getCheckedRadioButtonId() != -1) {
            int selectedId20 = rg_20.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId20);
            rb_answer20_String = radioButton.getText().toString();
            databaseReference.child(tv_question20_StringEncode).child("Yes (or) No").setValue(rb_answer20_String);
        } else {
            databaseReference.child(tv_question20_StringEncode).child("Yes (or) No").setValue("");
        }

        //  Why?
        et_answer20_mi = findViewById(R.id.et_answer20_mi);
        et_answer20_mi_String = et_answer20_mi.getText().toString();
        if (et_answer20_mi_String.isEmpty()) {
            databaseReference.child(tv_question20_StringEncode).child("Mention it").setValue("");
        } else {
            databaseReference.child(tv_question20_StringEncode).child("Mention it").setValue(et_answer20_mi_String);
        }
    }

    //  III. SOCIO ECONOMIC GROWTH OF FAMILY
    void question21() {
        tv_question21 = findViewById(R.id.tv_question21);
        tv_question21_StringEncode = EncodeString(tv_question21.getText().toString());

        //  YES (or) NO
        rg_21 = findViewById(R.id.rg_21);
        if (rg_21.getCheckedRadioButtonId() != -1) {
            int selectedId21 = rg_21.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId21);
            rb_answer21_String = radioButton.getText().toString();
            databaseReference.child(tv_question21_StringEncode).child("Yes (or) No").setValue(rb_answer21_String);
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question21_StringEncode).child("Yes (or) No").setValue("");
            databaseReference.keepSynced(true);
        }

        //  MENTION HOW?
        et_answer21_mh = findViewById(R.id.et_answer21_mh);
        et_answer21_mh_String = et_answer21_mh.getText().toString();
        if (et_answer21_mh_String.isEmpty()) {
            databaseReference.child(tv_question21_StringEncode).child("Mention how?").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question21_StringEncode).child("Mention how?").setValue(et_answer21_mh_String);
            databaseReference.keepSynced(true);
        }

        //  WHY?
        et_answer21_why = findViewById(R.id.et_answer21_why);
        et_answer21_why_String = et_answer21_why.getText().toString();
        if (et_answer21_why_String.isEmpty()) {
            databaseReference.child(tv_question21_StringEncode).child("Why?").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question21_StringEncode).child("Why?").setValue(et_answer21_why_String);
            databaseReference.keepSynced(true);
        }
    }

    void question22() {
        tv_question22 = findViewById(R.id.tv_question22);
        tv_question22_StringEncode = EncodeString(tv_question22.getText().toString());

        //  HOW MUCH ARE YOU SAVING PER YEAR?
        et_answer22_hm = findViewById(R.id.et_answer22_hm);
        et_answer22_hm_String = et_answer22_hm.getText().toString();
        if (et_answer22_hm_String.isEmpty()) {
            databaseReference.child(tv_question22_StringEncode).child("How much are you saving per year?").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question22_StringEncode).child("How much are you saving per year?").setValue(et_answer22_hm_String);
            databaseReference.keepSynced(true);
        }

        //  WHY?
        et_answer22_why = findViewById(R.id.et_answer22_why);
        et_answer22_why_String = et_answer22_why.getText().toString();
        if (et_answer22_why_String.isEmpty()) {
            databaseReference.child(tv_question22_StringEncode).child("Why?").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question22_StringEncode).child("Why?").setValue(et_answer22_why_String);
            databaseReference.keepSynced(true);
        }
    }

    void question23() {
        tv_question23 = findViewById(R.id.tv_question23);
        tv_question23_StringEncode = EncodeString(tv_question23.getText().toString());

        //  YES (or) NO
        rg_23 = findViewById(R.id.rg_23);
        if (rg_23.getCheckedRadioButtonId() != -1) {
            int selectedId23 = rg_23.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId23);
            rb_answer23_String = radioButton.getText().toString();
            databaseReference.child(tv_question23_StringEncode).child("Yes (or) No").setValue(rb_answer23_String);
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question23_StringEncode).child("Yes (or) No").setValue("");
            databaseReference.keepSynced(true);
        }
    }

    void question24() {
        tv_question24 = findViewById(R.id.tv_question24);
        tv_question24_StringEncode = EncodeString(tv_question24.getText().toString());

        //
        et_answer24 = findViewById(R.id.et_answer24);
        et_answer24_String = et_answer24.getText().toString();
        if (et_answer24_String.isEmpty()) {
            databaseReference.child(tv_question24_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question24_StringEncode).setValue(et_answer24_String);
            databaseReference.keepSynced(true);
        }
    }

    void question25() {
        tv_question25 = findViewById(R.id.tv_question25);
        tv_question25_StringEncode = EncodeString(tv_question25.getText().toString());

        //
        et_answer25 = findViewById(R.id.et_answer25);
        et_answer25_String = et_answer25.getText().toString();
        if (et_answer25_String.isEmpty()) {
            databaseReference.child(tv_question25_StringEncode).setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question25_StringEncode).setValue(et_answer25_String);
            databaseReference.keepSynced(true);
        }
    }

    void question26() {
        tv_question26 = findViewById(R.id.tv_question26);
        tv_question26_StringEncode = EncodeString(tv_question26.getText().toString());

        //  YES (or) NO
        rg_26 = findViewById(R.id.rg_26);
        if (rg_26.getCheckedRadioButtonId() != -1) {
            int selectedId26 = rg_26.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId26);
            rb_answer26_String = radioButton.getText().toString();
            databaseReference.child(tv_question26_StringEncode).child("Yes (or) No").setValue(rb_answer26_String);
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question26_StringEncode).child("Yes (or) No").setValue("");
            databaseReference.keepSynced(true);
        }

        //  HOW?
        et_answer26_how = findViewById(R.id.et_answer26_how);
        et_answer26_how_String = et_answer26_how.getText().toString();
        if (et_answer26_how_String.isEmpty()) {
            databaseReference.child(tv_question26_StringEncode).child("How?").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question26_StringEncode).child("How?").setValue(et_answer26_how_String);
            databaseReference.keepSynced(true);
        }

        //  WHY?
        et_answer26_why = findViewById(R.id.et_answer26_why);
        et_answer26_why_String = et_answer26_why.getText().toString();
        if (et_answer26_why_String.isEmpty()) {
            databaseReference.child(tv_question26_StringEncode).child("Why?").setValue("");
            databaseReference.keepSynced(true);
        } else {
            databaseReference.child(tv_question26_StringEncode).child("Why?").setValue(et_answer26_why_String);
            databaseReference.keepSynced(true);
        }
    }

    public static String EncodeString(String string) {
        return string.replaceAll("[./]", ",");
    }
}