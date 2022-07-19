package com.example.student_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student_manager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    private static final  String KEY_NAME = "name";
    private static final String KEY_STUDENT_ID = "student_id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_BIRTHDAY = "birthday";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_STUDENT_ID, KEY_NAME, KEY_EMAIL, KEY_BIRTHDAY);
        db.execSQL(create_students_table);
        Log.v("LOG", "success");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_STUDENT_ID, student.getStudentID());
        values.put(KEY_EMAIL, student.getEmail());
        values.put(KEY_BIRTHDAY, student.getBirthday());

        long ret = db.insert(TABLE_NAME, null, values);
        Log.v("LOG", "ret = " + ret);
        db.close();
    }

    public Student getStudent(String studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_STUDENT_ID + " = ?", new String[] { studentId },null, null, null);
        if(cursor != null) cursor.moveToFirst();
        return new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
    }

    public Cursor getAllStudents() {
        List<Student>  studentList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
//        cursor.moveToFirst();
//
//        while(!cursor.isAfterLast()) {
//            Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
//            studentList.add(student);
//            cursor.moveToNext();
//        }
//        return studentList;
    }

    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_EMAIL, student.getEmail());
        values.put(KEY_BIRTHDAY, student.getBirthday());

        db.update(TABLE_NAME, values, KEY_STUDENT_ID + " = ?", new String[] { student.getStudentID() });
        db.close();
    }

    public void deleteStudent(String studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_STUDENT_ID + " = ?", new String[] { studentId });
        db.close();
    }

}
