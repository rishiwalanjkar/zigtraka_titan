package navigation.navigationdrawer;



import gallery.adapter.CustomGalleryAdapter;
import zigtraka.nfc.reta_x.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Gallery;

public class PicturesFragment extends Fragment {
	private Gallery gallery;
	public PicturesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pictures, container, false);
        gallery=(Gallery)rootView.findViewById(R.id.watchpicsgallery);
        gallery.setAdapter(new CustomGalleryAdapter(rootView.getContext()));
        return rootView;
    }
}
