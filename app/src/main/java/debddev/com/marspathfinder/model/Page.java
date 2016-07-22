package debddev.com.marspathfinder.model;

/**
 * Created by Debde_000 on 09-07-2016.
 */
/*  This usage of plain simple Java code, rather
 *   (Plain Old Java Objects) to represent our story
 *   data in the app. This design is called POJO.
 *
 */
public class Page {

    /*  According to the design of any page, we'll have a typical image, a text,
        two button choices(here choices don't mean specifically button/any other
        widget since we're designing the model part of MVC-type software designing)
        we just design the typical structure of a page.

*/
    /* Setting variables prefix as 'm' would represent that its a member var., good practice though :) */
    private int mImageId;   //  Referencing images by their respective id's from the "drawable" folder/s
    private String mText;   //  This is the story text that will be updated every time w.r.t to a new page

    private Choice mChoice1;   /*These are to be two buttons of the page, we're using the Choice class we have created in the same package*/
    private Choice mChoice2;

    private boolean mIsFinal = false;



    public Page (int imageId, String text, Choice choice1, Choice choice2) {

        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;

    }


    /*  This same constructor is meant for page 6 and page 7 which are the last pages and have nowhere to go, i.e no buttons    */

    public Page (int imageId, String text) {

        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;

    }



/*  Setting the getter and setter methods of all member var. below for updating their data & making new pages/activities based on this page model */

    public Choice getmChoice2() {
        return mChoice2;
    }

    public void setmChoice2(Choice mChoice2) {
        this.mChoice2 = mChoice2;
    }

    public Choice getmChoice1() {
        return mChoice1;
    }

    public void setmChoice1(Choice mChoice1) {
        this.mChoice1 = mChoice1;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public boolean ismIsFinal() {
        return mIsFinal;
    }

    public void setmIsFinal(boolean mIsFinal) {
        this.mIsFinal = mIsFinal;
    }
}
