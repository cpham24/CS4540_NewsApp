package edu.calstatela.cpham24.newsapp;

import android.os.AsyncTask;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by mark on 7/19/17.
 */

// copied from Mark's NYTimesMostPopular example, and adapted to fit my news app
public class NewsRefreshJob extends JobService {
    AsyncTask mBackgroundTask;

    @Override
    public boolean onStartJob(final JobParameters job) {
            mBackgroundTask = new AsyncTask() {
            @Override
            protected void onPreExecute() {
                // modified the text of the Toast prompt to avoid conflicts with Mark's NYTimesMostPopular example
                // since I also have the example on my phone and it's unclear which one is refreshing
                Toast.makeText(NewsRefreshJob.this, "TNW Most Currents is up to date", Toast.LENGTH_SHORT).show();
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Object[] params) {
                RefreshTask.refreshArticles(NewsRefreshJob.this);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                jobFinished(job, false);
                super.onPostExecute(o);

            }
        };


        mBackgroundTask.execute();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {

        if (mBackgroundTask != null) mBackgroundTask.cancel(false);

        return true;
    }
}
