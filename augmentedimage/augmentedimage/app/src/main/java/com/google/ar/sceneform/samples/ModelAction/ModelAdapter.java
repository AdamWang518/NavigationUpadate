package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.ar.sceneform.samples.Models.dataModel;
import com.google.ar.sceneform.samples.augmentedimage.R;

import java.util.ArrayList;

public class ModelAdapter extends BaseAdapter {

    Context context;
    ArrayList<dataModel> list;
    private LayoutInflater myInflater;
    public ModelAdapter(Context context, ArrayList<dataModel> list){
        this.context = context;
        this.list = list;
        myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.list.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = myInflater.inflate(R.layout.list_content, null);
        dataModel dataModel = list.get(i);
        //ImageView img = v.findViewById(R.id.img_item);
        TextView title = v.findViewById(R.id.title_item);
        TextView author = v.findViewById(R.id.author_item);
        title.setText(dataModel.title);
        author.setText(dataModel.content);
        if(dataModel.imgUrl!=null) {
            //Glide.with(this.context).load(dataModel.imgUrl).into(img);
        }
        return v;
    }
}
