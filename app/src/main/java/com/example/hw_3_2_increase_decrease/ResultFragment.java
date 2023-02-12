package com.example.hw_3_2_increase_decrease;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    private TextView result;
    private Integer increaseDecreaseResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        getResult();
    }

    private void getResult() {
        if (getArguments() != null){
             increaseDecreaseResult = getArguments().getInt(IncreaseDecreaseFragment.KEY_FOR_SEND_RESULT);
        }
        result.setText(increaseDecreaseResult.toString());
    }

    private void initView() {
        result=requireActivity().findViewById(R.id.text_view);
    }
}