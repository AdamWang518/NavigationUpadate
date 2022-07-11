package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.ar.sceneform.samples.augmentedimage.R;
public class SwitchTest {
    private String name;
    private Context context;
    private  View view;
    private ImageView image;
    public SwitchTest(String name, Context context, View view)
    {
        this.name=name;
        this.context=context;
        this.view=view;
        image=this.view.findViewById(R.id.image);
        Log.d("bugname",name);
        ImageSwitcher(name);
    }
    public void ImageSwitcher(String name)
    {
        switch (name)
        {
            case "industry.png":
                image.setImageResource(R.drawable.cat);
                break;
            case "management.png":
                image.setImageResource(R.drawable.kitten);
                break;
            case "medical.png":
                image.setImageResource(R.drawable.dog);
                break;
        }
    }

}
