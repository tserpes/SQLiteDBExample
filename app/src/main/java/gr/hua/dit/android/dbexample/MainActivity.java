package gr.hua.dit.android.dbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DbHelper(MainActivity.this);

        findViewById(R.id.insertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
                String phone = ((EditText)findViewById(R.id.editTextTextPhoneNumber)).getText().toString();
                ContactContract contact = new ContactContract(name,phone);
                long id = helper.insertContact(contact);
                Toast.makeText(MainActivity.this, id+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}