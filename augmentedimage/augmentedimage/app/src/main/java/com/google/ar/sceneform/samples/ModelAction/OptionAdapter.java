package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.ar.sceneform.samples.Models.DepartmentModel;
import com.google.ar.sceneform.samples.Models.OptionModel;
import com.google.ar.sceneform.samples.augmentedimage.R;

import java.util.ArrayList;

public class OptionAdapter extends BaseAdapter {
    Context context;
    ArrayList<OptionModel> list;
    private LayoutInflater myInflater;
    public OptionAdapter(Context context, ArrayList<OptionModel> list){
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
        OptionModel model = list.get(i);
        //ImageView img = v.findViewById(R.id.img_item);
        TextView title = v.findViewById(R.id.title_item);
        TextView author = v.findViewById(R.id.author_item);
        title.setText(model.Name);
        author.setText(model.Department);
        if(model.Image!=null) {
            //Glide.with(this.context).load(model.Image).into(img);
        }
        return v;
    }
}
