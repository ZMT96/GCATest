package zmt.z.gcatest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import zmt.z.gcatest.model.Rates;

public class DatabaseHandler extends SQLiteOpenHelper {

    private String TABLE_NAME="Currencies";
    private String COLUMN_NAME="Countries";
    private String COLUMN_Currency="Rates";
    private SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, "CurrenciesInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           String sql="CREATE TABLE "+TABLE_NAME+"("+COLUMN_NAME+" CHAR, "+COLUMN_Currency+" CHAR)";
           db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData(ArrayList<Rates> arrayList){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME,"USD");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getUSD());
        contentValues.put(COLUMN_NAME,"RUB");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getRUB());
        contentValues.put(COLUMN_NAME,"KWD");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getKWD());
        contentValues.put(COLUMN_NAME,"INR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getINR());
        contentValues.put(COLUMN_NAME,"BND");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getBND());
        contentValues.put(COLUMN_NAME,"EUR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getEUR());
        contentValues.put(COLUMN_NAME,"CHF");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getCHF());
        contentValues.put(COLUMN_NAME,"ZAR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getZAR());
        contentValues.put(COLUMN_NAME,"NPR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getNPR());
        contentValues.put(COLUMN_NAME,"CNY");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getCNY());
        contentValues.put(COLUMN_NAME,"KES");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getKES());
        contentValues.put(COLUMN_NAME,"EGP");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getEGP());
        contentValues.put(COLUMN_NAME,"BDT");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getBDT());
        contentValues.put(COLUMN_NAME,"THB");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getTHB());
        contentValues.put(COLUMN_NAME,"PKR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getPKR());
        contentValues.put(COLUMN_NAME,"SAR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getSAR());
        contentValues.put(COLUMN_NAME,"LAK");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getLAK());
        contentValues.put(COLUMN_NAME,"IDR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getIDR());
        contentValues.put(COLUMN_NAME,"KHR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getKHR());
        contentValues.put(COLUMN_NAME,"SGD");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getSGD());
        contentValues.put(COLUMN_NAME,"JPY");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getJPY());
        contentValues.put(COLUMN_NAME,"LKR");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getLKR());
        contentValues.put(COLUMN_NAME,"NZD");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getNZD());
        contentValues.put(COLUMN_NAME,"CZK");
        contentValues.put(COLUMN_Currency,arrayList.get(0).getCZK());

        db=getWritableDatabase();
        db.insert(TABLE_NAME,null,contentValues);
        Log.d("Ssssss",db.getPath());
        getData();
    }

    public void getData() {
        db=getReadableDatabase();
        String sql="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            Log.d("Sss",cursor.getString(1));
        }
        cursor.close();
    }
}
