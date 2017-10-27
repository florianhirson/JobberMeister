package fr.hirsonf.jobbermeister.cards;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

import fr.hirsonf.jobbermeister.R;
import fr.hirsonf.jobbermeister.model.Offer;

/**
 * Created by flohi on 26/10/2017.
 */

@Layout(R.layout.ad_card_view)
public class AdCard {

    @View(R.id.imageViewLogo)
    private ImageView imageViewLogo;

    @View(R.id.textViewLibelle)
    private TextView textViewLibelle;

    @View(R.id.textViewEmployerLogin)
    private TextView textViewEmployerLogin;

    @View(R.id.textViewId)
    private TextView textViewId;

    @View(R.id.textViewType)
    private TextView textViewtype;


    private Offer offer;
    private Context context;
    private SwipePlaceHolderView swipeView;

    public AdCard(Context context, Offer offer, SwipePlaceHolderView swipeView) {
        this.context = context;
        this.offer = offer;
        this.swipeView = swipeView;
    }

    @Resolve
    private void onResolved() {
        Glide.with(context).load(offer.logoURL).into(imageViewLogo);
        textViewLibelle.setText(offer.libelle);
        textViewEmployerLogin.setText(offer.login);
        textViewtype.setText(offer.type);
        textViewId.setText(offer.id.toString());
    }

    @SwipeOut
    private void onSwipedOut() {
        Log.d("EVENT", "onSwipedOut");
        // swipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn() {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState() {
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState");
    }
}
