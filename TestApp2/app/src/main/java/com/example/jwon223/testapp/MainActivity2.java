package com.example.jwon223.testapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main2, container, false);

        TextView usernameLabel = (TextView) rootView.findViewById(R.id.usernameLabel);
        final RatingBar ratingBar = (RatingBar)  rootView.findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                float userRating = ratingBar.getRating();

                if (userRating <= 1) {
                    stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                } else if (userRating <= 2) {
                    stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                } else if (userRating <= 3) {
                    stars.getDrawable(2).setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                } else if (userRating <= 4) {
                    stars.getDrawable(2).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
                } else if (userRating <= 5) {
                    stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                }
            }


        });

        usernameLabel.setText(getActivity().getIntent().getStringExtra("username"));

        SeekBar sizeBar = (SeekBar)  rootView.findViewById(R.id.sizeBar);
        sizeBar.setMax(255);
        sizeBar.setProgress(sizeBar.getMax());
        final ImageView imageView = (ImageView)  rootView.findViewById(R.id.imageView);

        sizeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Resources resource = getResources();
                float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, progress, resource.getDisplayMetrics());

                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) px), ((int) px));

                layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.argb(progress, 0, 102, 153));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rootView;

    }

}
