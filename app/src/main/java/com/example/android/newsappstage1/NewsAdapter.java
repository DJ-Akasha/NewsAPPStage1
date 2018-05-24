package com.example.android.newsappstage1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app.
     * @param newsItems is the list of news stories, which is the data source of the adapter.
     */
    public NewsAdapter(Activity context, ArrayList<News> newsItems){
        super(context, 0, newsItems);
    }

    /**
     * Returns a list item view that displays info about the news item at the given position
     * in the list of news items.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /** Check if there is an existing list item view (called convertView) at the given position
            in the list of news items. */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item,
                    parent, false);
        }

        // Find the News object at the given position in the list of news items.
        News currentNewsItem = getItem(position);

        // Find the TextView with the view ID section_id
        TextView sectionNameView = listItemView.findViewById(R.id.section_name);
        sectionNameView.setText(currentNewsItem.getSectionName());

        TextView webTitleView = listItemView.findViewById(R.id.web_title);
        webTitleView.setText(currentNewsItem.getWebTitle());

        TextView webPublicationDate = listItemView.findViewById(R.id.web_publication_date);

        // Bits of this code found on the forum.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date date = null;
        try {
            date = simpleDateFormat.parse(currentNewsItem.getPubDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMM, yyyy kk:mm");
        String finalDate = newDateFormat.format(date);
        if (date != null) {
            webPublicationDate.setText(finalDate);
        }

        return listItemView;
    }
}
