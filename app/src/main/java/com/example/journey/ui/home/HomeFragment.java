package com.example.journey.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.journey.R;
import com.example.journey.ReportActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button btn_start;
    private Button btn_stop;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // get the stop button and attach a listener that end tracking and begin report activity
        btn_stop = (Button) root.findViewById(R.id.end_rec_btn);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            // overridden on click method to return a result to the starter of this
            // activity
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReportActivity.class);
                startActivityForResult(intent, 16);
            }
        });

        // get the stop button and attach a listener that end tracking and begin report activity
        btn_start = (Button) root.findViewById(R.id.start_rec_btn);
        btn_start.setOnClickListener(new View.OnClickListener() {
            // overridden on click method to return a result to the starter of this
            // activity
            public void onClick(View v) {

            }
        });

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

}