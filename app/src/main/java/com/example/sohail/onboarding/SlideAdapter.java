package com.example.sohail.onboarding;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SlideAdapter(Context context)
    {
        this.context = context;
    }

    // list of images
    public int[] list_images = {
      R.drawable.image_1,
      R.drawable.image_2,
      R.drawable.image_3,
      R.drawable.image_4
    };
    // list of titles
    public String[] list_titles = {
      "Astronut","Satillite","Galaxy","Rocket"
    };
    //list of descriptions
    public String[] list_desctription = {
        "Description 1","Description 2","Description 3","Description 4"
    };
    //list of background colors
    public int[] list_colors = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };

    @Override
    public int getCount() {
        return list_titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.XmlSlide1);
        ImageView imageView = (ImageView) view.findViewById(R.id.img1);
        TextView textView = (TextView) view.findViewById(R.id.XmlTitle);
        TextView textView1 = (TextView) view.findViewById(R.id.XmlDesc);
        layout.setBackgroundColor(list_colors[position]);
        imageView.setImageResource(list_images[position]);
        textView.setText(list_titles[position]);
        textView1.setText(list_desctription[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
