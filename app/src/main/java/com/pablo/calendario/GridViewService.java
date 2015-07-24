package com.pablo.calendario;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by b036925 on 24/07/15.
 */
public class GridViewService extends RemoteViewsService {
    @Override
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new GridRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}

class GridRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private final Context contexto;
    private final int appWidgetId;

    public GridRemoteViewsFactory(Context context, Intent intent) {
        contexto = context;
        appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews rv = new RemoteViews(contexto.getPackageName(), R.layout.cell_layout);
        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
