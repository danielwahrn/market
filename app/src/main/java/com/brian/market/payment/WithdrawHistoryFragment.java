package com.brian.market.payment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.brian.market.R;
import com.brian.market.modelsList.WithdrawTransaction;
import com.brian.market.payment.adapter.TransactionAdapter;

import java.util.ArrayList;

public class WithdrawHistoryFragment extends Fragment {

    private ArrayList<WithdrawTransaction> auctionList = new ArrayList<>();
    RecyclerView recyclerView;

    TransactionAdapter auctionAdapter;

    LinearLayout emptyLayout;

    public WithdrawHistoryFragment(ArrayList<WithdrawTransaction> history) {
        // Required empty public constructor
        this.auctionList = history;
    }

    public static WithdrawHistoryFragment newInstance(ArrayList<WithdrawTransaction> history) {
        WithdrawHistoryFragment fragment = new WithdrawHistoryFragment(history);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_withdraw_history, container, false);

        auctionAdapter = new TransactionAdapter(auctionList);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(auctionAdapter);

        emptyLayout = view.findViewById(R.id.empty);
        if(auctionList.size() == 0)
            emptyLayout.setVisibility(View.VISIBLE);

        return view;
    }
}
