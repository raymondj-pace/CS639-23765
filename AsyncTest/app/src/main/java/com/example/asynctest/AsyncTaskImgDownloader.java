package com.example.asynctest;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTaskImgDownloader extends AsyncTask<String, Integer, Bitmap> {
    private Activity myActivity;

    // Constructor
    public AsyncTaskImgDownloader(Activity activity) {
        this.myActivity = activity;
    }

    @Override
    // Get the bitmap from the url and return it
    protected Bitmap doInBackground(String... strings) {
        publishProgress(0);
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }

            InputStream is = con.getInputStream();
            publishProgress(1);

            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("AsyncTaskImageDownload", "Failed to load image");
            Log.e("AsyncTaskImageDownload", e.getMessage());
        }
        return null;
    }

    @Override
    // Change the text on the textview widget
    protected void onProgressUpdate(Integer... values) {

        TextView tv = myActivity.findViewById(R.id.textview_loading);

        String s = "";

        if (values[0] == 0) {
            //s = getApplicatoinContext().getResources.getSystem().getString(R.string.image_loading);
            s = "Loading random image...";
            tv.setText(s);
        } else {
            //s = Resources.getSystem().getString(R.string.image_loaded);
            s = "Random Image:";
            tv.setText(s);
        }
    }

    @Override
    // Change the src of the imageview to the bitmap
    protected void onPostExecute(Bitmap bitmap) {
        ImageView iv = (ImageView) myActivity.findViewById(R.id.image_remote);

        if (iv == null) {
            Log.i("AsyncTaskImageDownload_onProgressUpdate", "iv null " + iv);
        }
        if (bitmap == null) {
            Log.i("AsyncTaskImageDownload_onProgressUpdate", "bitmap null " + bitmap);
        }
        if (iv != null && bitmap != null) {
            Log.i("AsyncTaskImageDownload_onProgressUpdate", "Bitmap found");
            iv.setImageBitmap(bitmap);
        } else {
            Log.i("AsyncTaskImageDownload_onProgressUpdate", "Problem with bitmap");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
