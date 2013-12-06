package gallery.adapter;

import java.io.File;
import java.io.FileFilter;

import zigtraka_titan.nfc.reta_x.R;

import deploy.appdata.directory;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;

public class CustomGalleryAdapter extends BaseAdapter{

	private Context mContext;
	private int mGalleryItemBackground;
    private String[] mImagePaths;
    private int mImagesCount;
    private File[] mPictures;
    private File mPicturesdirectory;
	public CustomGalleryAdapter(Context c){
		mContext = c;
		TypedArray attr =
		mContext.obtainStyledAttributes(R.styleable.HelloGallery);
		mGalleryItemBackground =
		attr.getResourceId(R.styleable.HelloGallery_android_galleryItemBackground, 0);
		attr.recycle();
		mPicturesdirectory=new File(directory.titanWatchItemPicturePath);
		mPictures=mPicturesdirectory.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
			      return file.isFile() && (file.getName().toLowerCase().endsWith(".png")||file.getName().toLowerCase().endsWith(".jpg"));
			}
		});
		   
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mPictures.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ImageView imageView = new ImageView(mContext);
		imageView.setImageBitmap(BitmapFactory.decodeFile(mPictures[position].getAbsolutePath()));
		imageView.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT, Gallery.LayoutParams.WRAP_CONTENT));
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		imageView.setBackgroundResource(mGalleryItemBackground);
		
		return imageView;
	}

}
