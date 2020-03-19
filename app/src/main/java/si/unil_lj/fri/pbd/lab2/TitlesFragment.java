package si.unil_lj.fri.pbd.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.ListView;


import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class TitlesFragment extends ListFragment {

    private boolean mDualPane;
    private int mCurCheckPosition = 0;

    public void onActivityCreated(Bundle savedState)
    {
        super.onActivityCreated(savedState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.titles)));

        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedState != null) {

            mCurCheckPosition = savedState.getInt("curChoice", 0);
        }

        if (mDualPane) {

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }
        else
        {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(mCurCheckPosition,true);
        }

    }


    public void onListItemClick(ListView l, View v, int position, long id)
    {
        System.out.println("onlistitemclick : "+ position);
        showDetails(position);
    }
    void showDetails(int index)
    {
        mCurCheckPosition = index;
        System.out.println("showDetails : "+index);
        System.out.println(mDualPane);
        if(mDualPane)
        {
            System.out.println("land : "+index);
            getListView().setItemChecked(index, true);
            /*
            DetailsFragment details = DetailsFragment.newInstance(index);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.details, details);
            */

            //transaction.addToBackStack(null);
            DetailsFragment details = (DetailsFragment) getFragmentManager()
                    .findFragmentById(R.id.details);

            if (details == null || details.getShownIndex() != index)
            {

                details = DetailsFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
            //transaction.commit();
        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(getActivity(),DetailsActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }

    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putInt("curChoice", mCurCheckPosition);
    }

}
