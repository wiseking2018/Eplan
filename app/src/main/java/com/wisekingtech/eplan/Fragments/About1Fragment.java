package com.wisekingtech.eplan.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIPackageHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.wisekingtech.eplan.R;
import com.wisekingtech.eplan.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关于界面
 * <p>
 * Created by Kayo on 2016/11/18.
 */
public class About1Fragment extends BaseFragment {

    @BindView(R.id.title_blank) TextView mVersionTextView;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank, null);
        ButterKnife.bind(this, root);
        mVersionTextView.setText("sdfsd");
         return root;
    }


    @Override
    public TransitionConfig onFetchTransitionConfig() {
        return SCALE_TRANSITION_CONFIG;
    }
}
