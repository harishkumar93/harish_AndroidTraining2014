package com.pcs.sampledatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.pcs.students.Students;

public class StudentOperations {
	
	private  MySQliteHelper dbHelper;
	
	private String[] STUDENT_TABLE_DETAILS = { MySQliteHelper.STUDENT_NAME, MySQliteHelper.STUDENT_ID, MySQliteHelper.STUDENT_STREAM };
	
	private SQLiteDatabase database;
	
	public StudentOperations(MainActivity mainActivity) {
		dbHelper = new MySQliteHelper(mainActivity);
		}


	public void open () throws SQLException
	{
		database = dbHelper.getWritableDatabase();		
	}
	
	
	public Students addStudent(Students students)
	{
		open();
		
		ContentValues values = new ContentValues();
		
		values.put(MySQliteHelper.STUDENT_NAME,students.getStudentName());
		values.put(MySQliteHelper.STUDENT_ID, students.getStudentId());
		values.put(MySQliteHelper.STUDENT_STREAM, students.getStudentstream());
		
		database.insert(MySQliteHelper.TABLE_NAME, null, values);	
	    database.close();
		return students ;
			
	}
public Cursor getStudents(){
	
	database = dbHelper.getReadableDatabase();
	Cursor c = database.query(MySQliteHelper.TABLE_NAME, null, null, null, null, null, null);
	return c;
}


public boolean deleteAllStudents() {
	int studentsCount;
	studentsCount = database.delete(MySQliteHelper.TABLE_NAME, null, null);
	return studentsCount>0;
	
	
}
}
