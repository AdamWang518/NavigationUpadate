package com.google.ar.sceneform.samples.ModelAction;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.ar.sceneform.samples.Models.ArticleModel;
import com.google.ar.sceneform.samples.Models.DepartmentModel;
import com.google.ar.sceneform.samples.Models.OptionModel;
import com.google.ar.sceneform.samples.augmentedimage.R;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModelALL {
    String Institude;
    String TypeID;
    Integer ButtonClick;
    String departmentName;
    View view = null;
    Context context = null;
    ScrollView scrollView=null;
    at.markushi.ui.CircleButton intro,department,overview;
    ListView list1 = null;
    TextView title=null;
    TextView content=null;

    ImageView image=null;
    LinearLayout allcontent=null;
    ArrayList<DepartmentModel> selectedList = null;
    ArrayList<OptionModel> optionModelArrayList = null;
    RequestQueue mQueue =null;
    int buttonID=0;
    public ModelALL(String Name,Context context ,View view){

        getName(Name);

        this.context = context;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int densityDpi = (int)(metrics.density * 160f);
        Log.d("densityDpi", String.valueOf(densityDpi));
        this.view = view;
        this.mQueue = Volley.newRequestQueue(context);
        intro=this.view.findViewById(R.id.intro);
        overview=this.view.findViewById(R.id.overview);
        department=this.view.findViewById(R.id.department);
        list1=this.view.findViewById(R.id.list);
        //list2=this.view.findViewById(R.id.child_list);
        content=this.view.findViewById(R.id.content);
        title=this.view.findViewById(R.id.title);
        allcontent=this.view.findViewById(R.id.allcontent);
        image=this.view.findViewById(R.id.imageView);
        scrollView=this.view.findViewById(R.id.scroll);

        intro.setOnClickListener(buttonlistener);
        department.setOnClickListener(buttonlistener);
        overview.setOnClickListener(buttonlistener);

        list1.setOnItemClickListener(itemClickListener);
        //list2.setOnItemClickListener(list2ClickListener);
        list1.setVisibility(View.INVISIBLE);
        //list2.setVisibility(View.INVISIBLE);
        allcontent.setVisibility(View.INVISIBLE);
        intro.setVisibility(View.VISIBLE);
        department.setVisibility(View.VISIBLE);
        department.setVisibility(View.VISIBLE);


    }
    private void init(){


    }


    View.OnClickListener buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("departmenttest","OOO");
                switch (view.getId()) {
                    case R.id.intro:
                        if(buttonID==0||buttonID!=intro.getId())
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFD59B00);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentation);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            TypeID="10A51FE8-19E1-40EB-857C-5649B97890C8";
                            ButtonClick=1;
                            getTintro();
                            list1.setVisibility(View.VISIBLE);
                            //ModelAdapter adapter = new ModelAdapter(context,introlist);
                            //list1.setAdapter(adapter);
                            //selectedList = introlist;
                            //list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==intro.getId()&&list1.getVisibility()==View.VISIBLE)
                        {
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.INVISIBLE);
                            //list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==intro.getId()&&list1.getVisibility()==View.INVISIBLE)
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFD59B00);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentation);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            ButtonClick=1;
                            TypeID="10A51FE8-19E1-40EB-857C-5649B97890C8";
                            getTintro();
                            list1.setVisibility(View.VISIBLE);
                            //ModelAdapter adapter = new ModelAdapter(context,introlist);
                            //list1.setAdapter(adapter);
                           // selectedList = introlist;
                        }
                        break;
                    case R.id.department:
                        if(buttonID==0||buttonID!=department.getId())
                        {
                            buttonID=department.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFD59B00);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.department);
                            overview.setImageResource(R.drawable.overviewdark);
                            ButtonClick=2;
                            //getOptionStage1("7D8514F0-41BE-4757-9AAE-256C789FDC92");
                            TypeID="7d8514f0-41be-4757-9aae-256c789fdc92";

                            getInstitude();
                            list1.setVisibility(View.VISIBLE);
                            //ModelAdapter adapter = new ModelAdapter(context,departmentList);
                            //list1.setAdapter(adapter);
                           // selectedList = departmentList;
                            //list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==department.getId()&&list1.getVisibility()==View.VISIBLE)
                        {
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.INVISIBLE);
                            //list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==department.getId()&&list1.getVisibility()==View.INVISIBLE)
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFD59B00);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.department);
                            overview.setImageResource(R.drawable.overviewdark);
                            ButtonClick=2;
                            TypeID="7d8514f0-41be-4757-9aae-256c789fdc92";
                            getInstitude();
                            //getOptionStage1("7D8514F0-41BE-4757-9AAE-256C789FDC92");
                            list1.setVisibility(View.VISIBLE);
                            //ModelAdapter adapter = new ModelAdapter(context,departmentList);
                            //list1.setAdapter(adapter);
                           // selectedList = departmentList;
                        }
                        break;
                    case R.id.overview:

                        if(buttonID==0||buttonID!=overview.getId())
                        {
                            buttonID=overview.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFD59B00);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overview);
                            Log.d("departmenttest","OOO");
                            ButtonClick=3;
                            TypeID="180C275A-0AA8-4C47-B940-8E675FBB7C8B";

                            getDepartment();
                            list1.setVisibility(View.VISIBLE);

                            //selectedList = overviewList;
                            //list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==overview.getId()&&list1.getVisibility()==View.VISIBLE)
                        {
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFC9C9C8);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overviewdark);
                            list1.setVisibility(View.INVISIBLE);
                            //list2.setVisibility(View.INVISIBLE);
                            allcontent.setVisibility(View.INVISIBLE);
                        }
                        else if(buttonID==overview.getId()&&list1.getVisibility()==View.INVISIBLE)
                        {
                            buttonID=intro.getId();
                            intro.setColor(0xFFC9C9C8);
                            department.setColor(0xFFC9C9C8);
                            overview.setColor(0xFFD59B00);
                            intro.setImageResource(R.drawable.presentationdark);
                            department.setImageResource(R.drawable.departmentdark);
                            overview.setImageResource(R.drawable.overview);
                            Log.d("testbutton","OOO");
                            ButtonClick=3;
                            TypeID="180C275A-0AA8-4C47-B940-8E675FBB7C8B";
                            getDepartment();
                            list1.setVisibility(View.VISIBLE);
//                            ModelAdapter adapter = new ModelAdapter(context,overviewList);
//                            list1.setAdapter(adapter);
                           // selectedList = overviewList;
                        }
                        break;
                }
        }
    };
    public AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
            for (int i = 0; i < selectedList.size(); i++) {
                setDefault(list1, i);
            }
            setSelectedItem(view);
            DepartmentModel model = selectedList.get(j);
            scrollView.fullScroll(ScrollView.FOCUS_UP);
            if (TypeID !="180C275A-0AA8-4C47-B940-8E675FBB7C8B"){
                Log.d("typeid",TypeID);
                getArticle(model.ID);
            }
            //getOptionStage1("7D8514F0-41BE-4757-9AAE-256C789FDC92");//獲取介紹

        }
    };
    private void setDefault(ListView listView,int index){
        View v = listView.getChildAt(index);
        if(v!=null) {
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
    private void setSelectedItem(View v){
       // Log.d("listitem:", String.valueOf(listView.getCount()));
        //Log.d("listitem:", String.valueOf(index));
        //View v = listView.getChildAt(index);
        if(v!=null) {

            //v.findViewById(R.id.contentItem).setBackgroundColor(0xFFD59B00);
            TextView title = v.findViewById(R.id.title_item);
            TextView author =v.findViewById(R.id.author_item);
            //LinearLayout img=v.findViewById(R.id.image);
            //img.setBackgroundResource(R.drawable.listlight);

            if(ButtonClick==3)
            {
                departmentName=author.getText().toString();
                Log.d("depname",departmentName);
            }
            title.setTextColor(0xFFDBAA33);
            author.setTextColor(0xFFDBAA33);

        }


    }

//    public AdapterView.OnItemClickListener list2ClickListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            for (int j=0;j<optionModelArrayList.size();j++) {
//               setDefault(list2,j);
//            }
//            setSelectedItem(view);
//        }
//    };


    public  void getName(String name)
    {
        Log.d("ImageName",name);
        switch (name)
        {
            case "Industry.png":
                Institude="工學院";
                departmentName="資訊工程學系";
                break;
            case "management.png":
                Institude="管理學院";
                departmentName="";
                break;
            case "medical.png":
                Institude="醫學院";
                departmentName="醫務管理學系";
                break;
        }
    }

    public void getDepartment(){
        Log.d("getDepartmentlog","AAAAa");
        String url = this.context.getResources().getString(R.string.url);
        Log.d("linkTest",url+String.format("getDepartments?Institude=%s&TypeID=%s", Institude, TypeID));
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url + String.format("getDepartments?Institude=%s&TypeID=%s", Institude, TypeID), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                ArrayList<DepartmentModel> departmentList = new ArrayList<DepartmentModel>();
                Log.d("arraylog", String.valueOf(jsonArray));
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        DepartmentModel model = new DepartmentModel();
                        JSONObject json = jsonArray.getJSONObject(i);
                        model.ID = json.getString("ID");
                        model.Department = json.getString("Department");
                        //model.Image=json.getString("Image");
                        model.TypeID = json.getString("TypeID");
                        model.Institude = json.getString("Institude");
                        model.Name = json.getString("Name");
                        departmentList.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("arraylog", "L");
                    }
                }
                DepartmentAdapter adapter = new DepartmentAdapter(context, departmentList);
                list1.setAdapter(adapter);
                selectedList = departmentList;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("volley error",volleyError.getMessage());
            }
        });
        this.mQueue.add(request);
    }
    public void getTintro(){
        Log.d("getDepartmentlog","AAAAa");
        String url = this.context.getResources().getString(R.string.url);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url + String.format("getDepartments?Institude=%s&TypeID=%s",Institude,TypeID), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                ArrayList<DepartmentModel> departmentList=new ArrayList<DepartmentModel>();
                Log.d("arraylog",String.valueOf(jsonArray));
                for (int i=0;i< jsonArray.length();i++)
                {
                    try {
                        DepartmentModel model = new DepartmentModel();
                        JSONObject json= jsonArray.getJSONObject(i);
                        model.ID = json.getString("ID");
                        model.Department=json.getString("Department");
                        //model.Image=json.getString("Image");
                        model.TypeID=json.getString("TypeID");
                        model.Institude=json.getString("Institude");
                        model.Name=json.getString("Name");
                        departmentList.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("arraylog","L");
                    }
                }
                DepartmentAdapter adapter = new DepartmentAdapter(context,departmentList);
                list1.setAdapter(adapter);
                selectedList = departmentList;
            }
        },null);

        this.mQueue.add(request);
    }
    public void getInstitude(){
        Log.d("getDepartmentlog","AAAAa");
        String url = this.context.getResources().getString(R.string.url);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url + String.format("getOption?Department=%s&TypeID=%s",departmentName,TypeID), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                ArrayList<DepartmentModel> departmentList=new ArrayList<DepartmentModel>();
                Log.d("arraylog",String.valueOf(jsonArray));
                for (int i=0;i< jsonArray.length();i++)
                {
                    try {
                        DepartmentModel model = new DepartmentModel();
                        JSONObject json= jsonArray.getJSONObject(i);
                        model.ID = json.getString("ID");
                        model.Department=json.getString("Department");
                        //model.Image=json.getString("Image");
                        model.TypeID=json.getString("TypeID");
                        model.Name=json.getString("Name");
                        departmentList.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("arraylog","L");
                    }
                }
                DepartmentAdapter adapter = new DepartmentAdapter(context,departmentList);
                list1.setAdapter(adapter);
                selectedList = departmentList;
            }
        },null);

        this.mQueue.add(request);
    }
    public void getArticle(String CatalogID){
        String url = this.context.getResources().getString(R.string.url);
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url + String.format("getArticle?CatalogID=%s", CatalogID), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                ArticleModel model=new ArticleModel();
                try {
                    model.ID=jsonObject.getString("ID");
                    model.CatalogID=jsonObject.getString("CatalogID");
                    model.Title=jsonObject.getString("Title");
                    model.Article=jsonObject.getString("Article");
                    if(jsonObject.getString("Image")==null)
                    {
                        model.Image="";
                    }
                    else
                    {
                        model.Image=jsonObject.getString("Image");
                    }
                    setArticle(model);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("arraylog","L");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        this.mQueue.add(request);
    };
    public void setArticle(ArticleModel model)
    {
        Log.d("articleLog",model.Title);
        Log.d("articleLog",model.Article);
        title.setText(model.Title);
        content.setText(model.Article);
        if(model.Image=="")
        {
            image.setVisibility(View.GONE);
        }
        else{
            image.setVisibility(View.VISIBLE);
            Glide.with(this.context).load(model.Image).into(image);
        }
        allcontent.setVisibility(View.VISIBLE);
    }
//    public void getOptionStage1(String typeid){
//        Log.d("testlog","AAAAa");
//        String url = this.context.getResources().getString(R.string.url);
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url + String.format("getOptionStage1?TypeID=%s&Department=%s",typeid,departmentName), new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray jsonArray) {
//                optionModelArrayList=new ArrayList<OptionModel>();
//                for (int i=0;i< jsonArray.length();i++)
//                {
//                    try {
//                        OptionModel model = new OptionModel();
//                        JSONObject json= jsonArray.getJSONObject(i);
//                        model.ID = json.getString("ID");
//                        model.Department=json.getString("Department");
//                        model.Image=json.getString("Image");
//                        model.TypeID=json.getString("TypeID");
//                        model.Option=json.getString("Option");
//                        model.Name=json.getString("Name");
//                        optionModelArrayList.add(model);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                        Log.d("arraylog","L");
//                    }
//                }
//                OptionAdapter adapter = new OptionAdapter(context,optionModelArrayList);
//                list2.setAdapter(adapter);
//                list2.setVisibility(View.VISIBLE);
//
//            }
//        },null);
//
//        this.mQueue.add(request);
//    }
//
}
