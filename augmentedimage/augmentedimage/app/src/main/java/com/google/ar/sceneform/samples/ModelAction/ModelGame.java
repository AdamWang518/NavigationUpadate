package com.google.ar.sceneform.samples.ModelAction;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.ar.sceneform.samples.Models.Node;
import com.google.ar.sceneform.samples.augmentedimage.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelGame {
    RequestQueue mQueue;
    TextView questionText;
    Button yes;
    Button no;
    Button sendButton;
    String url;
    Node p;
    Node root;
    Context mContext;
    EditText questionInput;
    EditText departmentText;
    Spinner spinner;
    AlertDialog dialog;
    public ModelGame(Context context, View view){

        questionText = view.findViewById(R.id.questionText);
        yes=view.findViewById(R.id.YesButton);
        no=view.findViewById(R.id.NoButton);
        yes.setOnClickListener(yeslistener);
        no.setOnClickListener(nolistener);
        mQueue = Volley.newRequestQueue(context);
        mContext=context;
        url = context.getResources().getString(R.string.url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url+"AkinatorRequest", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("NodeLog",String.valueOf(response));
                try {
                    response=response.getJSONObject("Data");
                    Gson gson= new Gson();
                    p = gson.fromJson(response.toString(), Node.class);
                    root=p;
                    if(p.question.substring(p.question.length()-1).equals("系"))
                    {
                        questionText.setText("它是 " + p.question + "? ");
                    }
                    else{
                        questionText.setText(p.question + "? ");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(request);


    }
    View.OnClickListener yeslistener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            if(p.left!=null&&p.right!=null){
                p = p.right;
                if(p.question.substring(p.question.length()-1).equals("系"))
                {
                    questionText.setText("它是 " + p.question + "? ");

                }
                else{
                    questionText.setText(p.question + "? ");
                }
            }
            else if(p.left==null&&p.right==null){
                Toast.makeText(mContext,"系統猜對了",Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                LayoutInflater li = LayoutInflater.from(mContext);

                View v = li.inflate(R.layout.success,null);
                alertDialog.setView(v);
                dialog = alertDialog.create();
                dialog.show();
                Button successButton=v.findViewById(R.id.successButton);
                successButton.setOnClickListener(successListener);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url+"AkinatorRequest", new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("NodeLog",String.valueOf(response));
                        try {
                            response=response.getJSONObject("Data");
                            Gson gson= new Gson();
                            p = gson.fromJson(response.toString(), Node.class);
                            root=p;
                            if(p.question.substring(p.question.length()-1).equals("系"))
                            {
                                questionText.setText("它是 " + p.question + "? ");
                            }
                            else{
                                questionText.setText(p.question + "? ");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                mQueue.add(request);
            }

        }
    };
    View.OnClickListener successListener= new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    };
    View.OnClickListener sendlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            String question=questionInput.getText().toString();
            String department=departmentText.getText().toString();
            String yesno=spinner.getSelectedItem().toString();
            p.left    = new Node(p.question);
            p.right   = new Node(department);
            p.question = question;

            if(yesno.equals("否")) {
                Node temp;
                temp=p.right;
                p.right=p.left;
                p.left=temp;
            }

            Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

            String prettyJsonString = gsonPretty.toJson(root);
            Log.d("rootLog",prettyJsonString);
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(prettyJsonString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    url+"AkinatorResponse",
                    jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            dialog.dismiss();
                            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url+"AkinatorRequest", new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.d("NodeLog",String.valueOf(response));
                                    try {
                                        response=response.getJSONObject("Data");
                                        Gson gson= new Gson();
                                        p = gson.fromJson(response.toString(),Node.class);
                                        root=p;
                                        if(p.question.substring(p.question.length()-1).equals("系"))
                                        {
                                            questionText.setText("它是 " + p.question + "? ");
                                        }
                                        else{
                                            questionText.setText(p.question + "? ");
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            });
                            mQueue.add(request);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("err", error.toString());
                        }
                    }
            );
            mQueue.add(mJsonObjectRequest);

        }

    };
    View.OnClickListener nolistener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            if(p.left!=null&&p.right!=null){
                p = p.left;
                if(p.question.substring(p.question.length()-1).equals("系"))
                {
                    questionText.setText("它是 " + p.question + "? ");


                }
                else{
                    questionText.setText(p.question + "? ");
                }
            }
            else if(p.left==null&&p.right==null){
                Toast.makeText(mContext,"系統猜錯了",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                LayoutInflater li = LayoutInflater.from(mContext);

                View v = li.inflate(R.layout.dialog,null);
                alertDialog.setView(v);
                dialog = alertDialog.create();
                dialog.show();
                questionInput=v.findViewById(R.id.EditSendQuestion);
                departmentText=v.findViewById(R.id.EditSendDepartment);
                sendButton=v.findViewById(R.id.send);
                spinner=v.findViewById(R.id.spinner);
                sendButton.setOnClickListener(sendlistener);
            }
        }
    };

}
