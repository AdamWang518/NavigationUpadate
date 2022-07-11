package com.google.ar.sceneform.samples.ModelAction;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.ar.sceneform.samples.Models.DepartmentModel;
import com.google.ar.sceneform.samples.augmentedimage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class DepartmentButton {
    View view = null;
    Context context = null;
    Button manage,medical,industry;
    String Institude="醫學院";
    String TypeID="180C275A-0AA8-4C47-B940-8E675FBB7C8B";
    RequestQueue mQueue =null;

    public DepartmentButton( Context context,View view){
        this.context = context;
        this.mQueue = Volley.newRequestQueue(context);
        this.view = view;
        //this.medicalview=medicalview;
        manage=this.view.findViewById(R.id.manage_button);
        medical=this.view.findViewById(R.id.medical_button);
        industry=this.view.findViewById(R.id.industry_button);
//        manage.setOnClickListener(buttonlistener);
//        medical.setOnClickListener(buttonlistener);
//        industry.setOnClickListener(buttonlistener);
//        medicalview.setVisibility(View.INVISIBLE);
    }
//    View.OnClickListener buttonlistener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId())
//            {
//                case R.id.manage_button:
//                    manage.setBackgroundColor(0xffD59B00);
//                    industry.setBackgroundColor(0xFFC9C9C8);
//                    medical.setBackgroundColor(0xFFC9C9C8);
//                    manage.setTextColor(0xFFFFFFFF);
//                    industry.setTextColor(0xFF888988);
//                    medical.setTextColor(0xFF888988);
//                    medicalview.setVisibility(View.VISIBLE);
//                    departmentChange(0xFFC9C9C8);
//                    Institude="管理學院";
//                    break;
//                case R.id.industry_button:
//                    manage.setBackgroundColor(0xFFC9C9C8);
//                    industry.setBackgroundColor(0xffD59B00);
//                    medical.setBackgroundColor(0xFFC9C9C8);
//                    manage.setTextColor(0xFF888988);
//                    industry.setTextColor(0xFFFFFFFF);
//                    medical.setTextColor(0xFF888988);
//                    medicalview.setVisibility(View.VISIBLE);
//                    departmentChange(0xFFC9C9C8);
//                    Institude="工學院";
//                    break;
//                case R.id.medical_button:
//                    medical.setBackgroundColor(0xffD59B00);
//                    industry.setBackgroundColor(0xFFC9C9C8);
//                    manage.setBackgroundColor(0xFFC9C9C8);
//                    manage.setTextColor(0xFF888988);
//                    industry.setTextColor(0xFF888988);
//                    medical.setTextColor(0xFFFFFFFF);
//                    medicalview.setVisibility(View.VISIBLE);
//                    departmentChange(0xFFC9C9C8);
//                    Institude="醫學院";
//                    break;
//            }
//            getDepartment();
//        }
//    };
//
//    void departmentChange(int color)
//    {
//        ListView List1=medicalview.findViewById(R.id.list);
//        ListView List2=medicalview.findViewById(R.id.child_list);
//        ImageView image=medicalview.findViewById(R.id.imageView);
//        TextView text=medicalview.findViewById(R.id.content);
//        at.markushi.ui.CircleButton button1,button2,button3;
//        button1=medicalview.findViewById(R.id.intro);
//        button2=medicalview.findViewById(R.id.department);
//        button3=medicalview.findViewById(R.id.overview);
//        List1.setVisibility(View.INVISIBLE);
//        List2.setVisibility(View.INVISIBLE);
//        image.setVisibility(View.INVISIBLE);
//        text.setVisibility(View.INVISIBLE);
//        button1.setColor(color);
//        button2.setColor(color);
//        button3.setColor(color);
//        button1.setImageResource(R.drawable.presentation);
//        button2.setImageResource(R.drawable.department);
//        button3.setImageResource(R.drawable.overview);
//    }
//
//    public void getDepartment(){
//        Log.d("testlog","AAAAa");
//        String url = this.context.getResources().getString(R.string.url);
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url + String.format("getDepartments?Institude=%s&TypeID=%s",Institude,TypeID), new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray jsonArray) {
//                ArrayList<DepartmentModel> departmentList=new ArrayList<DepartmentModel>();
//                Log.d("arraylog",String.valueOf(jsonArray));
//                for (int i=0;i< jsonArray.length();i++)
//                {
//                    try {
//                        DepartmentModel model = new DepartmentModel();
//                        JSONObject json= jsonArray.getJSONObject(i);
//                        model.ID = json.getString("ID");
//                        model.Department=json.getString("Department");
//                        model.Image=json.getString("Image");
//                        model.TypeID=json.getString("TypeID");
//                        model.Institude=json.getString("Institude");
//                        model.Name=json.getString("Name");
//                        departmentList.add(model);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                        Log.d("arraylog","L");
//                    }
//                }
//
//            }
//        },null);
//
//        this.mQueue.add(request);
//    }

}
