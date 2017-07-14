package com.quetzalstudio.ata.smartselect;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainFragment extends Fragment {
    private MainActivity mainActivity;

    private EditText inputName;
    private LinearLayout selectItem;
    private TextView textitem;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivity = ((MainActivity)getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        inputName = (EditText) view.findViewById(R.id.input_name);
        selectItem = (LinearLayout) view.findViewById(R.id.select_item);
        textitem = (TextView) view.findViewById(R.id.text_item);

        inputName.setText(mainActivity.name);
        textitem.setText(mainActivity.fruit);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        selectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();

                mainActivity.name = inputName.getText().toString();

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);

                ListFragment listFragment = new ListFragment();

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout,listFragment)
                        .addToBackStack("mainFragment")
                        .commit();
            }
        });
    }
}
