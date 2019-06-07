package pl.example.notelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editBody;
    Switch priority;
    RadioGroup radioGroup;
    Button save;
    Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_activity);

        editTitle = findViewById(R.id.editTitle);
        editBody = findViewById(R.id.editBody);
        priority = findViewById(R.id.highPriority);
        radioGroup = findViewById(R.id.radioGroup);
        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                declineNote();
            }
        });
        setSwitchLabel(); // initial text setting
        priority.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setSwitchLabel();
            }
        });
    }


    private void passData() {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int index = radioGroup.indexOfChild(radioButton);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("title", editTitle.getText().toString());
        returnIntent.putExtra("body", editBody.getText().toString());
        returnIntent.putExtra("priority", priority.isChecked());
        returnIntent.putExtra("category", index);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    private void declineNote() {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void setSwitchLabel() {
        if (priority.isChecked()) {
            priority.setText("High priority");
            priority.setContentDescription("High priority note");
        } else {
            priority.setText("Normal priority");
            priority.setContentDescription("Normal priority note");
        }
    }
}
