package joel.barba;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class CMultiLlistesLayout extends HorizontalScrollView {

	private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;
 
    private ArrayList<vista1> mItems = null;
    private GestureDetector mGestureDetector;
    private int mActiveFeature = 0;
 
    public CMultiLlistesLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
 
    public CMultiLlistesLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    public CMultiLlistesLayout(Context context) {
        super(context);
    }
    
    public void setFeatureItems(ArrayList<vista1> items){
        //Create a linear layout to hold each screen in the scroll view
        LinearLayout internalWrapper = new LinearLayout(getContext());
        internalWrapper.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        internalWrapper.setOrientation(LinearLayout.HORIZONTAL);
        addView(internalWrapper);
        this.mItems = items;
        for(int i = 0; i < items.size(); i++){
            // creació dinàmica de la vista
            //internalWrapper.addView(myView);
        }
  
    
        

    }    
    
}
