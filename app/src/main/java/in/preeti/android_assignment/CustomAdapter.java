package in.preeti.android_assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by preeti on 29/12/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.DataHolder> {

    private Context mContext;
    private ArrayList<JsonData> mdatalist;

    public CustomAdapter(Context mContext, ArrayList<JsonData> mdatalist) {
        this.mContext = mContext;
        this.mdatalist = mdatalist;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_layout,null,false);
        DataHolder dataHolder=new DataHolder(view);
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        holder.mtxtid.setText(mdatalist.get(position).getMid());
        holder.mtxtname.setText(mdatalist.get(position).getMname());
        holder.mtxtphoneno.setText(mdatalist.get(position).getMphonenumber());
        holder.mtxtsubject.setText(mdatalist.get(position).getMsubject());

    }

    @Override
    public int getItemCount() {
        return mdatalist.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {

        private TextView mtxtid,mtxtname,mtxtphoneno,mtxtsubject;
        public DataHolder(View view) {
            super(view);

            mtxtid=view.findViewById(R.id.textViewID);
            mtxtname=view.findViewById(R.id.textViewName);
            mtxtphoneno=view.findViewById(R.id.textViewPhoneNo);
            mtxtsubject=view.findViewById(R.id.textViewSubject);
        }
    }
}
