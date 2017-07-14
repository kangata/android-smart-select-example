package com.quetzalstudio.ata.smartselect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {
    MainActivity mainActivity;

    String[] fruits = new String[] {
      "Apple", "Banana", "Melon", "Pineapple", "Pear", "Orange"
    };

    ListView listItem;

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivity = ((MainActivity)getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listItem = (ListView) view.findViewById(R.id.list_item);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.adapter_smart_select, R.id.text_name,fruits);

        listItem.setAdapter(adapter);

        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listItem.getItemAtPosition(position);

                mainActivity.fruit = item;

                FragmentManager fragmentManager = getFragmentManager();

                MainFragment mainFragment = new MainFragment();

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, mainFragment)
                        .commit();
            }
        });

        return view;
    }
}