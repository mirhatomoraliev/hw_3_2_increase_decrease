package com.example.hw_3_2_increase_decrease;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class IncreaseDecreaseFragment extends Fragment {

    private Integer resultOfDecOrInc;
    private TextView result;
    private Button btnIncrease, btnDecrease, btnSend;
    static final String KEY_FOR_SEND_RESULT = "s";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_increase_decrease, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        showResult();
        sendResult();
    }

    private void sendResult() {


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle = new Bundle();
                bundle.putInt(KEY_FOR_SEND_RESULT, Integer.parseInt(result.getText().toString()));
                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.container, resultFragment)
                        .addToBackStack(null).commit();
            }
        });
    }

    private void showResult() {
        increaseBtn();
        decreaseBtn();
    }

    private void decreaseBtn() {
        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultOfDecOrInc = Integer.parseInt(result.getText().toString());
                if (resultOfDecOrInc>0){
                    resultOfDecOrInc--;
                }
                result.setText(resultOfDecOrInc.toString());
            }
        });
    }

    private void increaseBtn() {
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultOfDecOrInc = Integer.parseInt(result.getText().toString());
                resultOfDecOrInc++;
                result.setText(resultOfDecOrInc.toString());
            }
        });
    }

    private void initView() {
        result = requireActivity().findViewById(R.id.tv_result);
        btnIncrease = requireActivity().findViewById(R.id.btn_increase);
        btnDecrease = requireActivity().findViewById(R.id.btn_decrease);
        btnSend = requireActivity().findViewById(R.id.btn_send);
    }
}