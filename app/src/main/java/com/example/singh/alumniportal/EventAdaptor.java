//package com.example.singh.alumniportal;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.singh.alumniportal.Model.Events;
//
//import java.util.ArrayList;
//
//public class EventAdaptor extends RecyclerView.Adapter<EventAdaptor.ViewHolder> {
//    private ArrayList<Events> list;
//    private Context context;
//
//    public EventAdaptor(Context context, ArrayList<Events> list) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout,parent,false);
//        ViewHolder viewHolder=new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if(list!=null && list.size()!=0){
//            holder.id.setText(list.get(position).getId());
//            holder.connid.setText(list.get(position).getConnid());
//            holder.subid.setText(list.get(position).getSubid());
//            holder.org_user_id.setText(list.get(position).getOrgUserId());
//            holder.org_group_id.setText(list.get(position).getOrgGroupId());
//            holder.org_user_name.setText(list.get(position).getOrgUserName());
//            holder.org_user_email.setText(list.get(position).getOrgUserEmail());
//            holder.alt_email.setText(list.get(position).getAltEmail());
//            holder.alt_mobile.setText(list.get(position).getAltMobile());
//            holder.org_emp_id.setText(list.get(position).getOrgEmployeeId());
//            holder.dob.setText(list.get(position).getDob());
//            holder.status.setText(list.get(position).getStatus());
//
//
//        }
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView id,connid,subid,org_user_id,org_group_id,org_user_name,org_user_email,alt_email,alt_mobile,org_emp_id,dob,status;
//        CardView cardView ;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            id=itemView.findViewById(R.id.emp_id);
//            connid=itemView.findViewById(R.id.connid);
//            subid=itemView.findViewById(R.id.subid);
//            org_user_id=itemView.findViewById(R.id.org_user_id);
//            org_group_id=itemView.findViewById(R.id.org_group_id);
//            org_user_name=itemView.findViewById(R.id.org_user_name);
//            org_user_email=itemView.findViewById(R.id.org_user_email);
//            alt_email=itemView.findViewById(R.id.altmail);
//            alt_mobile=itemView.findViewById(R.id.altmobile);
//            org_emp_id=itemView.findViewById(R.id.org_employee_id);
//            dob=itemView.findViewById(R.id.dob);
//            status=itemView.findViewById(R.id.status);
//
//
//
//
//
//            cardView=itemView.findViewById(R.id.card_view);
//        }
//    }
//}