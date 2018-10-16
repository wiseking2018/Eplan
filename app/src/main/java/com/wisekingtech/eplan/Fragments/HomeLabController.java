package com.wisekingtech.eplan.Fragments;

import android.content.Context;

/**
 * @author cginechen
 * @date 2016-10-20
 */

public class HomeLabController extends HomeController {

    public HomeLabController(Context context) {
        super(context);
    }

    @Override
    protected String getTitle() {
        return "Lab";
    }

    @Override
    protected ItemAdapter getItemAdapter() {
        return new ItemAdapter(getContext(), null);
    }
}
