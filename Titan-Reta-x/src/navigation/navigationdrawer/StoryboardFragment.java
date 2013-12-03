package navigation.navigationdrawer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import deploy.appdata.directory;
import file.reader.ContentReader;
import gallery.adapter.FragmentPicturesGalleryAdapter;
import zigtraka.nfc.reta_x.R;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.renderscript.Allocation.MipmapControl;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.TextView;

public class StoryboardFragment extends Fragment {

	private MediaPlayer player;
	private ImageButton play_pause, stop;
    private Gallery gallery;
    private ArrayList<String> title;
	private ArrayList<String> content;
    private enum mPlayerState {
		notInitialized, initialized, playing, paused, stopped;
	}

	mPlayerState mState = mPlayerState.notInitialized;

	public StoryboardFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View rootView = inflater.inflate(R.layout.fragment_storyboard,
				container, false);
		
		gallery=(Gallery)rootView.findViewById(R.id.fragment_storyboard_gallery);
		
		content = ContentReader.getToFromContents("$StoryboardContent=");

		title = ContentReader.getToFromContents("$StoryboardTitle=");

		gallery.setAdapter(new FragmentPicturesGalleryAdapter(rootView.getContext(), content, title));
		play_pause = (ImageButton) rootView.findViewById(R.id.playimageButton);
		play_pause.setBackgroundResource(R.drawable.play);
		play_pause.refreshDrawableState();

		play_pause.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mState == mPlayerState.notInitialized) {
					initializeMusicPlayer(title.get((Integer) gallery.getSelectedItem()).toString());
					player.start();
					play_pause.setBackgroundResource(R.drawable.pause);
					play_pause.refreshDrawableState();
				} else if (mState == mPlayerState.playing) {
					player.pause();
					mState = mPlayerState.paused;
					play_pause.setBackgroundResource(R.drawable.play);
					play_pause.refreshDrawableState();
				} else {
					player.start();
					play_pause.setBackgroundResource(R.drawable.pause);
					play_pause.refreshDrawableState();
					mState = mPlayerState.playing;
				}

			}
		});
		stop = (ImageButton) rootView.findViewById(R.id.stopimageButton);
		stop.setBackgroundResource(R.drawable.stop);
		stop.refreshDrawableState();

		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mState == mPlayerState.playing||mState==mPlayerState.paused) {
					play_pause.setBackgroundResource(R.drawable.play);
					play_pause.refreshDrawableState();
					player.stop();
					player.release();
					mState = mPlayerState.notInitialized;
				}
			}
		});

		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(mState==mPlayerState.playing||mState==mPlayerState.paused){
					play_pause.setBackgroundResource(R.drawable.play);
					play_pause.refreshDrawableState();
					player.stop();
					player.release();
					mState = mPlayerState.notInitialized;
					initializeMusicPlayer(title.get(arg0.getSelectedItemPosition()));
					player.start();
					play_pause.setBackgroundResource(R.drawable.pause);
					play_pause.refreshDrawableState();
				}	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
//		gallery.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// TODO Auto-generated method stub
//				switch(event.getAction()){
//				case MotionEvent.ACTION_MOVE:
//					if(mState==mPlayerState.playing||mState==mPlayerState.paused){
//						play_pause.setBackgroundResource(R.drawable.play);
//						play_pause.refreshDrawableState();
//						player.stop();
//						player.release();
//						mState = mPlayerState.notInitialized;
//						initializeMusicPlayer(title.get(v.getTop()));
//						player.start();
//						play_pause.setBackgroundResource(R.drawable.pause);
//						play_pause.refreshDrawableState();
//					}
//					
//				}
//				return false;
//			}
//		});
		return rootView;
	}

	public void initializeMusicPlayer(String FileName) {
		player = new MediaPlayer();
		mState = mPlayerState.initialized;
		String path=directory.titanNebulaPicturePath
				+ "/"+FileName+".mp3";
		if(new File(path).exists()){
		try {
			player.setDataSource(path);
			player.prepare();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mState=mPlayerState.playing;
		}
	}
}
