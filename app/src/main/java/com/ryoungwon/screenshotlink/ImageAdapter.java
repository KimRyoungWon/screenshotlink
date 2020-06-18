package com.ryoungwon.screenshotlink;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    Context context;
    Integer[] mThumbIds={
            R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8,
            R.drawable.img9, R.drawable.img10
    };
    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(750,750));
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(1,20,1,20);
        return imageView;
    }
}
