package sessionone.tot.com.session_one.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sessionone.tot.com.session_one.R;
import sessionone.tot.com.session_one.adapter.RecyclerViewAdapter;
import sessionone.tot.com.session_one.data.MyDBHelper;
import sessionone.tot.com.session_one.model.FormDataModel;

public class ViewData extends AppCompatActivity {

    ArrayList<FormDataModel> datamodel;
    MyDBHelper dbHelper;


    @BindView(R.id.rv_view_data)
    RecyclerView rvViewData;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        ButterKnife.bind(this);
        initVariable();
        populateList();
    }

    private void initVariable() {
        datamodel =new ArrayList<FormDataModel>();
        dbHelper = new MyDBHelper(ViewData.this);
        datamodel=  dbHelper.getAllStudents();
    }

    private void populateList(){
        if (datamodel.isEmpty()){
            rvViewData.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        }else {
            RecyclerViewAdapter mAdapter =new RecyclerViewAdapter(datamodel);
            rvViewData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rvViewData.setAdapter(mAdapter);
        }
    }


}
