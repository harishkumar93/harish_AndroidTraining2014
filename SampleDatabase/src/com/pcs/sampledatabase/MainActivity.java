package com.pcs.sampledatabase;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.pcs.students.Students;


public class MainActivity  extends Activity{

	private Button insertBtn;
	private Button deleteBtn;
	private Button showBtn;
	private EditText studentName;
	private EditText studentId;
	private EditText studentStream;
	private ListView listView;
	private StudentOperations studentOperations;
	public MySQliteHelper mySQliteHelper;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);	
		setContentView(R.layout.main);
		
		/**
		 * Assign the listview to display the items
		 */
		listView = (ListView)findViewById(R.id.list_view);
		
		/**
		 * Assign the three buttons declared in the xml file
		 */

		insertBtn = (Button) findViewById(R.id.insert_btn);
		deleteBtn = (Button) findViewById(R.id.delete_btn);
		showBtn = (Button) findViewById(R.id.show_btn);
		
		/**
		 * Assign the three text fields declared in the Xml File 
		 */

		studentName = (EditText) findViewById(R.id.name_edt);
		studentId = (EditText) findViewById(R.id.id_edt);
		studentStream = (EditText)findViewById(R.id.stream_edt);

        /*
         * Reference to the StudentOperations Class
         */

		studentOperations = new StudentOperations(this);
		
		
		
      /**
       * Inserts the student Records when clicked
       */

		insertBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {	

				String nameEdt = studentName.getText().toString();
				String idEdt = studentId.getText().toString();
				String authorEdt = studentStream.getText().toString();

				//Checking for EditTexts weather they are null or not
				boolean name = TextUtils.isEmpty(nameEdt);
				boolean id = TextUtils.isEmpty(idEdt);
				boolean author = TextUtils.isEmpty(authorEdt);
				
				/**
				 * Stores the details if the details are entered
				 */

				if(!name && !id && !author)
				{
					Students student = new Students();
					student.setStudentName(studentName.getText().toString());
					student.setStudentId(studentId.getText().toString());
					student.setStudentstream(studentStream.getText().toString());	
					studentOperations.addStudent(student);
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.inserted_txt), Toast.LENGTH_LONG).show();	
				}
				
				/**
				 * Asks to enter the details
				 */

				else
					Toast.makeText(MainActivity.this, getResources().getString(R.string.notInserted_txt), Toast.LENGTH_LONG).show();
			}
		});
		
		/**
		 * Delete the student records when clicked
		 */

		deleteBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				/**
				 * Refers to a method deleteAllStudents in StudentOperations class
				 */
				
				studentOperations.deleteAllStudents();
				
				Toast.makeText(MainActivity.this, getResources().getString(R.string.deleted_txt), Toast.LENGTH_LONG).show();


			}
		});
		
		/***
		 * Displays the details when show button is clicked
		 */

		showBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				/**
				 * Holds the values in the cursor
				 */
				Cursor cursor = studentOperations.getStudents();
				SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(MainActivity.this, R.layout.simple_list_item_l, cursor,
						new String[]{mySQliteHelper.STUDENT_NAME,mySQliteHelper.STUDENT_ID,mySQliteHelper.STUDENT_STREAM},
						new int[]{R.id.name_txt,R.id.id_txt,R.id.stream_txt});
				
				/**
				 * Cursor values are given to the listview
				 */
				listView.setAdapter(cursorAdapter);
				
				Toast.makeText(MainActivity.this, getResources().getString(R.string.displayed_txt),Toast.LENGTH_LONG).show();

			}
		});

	}

 
}
