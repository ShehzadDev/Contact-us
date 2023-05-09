package com.example.contactuspage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;


public class NextActivity extends Activity {

    private EditText mTitleEditText;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mTitleEditText = findViewById(R.id.editTextTextMultiLine);
        mMessageEditText = findViewById(R.id.editTextTextMultiLine2);

        Button sendButton = findViewById(R.id.button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mTitleEditText.getText().toString();
                String message = mMessageEditText.getText().toString();

                // Check if input fields are not empty
                if (TextUtils.isEmpty(title)) {
                    mTitleEditText.setError("Please enter a title");
                    mTitleEditText.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)) {
                    mMessageEditText.setError("Please enter a message");
                    mMessageEditText.requestFocus();
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shehzadshifa@gmail.com"}); // Replace with your recipient email

                // Show a confirmation message to the user
                Toast.makeText(getApplicationContext(), "Sending email to shehzadshifa@gmail.com", Toast.LENGTH_SHORT).show();

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });



        Button whatsappButton1 = findViewById(R.id.button2);
        whatsappButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://wa.me/923039504808"); // Replace with the recipient's phone number
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button whatsappButton2 = findViewById(R.id.button3);
        whatsappButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://wa.me/123456789"); // Replace with the recipient's phone number
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button websiteButton1 = findViewById(R.id.button4);
        websiteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.goodwordbooks.com/"); // Replace with the URL of the website
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button websiteButton2 = findViewById(R.id.button5);
        websiteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://shehzad-shifa.web.app/"); // Replace with the URL of the website
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
