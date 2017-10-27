package fr.hirsonf.jobbermeister.activities;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import fr.hirsonf.jobbermeister.cards.AdCard;
import fr.hirsonf.jobbermeister.model.Offer;
import fr.hirsonf.jobbermeister.R;
import fr.hirsonf.jobbermeister.cards.Utils;

/**
 * Created by flohi on 26/10/2017.
 */

public class BrowseOffersActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_offers);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        int bottomMargin = Utils.dpToPx(160);
        Point windowSize = Utils.getDisplaySize(getWindowManager());
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth(windowSize.x)
                        .setViewHeight(windowSize.y - bottomMargin)
                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.ad_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.ad_swipe_out_msg_view));


        for(Offer offer : Utils.loadProfiles(this.getApplicationContext())){
            mSwipeView.addView(new AdCard(mContext, offer, mSwipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mSwipeView.doSwipe(true);
            }
        });
    }
}
