package db.Access;

import java.util.ArrayList;

import db.handler.DbConnector;
import mod.database.ModStatsInterface;
import mod.database.ReviewsTableEnum;
import android.database.Cursor;

public class DbForReviewsFragment {
	

	/**
	 *Function to get reviews data from db 
	 */
	public static ArrayList<Object> getReviews() {
		Cursor cursor = DbConnector.open().rawQuery("select * from "+ReviewsTableEnum.Reviews.TableName, null);

		String[] Names = new String[cursor.getCount()];
		float[] Ratings = new float[cursor.getCount()];
		String[] Reviews = new String[cursor.getCount()];
		
		if(cursor.moveToFirst()){
			for(int i=0;i<cursor.getCount();i++){
				Names[i]=cursor.getString(0);
				Ratings[i]=cursor.getFloat(1);
				Reviews[i]=cursor.getString(2);
				cursor.moveToNext();
			}
		}
		
		ArrayList<Object> NamesRatingRevies=new ArrayList<Object>();
		NamesRatingRevies.add(Names);
		NamesRatingRevies.add(Ratings);
		NamesRatingRevies.add(Reviews);
		
		return NamesRatingRevies;

	}

}
