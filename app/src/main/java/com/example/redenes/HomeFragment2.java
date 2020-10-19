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
 * Use the {@link HomeFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment2 extends Fragment {

    RecyclerView recyclerView;
    List<Item> items;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment2 newInstance(String param1, String param2) {
        HomeFragment2 fragment = new HomeFragment2();
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
        items.add(new Item(R.drawable.ic_equipment, R.drawable.ic_equipment_sel, "Equipment"));
        items.add(new Item(R.drawable.ic_vehicles, R.drawable.ic_vehicles_sel, "Vehicles"));
        items.add(new Item(R.drawable.ic_daily, R.drawable.ic_daily_sel, "Daily"));
        items.add(new Item(R.drawable.ic_equipment, R.drawable.ic_equipment_sel, "Maintenance"));
        items.add(new Item(R.drawable.ic_training, R.drawable.ic_training_sel, "Training"));
        items.add(new Item(R.drawable.ic_ics, R.drawable.ic_ics_sel, "ICS"));

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerView.setAdapter(new ItemAdapter(items, this.getContext()));
        return view;
    }

}