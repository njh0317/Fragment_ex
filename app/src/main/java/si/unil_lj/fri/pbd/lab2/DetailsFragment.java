package si.unil_lj.fri.pbd.lab2;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {
    public static DetailsFragment newInstance(int index)
    {
        DetailsFragment f = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index",index);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex()
    {
        return getArguments().getInt("index",0);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(container == null)
            return null;

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding,padding,padding);
        scroller.addView(text);
        text.setText(getResources().getStringArray(R.array.descriptions)[getShownIndex()]);
        return scroller;

    }

}
