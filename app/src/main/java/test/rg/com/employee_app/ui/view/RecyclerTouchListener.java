package test.rg.com.employee_app.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Recycler touch listener.
 */
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

  private GestureDetector gestureDetector;
  private ClickListener clickListener;

  /**
   * Default constructor.
   *
   * @param context the context.
   * @param clickListener the click listener.
   */
  public RecyclerTouchListener(Context context, final ClickListener clickListener) {
    this.clickListener = clickListener;
    gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
      @Override
      public boolean onSingleTapUp(MotionEvent e) {
        return true;
      }
    });
  }

  @Override
  public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

    View child = rv.findChildViewUnder(e.getX(), e.getY());
    if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
      clickListener.onClick(child, rv.getChildAdapterPosition(child));
    }
    return false;
  }

  @Override
  public void onTouchEvent(RecyclerView rv, MotionEvent e) {
  }

  @Override
  public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

  }

  /**
   * Click listener interface.
   */
  public interface ClickListener {
    void onClick(View view, int position);
  }
}