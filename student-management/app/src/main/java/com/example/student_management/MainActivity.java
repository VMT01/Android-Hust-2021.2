package com.example.student_management;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler dbHandler;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new DatabaseHandler(this);
        listView = findViewById(R.id.list_view);

//        Open DB and gen fake data
//        String path = getFilesDir() + "/mydb";
//        try {
//            dbHandler.onCreate(SQLiteDatabase.openDatabase(path, null,SQLiteDatabase.CREATE_IF_NECESSARY));
//            Faker faker = new Faker();
//            for (int i = 0; i < 5; i++) {
//                dbHandler.addStudent(new Student(faker.number.number(8).toString(), faker.name.name(), faker.internet.email(), faker.date.toString()));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        Cursor cursor = dbHandler.getAllStudents();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String studentID = cursor.getString(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String birthday = cursor.getString(3);
            Log.v("LOG", studentID + " --- " + name + " --- " + email + " --- " + birthday);
//            Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cursor.moveToNext();
        }
        ItemAdapter itemAdapter = new ItemAdapter(cursor);
        listView.setAdapter(itemAdapter);
    }

}