package sessionone.tot.com.session_one.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
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
    @BindView(R.id.sp_gender)
    Spinner spGender;
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
        myDBHelper=new MyDBHelper(getApplicationContext());
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        gender = spGender.getSelectedItem().toString();
        phone = etPhone.getText().toString();
        institute = etInstitute.getText().toString();
        FormDataModel student = new FormDataModel(name, email, gender,phone,institute);
        long inserted = myDBHelper.insertStudent(student);
        if (inserted >= 0) {
            Toast.makeText(getApplicationContext(), "Data inserted",
                    Toast.LENGTH_LONG).show();
            etName.setText("");
            spGender.setPrompt(getResources().getString(R.string.spinner_title));
            etPhone.setText("");
            etEmail.setText("");
            etInstitute.setText("");
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
