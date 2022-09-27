package com.example.meetinginfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static androidx.core.content.ContextCompat.getSystemService;

public class Fragment1 extends Fragment {
    EditText date,time,agenda;
    DataBaseConn dbc;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout1,container,false);
        date=view.findViewById(R.id.txtDate);
        time=view.findViewById(R.id.txtTime);
        agenda=view.findViewById(R.id.txtAgenda);
        btn=view.findViewById(R.id.btn1);

        dbc=new DataBaseConn(getActivity());    //need to initialize here only


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mdate,mTime,mAgenda;
                mdate=date.getText().toString();
                mTime=time.getText().toString();
                mAgenda=agenda.getText().toString();

               Boolean insert=dbc.insertvalue(mdate,mTime,mAgenda);
                if(insert==true){
                    Toast.makeText(getActivity(),"Data Inserted",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(),"Data NOT Inserted",Toast.LENGTH_SHORT).show();
                //txt.setText("NOT INSERTED");

            }
        });

        return view;
    }

}
