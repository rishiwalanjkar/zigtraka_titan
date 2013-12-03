package db.Access;

import java.util.ArrayList;

import db.handler.DbConnector;
import mod.database.CustMainEnum;
import mod.database.ModStatsInterface;
import mod.database.ReviewsTableEnum;
import android.content.ContentValues;
import android.database.Cursor;

public class DbForFeedbackFragment {

	/**
	 * Function to add feedback to  reviews table of db
	 */
	public static void addFeedBack(String Name,float Rating,String Review) {

		ContentValues values = new ContentValues();
		
		values.put(ReviewsTableEnum.Reviews.Name, Name);
		values.put(ReviewsTableEnum.Reviews.Rating, Rating);
		values.put(ReviewsTableEnum.Reviews.Review, Review);
		
		DbConnector.open()
				.insert(ReviewsTableEnum.Reviews.TableName, null, values);
		DbConnector.close();	
	}

}
