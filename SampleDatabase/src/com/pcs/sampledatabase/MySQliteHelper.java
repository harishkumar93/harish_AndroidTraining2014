package com.pcs.sampledatabase;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQliteHelper  extends SQLiteOpenHelper{

	public static final String TABLE_NAME  = "StudentInfo";
	
	public static final String STUDENT_ID = "_id";
	public static final String STUDENT_NAME = "_name";
	public static final String STUDENT_STREAM = "_stream";

	private static final String DATABASE_NAME = "StudentDataBase";
	private static  final int DATABASE_VERSION = 1;

	private static final String DATABASE_CREATE_TABLE = "CREATE TABLE "
			+ TABLE_NAME + "(" +STUDENT_ID +" INTEGER," + STUDENT_NAME +" TEXT," +STUDENT_STREAM +" STRING);";



/***
 * The constructor from StudentOperations is redirected to this constructor
 * @param context
 */
	public MySQliteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

/***
 * Creates the Student Database
 */

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_TABLE);

	}
	
	/***
	 * Upgrades the database if there is any change in the schema
	 */

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		db.execSQL("DROP TABLE IF EXISTS  " +TABLE_NAME);
		onCreate(db);


	}

	


}
