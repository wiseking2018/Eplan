package com.wisekingtech.eplan.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qmuiteam.qmui.util.QMUIPackageHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.wisekingtech.eplan.R;
import com.wisekingtech.eplan.arch.QMUIFragment;
import com.wisekingtech.eplan.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BlankFragment extends BaseFragment {

    @Override
    public View onCreateView() {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blank, container, false);
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank, null);
        ButterKnife.bind(this, root);
        return root;
    }

}
