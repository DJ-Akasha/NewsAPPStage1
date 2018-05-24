package com.example.android.newsappstage1;

/**
 * {@link News} represents a news item. It holds the details of that
 * news item such as section id, the web title and the mDate it was
 * published.
 */
public class News {

    /** Section ID of the news item */
    private final String mSectionName;

    /** Web title of the news item */
    private final String mWebTitle;

    /** Date the news item was published */
    private final String mDate;

    /** Website URL of the earthquake */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     * @param sectionName
     * @param webTitle
     * @param webPubDate
     */
    public News(String sectionName, String webPubDate, String webTitle, String url) {
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mDate = webPubDate;
        mUrl = url;
    }

    /**
     * Returns the section ID for the news story.
     */
    public String getSectionName() {
        return mSectionName;
    }

    /**
     * Returns the title of the news story.
     */
    public String getWebTitle() {
        return mWebTitle;
    }

    /**
     * Returns the date the news story was published.
     */
    public String getPubDate() {
        return mDate;
    }

    /**
     * Returns the website URL to go to the full article/news story.
     */
    public String getUrl() {
        return mUrl;
    }
}
