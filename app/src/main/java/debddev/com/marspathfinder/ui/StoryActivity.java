package debddev.com.marspathfinder.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import debddev.com.marspathfinder.R;
import debddev.com.marspathfinder.model.Page;
import debddev.com.marspathfinder.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();

    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_value));

        if (mName == null) {
            mName = "Friend";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);
        loadPage(0);
    }

    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getmImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getmText();

        // Add the name if placeholder included, won't add if no placeholder, for ex. "%1$s" in story class page text field, see when the story includes your entered name inside
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);



        if (mCurrentPage.ismIsFinal()) {

            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        } else {

            mChoice1.setText(mCurrentPage.getmChoice1().getmText());
            mChoice2.setText(mCurrentPage.getmChoice2().getmText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getmChoice1().getmNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getmChoice2().getmNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
