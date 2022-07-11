package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.ar.sceneform.samples.Models.buildingModel;
import com.google.ar.sceneform.samples.augmentedimage.R;
import com.google.ar.sceneform.samples.augmentedimage.ResponseCallBack;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    View view = null;
    Context context = null;
    RequestQueue mQueue =null;
    ListView NavigationList;
    TextView industryTag,medical1Tag,medical2Tag,manageTag;
    ImageView medical1road,medical2road,manageroad,industryroad;
    Boolean clickable=false;
    private  ArrayList<buildingModel> list;
    public Navigation(Context context , View view,View Industry,View Medical1,View Medical2,View Manage,View Map,View IndustryRoad,View Medical1Road,View Medical2Road,View ManageRoad,ArrayList<buildingModel> buildingList){
        this.context = context;
        this.view = view;
        this.mQueue = Volley.newRequestQueue(context);
        buildingAdapter adapter = new buildingAdapter(context, buildingList);

        NavigationList = view.findViewById(R.id.NavigationList);
        NavigationList.setAdapter(adapter);
        NavigationList.setOnItemClickListener(itemClickListener);

        industryTag=Industry.findViewById(R.id.industry_text);
        medical1Tag=Medical1.findViewById(R.id.medical_one_text);
        medical2Tag=Medical2.findViewById(R.id.medical_two_text);
        manageTag=Manage.findViewById(R.id.manage_text);

        medical1road=Medical1Road.findViewById(R.id.medical_one_road);
        medical2road=Medical2Road.findViewById(R.id.medical_two_road);
        manageroad=ManageRoad.findViewById(R.id.manage_road);
        industryroad=IndustryRoad.findViewById(R.id.Industry_road);


        industryTag.setVisibility(View.INVISIBLE);
        medical1Tag.setVisibility(View.INVISIBLE);
        medical2Tag.setVisibility(View.INVISIBLE);
        manageTag.setVisibility(View.INVISIBLE);


        manageroad.setVisibility(View.VISIBLE);
        medical1road.setVisibility(View.VISIBLE);
        medical2road.setVisibility(View.VISIBLE);
        industryroad.setVisibility(View.VISIBLE);

//        manageroad.setVisibility(View.INVISIBLE);
//        medical1road.setVisibility(View.INVISIBLE);
//        medical2road.setVisibility(View.INVISIBLE);
//        industryroad.setVisibility(View.INVISIBLE);
    }
    public AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
            if(clickable==true){
                for (int i = 0; i < list.size(); i++) {
                    setDefault(NavigationList, i);
                }
                setSelectedItem(view);
                buildingModel model = list.get(j);
                setTag(model);
                setRoad(model);
                Log.d("departmentClick",String.valueOf(model));
                //getOptionStage1("7D8514F0-41BE-4757-9AAE-256C789FDC92");//獲取介紹
            }
            else{

            }

        }
    };
    private void setRoad(buildingModel model){
        String BuildingName=model.BuildingName;
        switch (BuildingName) {
            case "第一醫學大樓":
                manageroad.setVisibility(View.INVISIBLE);
                medical1road.setVisibility(View.VISIBLE);
                medical2road.setVisibility(View.INVISIBLE);
                industryroad.setVisibility(View.INVISIBLE);
                break;
            case "第二醫學大樓":
                manageroad.setVisibility(View.INVISIBLE);
                medical1road.setVisibility(View.INVISIBLE);
                medical2road.setVisibility(View.VISIBLE);
                industryroad.setVisibility(View.INVISIBLE);
                break;
            case "工學大樓":
                manageroad.setVisibility(View.INVISIBLE);
                medical1road.setVisibility(View.INVISIBLE);
                medical2road.setVisibility(View.INVISIBLE);
                industryroad.setVisibility(View.VISIBLE);

                break;
            case "管理大樓":
                manageroad.setVisibility(View.VISIBLE);
                medical1road.setVisibility(View.INVISIBLE);
                medical2road.setVisibility(View.INVISIBLE);
                industryroad.setVisibility(View.INVISIBLE);

                break;
        }
    }
    private void setTag(buildingModel model){
        String BuildingName=model.BuildingName;
        String Department=model.Department;
        industryTag.setVisibility(View.INVISIBLE);
        medical1Tag.setVisibility(View.INVISIBLE);
        medical2Tag.setVisibility(View.INVISIBLE);
        manageTag.setVisibility(View.INVISIBLE);
        int Floor=model.Floor;
        switch (BuildingName){
            case"第一醫學大樓":
                industryTag.setVisibility(View.INVISIBLE);
                medical1Tag.setVisibility(View.VISIBLE);
                medical2Tag.setVisibility(View.INVISIBLE);
                manageTag.setVisibility(View.INVISIBLE);
                medical1Tag.setText(BuildingName+" "+Floor+"樓");
                break;
            case"第二醫學大樓":
                industryTag.setVisibility(View.INVISIBLE);
                medical1Tag.setVisibility(View.INVISIBLE);
                medical2Tag.setVisibility(View.VISIBLE);
                manageTag.setVisibility(View.INVISIBLE);
                medical2Tag.setText(BuildingName+" "+Floor+"樓");
                break;
            case"工學大樓":
                industryTag.setVisibility(View.VISIBLE);
                medical1Tag.setVisibility(View.INVISIBLE);
                medical2Tag.setVisibility(View.INVISIBLE);
                manageTag.setVisibility(View.INVISIBLE);
                industryTag.setText(BuildingName+" "+Floor+"樓");
                break;
            case"管理大樓":
                industryTag.setVisibility(View.INVISIBLE);
                medical1Tag.setVisibility(View.INVISIBLE);
                medical2Tag.setVisibility(View.INVISIBLE);
                manageTag.setVisibility(View.VISIBLE);
                manageTag.setText(BuildingName+" "+Floor+"樓");
                break;
        }
    }
    private void setSelectedItem(View v){
        if(v!=null) {
            Log.d("setDefault","select");
            TextView title = v.findViewById(R.id.title_item);
            TextView author =v.findViewById(R.id.author_item);
            title.setTextColor(0xFFDBAA33);
            author.setTextColor(0xFFDBAA33);

        }


    }
    private void setDefault(ListView listView,int index){
        View v = listView.getChildAt(index);
        if(v!=null) {
            Log.d("setDefault","default");
            //v.findViewById(R.id.contentItem).setBackgroundColor(0xFFC9C9C8);
            TextView title = v.findViewById(R.id.title_item);
            TextView author =v.findViewById(R.id.author_item);
            LinearLayout img=v.findViewById(R.id.image);
            img.setBackgroundResource(R.drawable.list);
            title.setTextColor(0xFF8FE3FC);
            author.setTextColor(0xFF8FE3FC);
            float mDpi = context.getResources().getDisplayMetrics().densityDpi;
            Log.d("mdpi", String.valueOf(mDpi));
        }

    }
    public void refreshList(ArrayList<buildingModel> list){
        this.list=list;
        clickable=true;
        buildingAdapter adapter = new buildingAdapter(context, list);
        NavigationList.setAdapter(adapter);
        NavigationList.setClickable(true);
    }

}
