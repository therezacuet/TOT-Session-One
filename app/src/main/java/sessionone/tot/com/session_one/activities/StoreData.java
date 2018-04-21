package sessionone.tot.com.session_one.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sessionone.tot.com.session_one.R;
import sessionone.tot.com.session_one.data.MyDBHelper;
import sessionone.tot.com.session_one.model.FormDataModel;

public class StoreData extends AppCompatActivity {

    private String name, email, gender, phone, institute;
    MyDBHelper myDBHelper;

    @BindView(R.id.input_name)
    EditText etName;
    @BindView(R.id.input_gender)
    EditText etGender;
    @BindView(R.id.input_phone)
    EditText etPhone;
    @BindView(R.id.input_email)
    EditText etEmail;
    @BindView(R.id.input_institute)
    EditText etInstitute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_save)
    void saveData() {

        name = etName.getText().toString();
        email = etName.getText().toString();
        gender = etName.getText().toString();
        phone = etName.getText().toString();
        institute = etName.getText().toString();


        FormDataModel student = new FormDataModel(name, email, gender,phone,institute);
        long inserted = myDBHelper.insertStudent(student);


        if (inserted >= 0) {
            Toast.makeText(getApplicationContext(), "Data inserted",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Data insertion failed...",
                    Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_view)
    void viewData() {
        startActivity(new Intent(StoreData.this, ViewData.class));
    }





}
