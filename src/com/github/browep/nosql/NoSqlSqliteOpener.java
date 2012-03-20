package com.github.browep.nosql;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.IOException;


public class NoSqlSqliteOpener extends SQLiteOpenHelper {
 
    protected static String DB_NAME = "main_db";
    private static int DB_VERSION = 1;
    private static final String[] SQL_STATEMENTS = new String[]{
        "CREATE TABLE instances(type INT, created datetime default current_timestamp, modified datetime default current_timestamp, data TEXT);",
        "CREATE TABLE indexes(instance_id INT, path VARCHAR(512)); ",
        "CREATE INDEX idx_path ON indexes(path); "};


    public NoSqlSqliteOpener(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    public NoSqlSqliteOpener(Context context,String dbName){
        super(context,dbName,null,DB_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
        for(String sqlStatement : SQL_STATEMENTS){
            db.execSQL(sqlStatement);
        }
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

  public static String getDbName() {
    return DB_NAME;
  }
}