package com.cititmobilechallenge.citifit;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.cititmobilechallenge.citifit.R;
import com.cititmobilechallenge.citifit.adaptors.RewardListViewAdaptor;
import com.cititmobilechallenge.citifit.modal.RewardHolder;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

/**
 * Created by ashwiask on 10/25/2015.
 */
public class RewardActivity extends Activity {

    private TwoWayView mRewardListView = null;

    private RewardListViewAdaptor adaptor = null;

    private ArrayList<RewardHolder> mRewardList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reward);

        mRewardListView = (TwoWayView) findViewById(R.id.rewardListView);

        initList();

        adaptor = new RewardListViewAdaptor(mRewardList, this);

        mRewardListView.setAdapter(adaptor);

    }

    private void initList() {
        mRewardList = new ArrayList<>(5);
        //TODO - Fetch the data dynamically using Async Task, once the API is ready

        //Populating dummy data

        Bitmap scaledImage1 = decodeSampledBitmapFromResource(getResources(), R.drawable.r2, 200, 200);
        RewardHolder reward1 = new RewardHolder(null, null, null, null, scaledImage1);
        mRewardList.add(reward1);

        Bitmap scaledImage2 = decodeSampledBitmapFromResource(getResources(), R.drawable.r3, 200, 200);
        RewardHolder reward2 = new RewardHolder(null, null, null, null, scaledImage2);
        mRewardList.add(reward2);

        Bitmap scaledImage3 = decodeSampledBitmapFromResource(getResources(), R.drawable.r4, 200, 200);
        RewardHolder reward3 = new RewardHolder(null, null, null, null, scaledImage3);
        mRewardList.add(reward3);

        Bitmap scaledImage4 = decodeSampledBitmapFromResource(getResources(), R.drawable.r5, 200, 200);
        RewardHolder reward4 = new RewardHolder(null, null, null, null, scaledImage4);
        mRewardList.add(reward4);

        Bitmap scaledImage5 = decodeSampledBitmapFromResource(getResources(), R.drawable.r6, 200, 200);
        RewardHolder reward5 = new RewardHolder(null, null, null, null, scaledImage5);
        mRewardList.add(reward5);

    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}