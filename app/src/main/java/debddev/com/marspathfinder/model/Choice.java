package debddev.com.marspathfinder.model;

/**
 * Created by Debde_000 on 09-07-2016.
 */
public class Choice {
    private String mText;   // Description of the choice, whether it be a button or any widget
    private int mNextPage;  // Using index of pages in array to link one another


    public Choice (String text, int nextPage) {

        mText = text;
        mNextPage = nextPage;

    }

/*  Defining getter and setter methods of all above respective member variables   */

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int getmNextPage() {
        return mNextPage;
    }

    public void setmNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }
}
