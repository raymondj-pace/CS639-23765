/**
 * Ray Jennings, CS639, Spring 2023
 */

package com.example.whowroteitloader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import androidx.annotation.Nullable;

public class BookLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    public BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return WhoWroteItLoader.getBookInfo(mQueryString);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
