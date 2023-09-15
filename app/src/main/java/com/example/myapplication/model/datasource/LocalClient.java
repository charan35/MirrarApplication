/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.model.entity.Camera;
import com.example.myapplication.model.entity.RoverManifest;
import com.example.myapplication.model.entity.RoverPicture;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe LocalClient
 *
 * Contrairement à la classe RemoteClient, celle ci se charge d'établir le lien avec le système de stockage local en base de données
 * SQLite
 *
 * */
public class LocalClient extends SQLiteOpenHelper {

    private static final String DB_NAME = "ROVER_DB";
    private static final String TABLE_NAME = "ROVERS";
    private static final int DB_VERSION = 1;

    public LocalClient(@Nullable Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String script = "CREATE TABLE " + TABLE_NAME +
                "( id INTEGER PRIMARY KEY NOT NULL, rover_name VARCHAR(255) NOT NULL, " +
                "  camera_short_name VARCHAR(255) NOT NULL, camera_long_name VARCHAR(255) NOT NULL, " +
                "date VARCHAR(255) NOT NULL, image VARCHAR(255) NOT NULL);";


        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Enregistre en base de données un nouveau rover
     *
     * @param rover le rover à enregistrer
     */
    public void storeRover(RoverPicture rover) {
        Log.i("bdd", "add rover:  " + rover.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id", rover.getId());
        values.put("rover_name", rover.getRover().getName());
        values.put("camera_short_name", rover.getCamera().getName());
        values.put("camera_long_name", rover.getCamera().getFullName());
        values.put("date", rover.getDate());
        values.put("image", rover.getImage());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    /**
     * Récupère la liste des rovers en base de données
     * */
    public List<RoverPicture> getAllRovers() {

        Log.i("bdd", "get all rovers ");

        List<RoverPicture> rovers = new ArrayList<RoverPicture>();

        String sql = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                RoverPicture rover = new RoverPicture();
                RoverManifest manifest = new RoverManifest();
                Camera camera = new Camera();

                rover.setId(Integer.parseInt(cursor.getString(0)));

                manifest.setName(cursor.getString(1));

                camera.setName(cursor.getString(2));
                camera.setFullName(cursor.getString(3));

                rover.setDate(cursor.getString(4));
                rover.setImage(cursor.getString(5));

                rover.setCamera(camera);
                rover.setRover(manifest);

                rovers.add(rover);

            } while (cursor.moveToNext());
        }

        return rovers;
    }
    /**
     * Retourne vrai si des données sont déjà stockées en base de données
     * */
    public boolean dataAlReadyExist(){

        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        return count != 0;
    }

    /**
     * Efface les données en base de données
     * */
    public void clearDatabase() {

        Log.i("db", "clear all ");

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();

    }

}