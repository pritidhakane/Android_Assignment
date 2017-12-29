package in.preeti.android_assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by preeti on 29/12/17.
 */

public class DBManager extends SQLiteOpenHelper {

    private Context mcontext;

    private int DATABASE_VERSION=1;
    private String DATABASE_NAME="UserData.db";
    private final String TABLE_USER_DATA="User";
    private final String COLUMN_USER_ID="UserID";
    private final String COLUMN_USER_PASSWORD="UserPassword";

    private String CREATE_TABLE_USERS= " CREATE TABLE " + TABLE_USER_DATA + "(" + COLUMN_USER_ID + " TEXT," + COLUMN_USER_PASSWORD + " TEXT)";


    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mcontext=context;
        this.DATABASE_NAME=name;
        this.DATABASE_VERSION=version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addUser(UserData userData){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_USER_ID,userData.getMuserid());
        contentValues.put(COLUMN_USER_PASSWORD,userData.getMuserpassword());
        long row=sqLiteDatabase.insert(TABLE_USER_DATA,null,contentValues);

        if (row>=0){

            Toast.makeText(mcontext,"Registered Successfully",Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(mcontext,"Registration UnSuccessful",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkUser(String username,String password){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        String selection = COLUMN_USER_ID + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        String[] selectionArgs = {username, password};

        Cursor cursor = sqLiteDatabase.query(TABLE_USER_DATA,null,selection, selectionArgs, null, null,null);

        if (cursor.getCount() > 0) {

            return true;
        }

        cursor.close();
        sqLiteDatabase.close();



        return false;
    }

}
