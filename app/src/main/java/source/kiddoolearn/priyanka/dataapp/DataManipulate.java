package source.kiddoolearn.priyanka.dataapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PRIYANKA on 06-03-2017.
 */

public class DataManipulate extends SQLiteOpenHelper {
    public DataManipulate(Context context) {
        super(context, "user.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL("create table p_table(FIRST_NAME text,LAST_NAME text,ID integer primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        arg0.execSQL("drop table if exists p_table");
        onCreate(arg0);
    }
    public boolean insertData(String FN_t,String LN_t,String ID_t)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("FIRST_NAME", FN_t);
        	cv.put("LAST_NAME", LN_t);
        cv.put("ID", ID_t);
        //cv.put("MARKS", Mark_t);
        long res=db.insert("p_table", null, cv);
        if(res==-1)
            return false;
        else
            return true;

    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from p_table", null);
        return res;


    }


}