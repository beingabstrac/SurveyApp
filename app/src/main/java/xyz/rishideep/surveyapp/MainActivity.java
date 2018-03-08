package xyz.rishideep.surveyapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import xyz.rishideep.surveyapp.Auth.AccountSettings;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<SurveyDataSet> listData;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ProgressBar progressBar;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listData = new ArrayList<>();
        adapter = new MyAdapter(listData);
        firebaseDatabase = FirebaseDatabase.getInstance();

        GetDataFromFirebase();
    }

    void GetDataFromFirebase() {

        progressBar.setVisibility(View.VISIBLE);
        databaseReference = firebaseDatabase.getReference("surveyQuestions");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SurveyDataSet surveyDataSet = dataSnapshot.getValue(SurveyDataSet.class);
                listData.add(surveyDataSet);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        List<SurveyDataSet> listArray;

        MyAdapter(List<SurveyDataSet> List) {
            this.listArray = List;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final SurveyDataSet surveyDataSet = listArray.get(position);
            holder.tv_question.setText(surveyDataSet.getQue());
            final EditText editText = holder.et_answer;
            final Button bt_ok = holder.bt_ok;
            final Button bt_clear = holder.bt_clear;
            final Button bt_edit = holder.bt_edit;
            final TextView tv_answer = holder.tv_answer;
            final TextInputLayout et_answerLayout = holder.et_answerLayout;
            holder.bt_ok.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    String et_answer = editText.getText().toString();
                    databaseReference = firebaseDatabase.getReference(firebaseUser.getUid() + " - surveyAnswers");
                    databaseReference.child("a" + position).child("ans").setValue(et_answer);

                    bt_ok.setVisibility(View.GONE);
                    bt_clear.setVisibility(View.GONE);
                    et_answerLayout.setVisibility(View.GONE);
                    bt_edit.setVisibility(View.VISIBLE);
                    tv_answer.setText("Your answer : " + editText.getText().toString());
                    tv_answer.setVisibility(View.VISIBLE);

                    try {
                        InputMethodManager inputManager = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);

                        if (inputManager != null) {
                            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                        }
                    } catch (Exception ignored) {

                    }
                }
            });
            holder.bt_clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText.setText("");
                }
            });
            holder.bt_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bt_ok.setVisibility(View.VISIBLE);
                    bt_clear.setVisibility(View.VISIBLE);
                    et_answerLayout.setVisibility(View.VISIBLE);
                    bt_edit.setVisibility(View.GONE);
                    tv_answer.setVisibility(View.GONE);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listArray.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_question, tv_answer;
            EditText et_answer;
            Button bt_ok, bt_clear, bt_edit;
            TextInputLayout et_answerLayout;

            MyViewHolder(View itemView) {
                super(itemView);
                tv_question = itemView.findViewById(R.id.tv_question);
                tv_answer = itemView.findViewById(R.id.tv_answer);
                et_answer = itemView.findViewById(R.id.et_answer);
                bt_ok = itemView.findViewById(R.id.bt_ok);
                bt_clear = itemView.findViewById(R.id.bt_clear);
                bt_edit = itemView.findViewById(R.id.bt_edit);
                et_answerLayout = itemView.findViewById(R.id.et_answerLayout);
            }
        }
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
