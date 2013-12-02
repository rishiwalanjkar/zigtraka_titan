package deploy.appdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import zigtraka_titan.nfc.reta_x.MyDatabaseHelper;


public class Creator implements directory {
	private static File file, logfile, dbfile;
	private static OutputStream Destination;
	private static InputStream Source;
	private static String DB_NAME = "mod.sqlite";

	public static void deploy(Context applicationContext) {
		try {
		new File(directory.databaseFolderPath).mkdirs();
		new File(directory.titanWatchesPath).mkdirs();
		new File(directory.titanNebulaPath).mkdirs();
		new File(directory.titanNebulaContentPath).mkdirs();
		new File(directory.titanNebulaPicturePath).mkdirs();
		new File(directory.titanNebulaReviewPath).mkdirs();
		new File(directory.titanNebulaMiscPath).mkdirs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
