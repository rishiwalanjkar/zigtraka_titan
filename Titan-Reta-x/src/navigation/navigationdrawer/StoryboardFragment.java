package navigation.navigationdrawer;

import java.io.IOException;

import deploy.appdata.directory;
import file.reader.ContentReader;
import zigtraka.nfc.reta_x.R;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.renderscript.Allocation.MipmapControl;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class StoryboardFragment extends Fragment {

	private TextView mContentText;
	private TextView mtitleText;
	private MediaPlayer player;
	private ImageButton play_pause, stop;

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
		mContentText = (TextView) rootView
				.findViewById(R.id.storyboardtextview);
		mtitleText = (TextView) rootView
				.findViewById(R.id.storyboardtitletextView);

		// String
		// title=ContentReader.getToFromContents("$StoryboardTitle=").toString();
		String content = ContentReader.getToFromContents("$StoryboardContent=")
				.toString();

		// if(title!=null)
		// mtitleText.setText(title);
		if (content != null)
			mContentText.setText(content);

		play_pause = (ImageButton) rootView.findViewById(R.id.playimageButton);
		play_pause.setBackgroundResource(R.drawable.play);
		play_pause.refreshDrawableState();

		play_pause.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mState == mPlayerState.notInitialized) {
					initializeMusicPlayer();
					player.start();
					mState = mPlayerState.playing;
					play_pause.setBackgroundResource(R.drawable.pause);
					play_pause.refreshDrawableState();
				} else if (mState == mPlayerState.playing) {
					player.pause();
					mState = mPlayerState.paused;
					play_pause.setBackgroundResource(R.drawable.pause);
					play_pause.refreshDrawableState();
				} else if (mState == mPlayerState.paused) {
					player.start();
					play_pause.setBackgroundResource(R.drawable.play);
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
				if (mState == mPlayerState.initialized) {
					play_pause.setBackgroundResource(R.drawable.play);
					play_pause.refreshDrawableState();
					player.stop();
					player.release();
					mState = mPlayerState.notInitialized;
				}
			}
		});

		return rootView;
	}

	public void initializeMusicPlayer() {
		player = new MediaPlayer();
		mState = mPlayerState.initialized;
		try {
			player.setDataSource(directory.titanNebulaPicturePath
					+ "/Romancing nebula.mp3");
			player.prepare();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
