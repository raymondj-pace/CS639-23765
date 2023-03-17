package com.example.firebaseactivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference myRef;
    private static final String TAG = "MyActivity";

    private EditText mFirstName;
    private EditText mLastName;

    private long snapShotRowCount = 0;

    private ListView simpleList;

    String[] employeeNames;

    // Auto-hide the keyboard when focus on EditText is lost
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide keyboard if it's showing on creation
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }

        mFirstName = findViewById(R.id.editTextFirstName);
        mLastName = findViewById(R.id.editTextLastName);
        simpleList = findViewById(R.id.simpleListView);

        mFirstName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        mLastName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        /// Get an instance of the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("employees");

        // Read from the database - Anonymous class
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d(TAG, dataSnapshot.toString());

                snapShotRowCount = dataSnapshot.getChildrenCount();
                Log.d(TAG, "Count is: " + snapShotRowCount);
                List<Employee> employees = new ArrayList<>();

                for (DataSnapshot postSnapshot1: dataSnapshot.getChildren()) {
                    Employee emp = postSnapshot1.getValue(Employee.class);
                    employees.add(emp);
                }

                Collections.sort(employees);

                employeeNames = new String[(int) snapShotRowCount];
                int c = 0;
                for (Employee emp: employees) {
                    employeeNames[c] = emp.toString();
                    Log.d(TAG, emp.toString());
                    c = c + 1;
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.activity_listview, R.id.textView, employeeNames); //(this, R.layout.activity_listview, R.id.textView, employeeNames);
                simpleList.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void addEmployee(View view) {
        // Get the search string from the input field.
        String firstName = mFirstName.getText().toString();
        String lastName = mLastName.getText().toString();

        if (firstName.isEmpty() || lastName.isEmpty()) {

            if (firstName.isEmpty()) {
                mFirstName.setHint("Enter first name");
            }

            if (lastName.isEmpty()) {
                mLastName.setHint("Enter last name");
            }

            Toast toast = Toast.makeText(this, "Enter first and last names", Toast.LENGTH_SHORT);
            toast.show();

            return;
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive())
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        // Clear the previous inputs
        mFirstName.setText("");
        mLastName.setText("");

        // Reset Hint values
        mFirstName.setHint("Enter first name");
        mLastName.setHint("Enter last name");

        // Return focus back to first name edit text
        mFirstName.requestFocus();
        Employee emp = new Employee(lastName, firstName);

        // Get a reference to where new entry will go - this avoids having to guess the offset
        DatabaseReference newPostRef  = myRef.push();
        newPostRef.setValue(emp);
    }
}