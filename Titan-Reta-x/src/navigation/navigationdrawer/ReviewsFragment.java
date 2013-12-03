package navigation.navigationdrawer;

import db.Access.DbForReviewsFragment;
import listview.adapters.CustomFragmentReviewListAdapter;
import zigtraka.nfc.reta_x.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ReviewsFragment extends Fragment {
	private ListView mReviewList;

	public ReviewsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_review, container,
				false);

		mReviewList = (ListView) rootView
				.findViewById(R.id.fragment_review_listView);
		mReviewList.setAdapter(new CustomFragmentReviewListAdapter(rootView
				.getContext(), android.R.layout.simple_list_item_1, DbForReviewsFragment.getReviews()));
		return rootView;
	}
}
