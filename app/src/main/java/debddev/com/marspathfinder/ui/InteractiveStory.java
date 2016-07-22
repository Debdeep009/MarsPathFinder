package debddev.com.marspathfinder.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import debddev.com.marspathfinder.R;

public class InteractiveStory extends AppCompatActivity {

    private EditText mFirstEditText;
    private Button  mFirstPageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_story);

        mFirstEditText = (EditText) findViewById(R.id.nameEditText);
        mFirstPageButton = (Button) findViewById(R.id.startButton);

        mFirstPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mFirstEditText.getText().toString();
                startStory(name);
            }
        });
    }
    public void startStory(String name) {
        Intent nextPage = new Intent(this, StoryActivity.class);
        nextPage.putExtra(getString(R.string.key_value),name);
        startActivity(nextPage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirstEditText.setText("");
    }
}
