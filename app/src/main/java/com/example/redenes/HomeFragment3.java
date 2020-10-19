package com.example.redenes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment3 extends Fragment {

    RecyclerView recyclerView;
    List<Item> items;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment3 newInstance(String param1, String param2) {
        HomeFragment3 fragment = new HomeFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        items = new ArrayList<>();
        items.add(new Item(R.drawable.ic_trigger, R.drawable.ic_trigger_sel, "E-Trigger"));
        items.add(new Item(R.drawable.ic_messages, R.drawable.ic_messages_sel, "Messages"));
        items.add(new Item(R.drawable.ic_incidents, R.drawable.ic_incidents_sel, "Incidents"));
        items.add(new Item(R.drawable.ic_new_incident, R.drawable.ic_new_incident_sel, "New Incident"));
        items.add(new Item(R.drawable.ic_audio, R.drawable.ic_audio_sel, "Audio"));
        items.add(new Item(R.drawable.ic_neighboring, R.drawable.ic_neighboring_sel, "Neighboring"));

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerView.setAdapter(new ItemAdapter(items, this.getContext()));
        return view;
    }
}