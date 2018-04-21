package sessionone.tot.com.session_one.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sessionone.tot.com.session_one.R;

import java.io.ByteArrayInputStream;
import java.util.List;

import sessionone.tot.com.session_one.model.FormDataModel;

/**
 * Created by theReza on 1/11/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Myholder> {
    List<FormDataModel> dataModelArrayList;

    public RecyclerViewAdapter(List<FormDataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView name,email,gender,phone, institute;

        public Myholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tv_name);
            email = (TextView) itemView.findViewById(R.id.tv_email);
            gender = (TextView) itemView.findViewById(R.id.tv_gender);
            phone = (TextView) itemView.findViewById(R.id.tv_phone);
            institute = (TextView) itemView.findViewById(R.id.tv_institute);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        FormDataModel dataModel=dataModelArrayList.get(position);
        holder.name.setText(dataModel.getName());
        holder.gender.setText(dataModel.getGender());
        holder.email.setText(dataModel.getEmail());
        holder.phone.setText(dataModel.getPhone());
        holder.institute.setText(dataModel.getInstitute());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
