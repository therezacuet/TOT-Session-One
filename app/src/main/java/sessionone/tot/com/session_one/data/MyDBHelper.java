package sessionone.tot.com.session_one.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


import java.util.ArrayList;

import sessionone.tot.com.session_one.model.FormDataModel;

/**
 * Created by theReza on 1/11/2018.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    public static MyDBHelper sInstance;

    public Context context;
    public static final String DB_NAME = "student_db";
    public static final int DB_VERSION = 1;
    private SQLiteDatabase mDb;
    public static final String DB_TABLE = "student_info";
    public static final String ID_FIELD = "_id";
    public static final String NAME_FIELD = "name";
    public static final String GENDER_FIELD = "gender";
    public static final String PHONE_FIELD = "phone";
    public static final String EMAIL_FIELD = "email";
    public static final String INSTITUTE_FIELD = "institute";

    public static final String DB_TABLE_SQL = "CREATE TABLE "
            + DB_TABLE + " (" + ID_FIELD + " INTEGER PRIMARY KEY, "
            + NAME_FIELD + " TEXT, " + GENDER_FIELD + " TEXT, " + PHONE_FIELD
            + " TEXT, " + EMAIL_FIELD + " TEXT," +
            INSTITUTE_FIELD + " TEXT)";


    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    public static MyDBHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MyDBHelper(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables
        db.execSQL(DB_TABLE_SQL);
        // db.execSQL("CREATE TABLE TASK (_id INTEGER PRIMARY KEY, task_name TEXT, task_description TEXT)");
        Log.e("TABLE CREATE", DB_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {


    }

    // insert
    public long insertStudent(FormDataModel s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_FIELD, s.getName());
        values.put(PHONE_FIELD, s.getPhone());
        values.put(GENDER_FIELD, s.getGender());
        values.put(EMAIL_FIELD, s.getEmail());
        values.put(INSTITUTE_FIELD,s.getInstitute());

        long inserted = db.insert(DB_TABLE, null, values);

        db.close();
        return inserted;
    }

    // query
    public ArrayList<FormDataModel> getAllStudents() {
        ArrayList<FormDataModel> allStudents = new ArrayList<FormDataModel>();
        SQLiteDatabase db = this.getReadableDatabase();

        // String[] columns={NAME_FIELD, EMAIL_FIELD, PHONE_FIELD};
        // SELECT * FROM EMPLOYEE;
        //Cursor cursor = db.query(DB_TABLE, null, null, null, null, null,null,AGE_FIELD+ " ASC");

        Cursor cursor = db.rawQuery("SELECT * FROM student_info", null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                //
                int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String name = cursor.getString(cursor
                        .getColumnIndex(NAME_FIELD));
                String gender = cursor.getString(cursor
                        .getColumnIndex(GENDER_FIELD));
                String phone = cursor.getString(cursor
                        .getColumnIndex(PHONE_FIELD));
                String email = cursor.getString(cursor
                        .getColumnIndex(EMAIL_FIELD));
                String institute = cursor.getString(cursor
                        .getColumnIndex(INSTITUTE_FIELD));


                FormDataModel st = new FormDataModel(name, gender, phone,email,institute);
                allStudents.add(st);
                cursor.moveToNext();
            }
        }
        else {
            Toast.makeText(context,"No Data Found! Please Insert Data!",Toast.LENGTH_LONG).show();
        }
        cursor.close();
        db.close();

        return allStudents;
    }


}
