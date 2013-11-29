package navigation.navigationdrawer;



import zigtraka.nfc.reta_x.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FeaturesFragment extends Fragment {
	
	public FeaturesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_features, container, false);
         
        return rootView;
    }
}
