/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ar.sceneform.samples.augmentedimage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.FixedWidthViewSizer;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.samples.ModelAction.ModelALL;
import com.google.ar.sceneform.samples.ModelAction.ModelGame;
import com.google.ar.sceneform.samples.ModelAction.ModelMap;
import com.google.ar.sceneform.samples.ModelAction.ModelTag;
import com.google.ar.sceneform.samples.ModelAction.Navigation;
import com.google.ar.sceneform.samples.ModelAction.NavigationMap;
import com.google.ar.sceneform.samples.ModelAction.SwitchTest;
import com.google.ar.sceneform.samples.Models.buildingModel;


import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * Node for rendering an augmented image. The image is framed by placing the virtual picture frame
 * at the corners of the augmented image trackable.
 */
@SuppressWarnings({"AndroidApiChecker"})
public class AugmentedImageNode extends AnchorNode {


    private static CompletableFuture<ModelRenderable> ulCorner;
    private static CompletableFuture<ModelRenderable> urCorner;
    private static CompletableFuture<ModelRenderable> lrCorner;
    private static CompletableFuture<ModelRenderable> llCorner;

    private static CompletableFuture<ViewRenderable> MedicalALLRenderable;

    private static CompletableFuture<ViewRenderable> DepartmentButtonRenderable;
    private static CompletableFuture<ViewRenderable> IndustryTagRenderable;
    private static CompletableFuture<ViewRenderable> MedicalOneTagRenderable;
    private static CompletableFuture<ViewRenderable> ManageTagRenderable;
    private static CompletableFuture<ViewRenderable> MedicalTwoTagRenderable;

    private static CompletableFuture<ViewRenderable> MedicalOneRoadRenderable;
    private static CompletableFuture<ViewRenderable> MedicalTwoRoadRenderable;
    private static CompletableFuture<ViewRenderable> IndustryRoadRenderable;
    private static CompletableFuture<ViewRenderable> ManageRoadRenderable;

    private static CompletableFuture<ViewRenderable> SwitchRenderable;

    private static CompletableFuture<ViewRenderable> NavigationListRenderable;
    private static CompletableFuture<ViewRenderable> NavigationMapRenderable;

    private static CompletableFuture<ViewRenderable> GameRenderable;

    private   View medicalview;
    private   View MedicalOneTag,MedicalTwoTag,IndustryTag,ManageTag,NavigationMap,Navigation,MedicalOneRoad,MedicalTwoRoad,IndustryRoad,ManageRoad;

    private Anchor anchor = null;
    private String Name;
    private  Context context;
    public Navigation Map;
    public AugmentedImageNode(Context context) {
        // Upon construction, start loading the models for the corners of the frame.
//    if (ulCorner == null) {
//      ulCorner =
//          ModelRenderable.builder()
//              .setSource(context, Uri.parse("models/frame_upper_left.sfb"))
//              .build();
//      urCorner =
//          ModelRenderable.builder()
//              .setSource(context, Uri.parse("models/frame_upper_right.sfb"))
//              .build();
//      llCorner =
//          ModelRenderable.builder()
//              .setSource(context, Uri.parse("models/frame_lower_left.sfb"))
//              .build();
//      lrCorner =
//          ModelRenderable.builder()
//              .setSource(context, Uri.parse("models/frame_lower_right.sfb"))
//              .build();
//
//
//    }

//    CGUImageRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.cguimage).build();
//    CGUListRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.25f)).setView(context,R.layout.cgulist).build();
//    CGUImageRenderable.thenAccept( (renderable) -> {
//          InfoLayout=renderable.getView();
//    });
//    CGUListRebderable.thenAccept(
//            (renderable) -> {
//                ListLayout=renderable.getView();
//                ModelList modelList = new ModelList(context,ListLayout,InfoLayout);
//                modelList.setListView((department_name));
//            });
        this.context=context;
        IndustryTagRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.industry_building_tag).build();
        MedicalOneTagRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.medical_one_building_tag).build();
        ManageTagRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.manage_building_tag).build();
        MedicalTwoTagRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.medical_two_building_tag).build();
        NavigationListRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.18f)).setView(context,R.layout.navigation_list).build();
        NavigationMapRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.25f)).setView(context,R.layout.navigation_content).build();
        MedicalALLRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.75f)).setView(context,R.layout.medical_all).build();

        MedicalOneRoadRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.6f)).setView(context,R.layout.medical_one_road).build();
        MedicalTwoRoadRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.75f)).setView(context,R.layout.medical_two_road).build();
        IndustryRoadRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.55f)).setView(context,R.layout.industry_road).build();
        ManageRoadRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.55f)).setView(context,R.layout.manage_road).build();


        SwitchRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.switch_test).build();

        DepartmentButtonRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.3f)).setView(context,R.layout.department_button).build();
        GameRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.3f)).setView(context,R.layout.game).build();
//      DepartmentButtonRenderable.thenAccept((renderable) -> {
//          View view = renderable.getView();
//          DepartmentButton intro = new DepartmentButton(context,view);
//          MedicalALLRenderable.thenAccept((Medicalrenderable) -> {
//               medicalview = Medicalrenderable.getView();
//              MedicalALLRenderable medicalALL = new ModelALL("medical",context,medicalview,view);
//          });
//
//      });



//      Content.thenAccept(
//              (ContentRenderable) -> {
//                  View Contentview = ContentRenderable.getView();
//                  ModelIntro intro = new ModelIntro("Content",context,Contentview);
//
//              });


    }






    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    public void setImage(AugmentedImage image,String Name) {
        this.Name=Name;
        // If any of the models are not loaded, then recurse when all are loaded.
//    if (!ulCorner.isDone() || !urCorner.isDone() || !llCorner.isDone() || !lrCorner.isDone()) {
//      CompletableFuture.allOf(ulCorner, urCorner, llCorner, lrCorner)
//          .thenAccept((Void aVoid) -> setImage(image,Name))
//          .exceptionally(
//              throwable -> {
//                return null;
//              });
//    }
        IndustryTagRenderable.thenAccept(
                (Renderable) -> {
                    IndustryTag = Renderable.getView();
                    ModelTag intro = new ModelTag(context,IndustryTag);
                });
        MedicalOneTagRenderable.thenAccept(
                (Renderable) -> {
                    MedicalOneTag = Renderable.getView();
                    ModelTag intro = new ModelTag(context,MedicalOneTag);
                });
        MedicalTwoTagRenderable.thenAccept(
                (Renderable) -> {
                    MedicalTwoTag = Renderable.getView();
                    ModelTag intro = new ModelTag(context,MedicalTwoTag);
                });
        ManageTagRenderable.thenAccept(
                (Renderable) -> {
                    ManageTag = Renderable.getView();
                    ModelTag intro = new ModelTag(context,ManageTag);
                });
        NavigationMapRenderable.thenAccept(
                (Renderable) -> {
                    NavigationMap = Renderable.getView();
                    NavigationMap Map = new NavigationMap(context,NavigationMap);
                });
        MedicalOneRoadRenderable.thenAccept(
                (Renderable) -> {
                    MedicalOneRoad = Renderable.getView();
                    ModelMap Map = new ModelMap(context,MedicalOneRoad);
                });
        MedicalTwoRoadRenderable.thenAccept(
                (Renderable) -> {
                    MedicalTwoRoad = Renderable.getView();
                    ModelMap Map = new ModelMap(context,MedicalTwoRoad);
                });
        IndustryRoadRenderable.thenAccept(
                (Renderable) -> {
                    IndustryRoad = Renderable.getView();
                    ModelMap Map = new ModelMap(context,IndustryRoad);
                });
        ManageRoadRenderable.thenAccept(
                (Renderable) -> {
                    ManageRoad = Renderable.getView();
                    ModelMap Map = new ModelMap(context,ManageRoad);
                });
        SwitchRenderable.thenAccept(
                (Renderable) -> {
                    View view = Renderable.getView();
                    SwitchTest intro = new SwitchTest(Name,context,view);
                });
        MedicalALLRenderable.thenAccept(

                (Renderable) -> {
                    View view = Renderable.getView();
                    ModelALL intro = new ModelALL(Name,context,view);
                }
        );
        GameRenderable.thenAccept(

                (Renderable) -> {
                    View view = Renderable.getView();
                    ModelGame game = new ModelGame(context,view);
                }
        );
        this.anchor = image.createAnchor(image.getCenterPose());
        // Set the anchor based on the center of the image.
        setAnchor(this.anchor);
        //setModelRenderable(ListButtonRebderable,0f,0.1f, -1f * 0.13f);
        Log.d("ImageName",Name) ;
        if(Name.equals("navigation.png"))
        {
            NavigationListRenderable.thenAccept(
                    (Renderable) -> {
                        Navigation = Renderable.getView();
                        ArrayList<buildingModel> buildingModels=new ArrayList<buildingModel>();
                        buildingModel defaultModel=new buildingModel(0,0,"請以語音輸入欲查找的系所","");
                        defaultModel.BuildingName="請以語音輸入欲查找的系所";
                        buildingModels.add(defaultModel);
                        this.Map = new Navigation(context,Navigation,IndustryTag,MedicalOneTag,MedicalTwoTag,ManageTag,NavigationMap,IndustryRoad,MedicalOneRoad,MedicalTwoRoad,ManageRoad,buildingModels);
                    });
            setTagRenderable(NavigationListRenderable,0f,0f,0f);//在垂直時z是上下，x是左右，y是深淺
            setTagRenderable(MedicalOneTagRenderable,-0.5f * 0.13f,1.1f * 0.13f,-1.25f * 0.13f);//水平時z是深淺，x是左右，y是上下
            setTagRenderable(MedicalTwoTagRenderable,-3f * 0.13f,1.1f * 0.13f,-1.25f * 0.13f);
            setTagRenderable(IndustryTagRenderable,0.8f * 0.13f,1.1f * 0.13f,-1.5f * 0.13f);
            setTagRenderable(ManageTagRenderable,-1.1f * 0.13f,1.1f * 0.13f,-2f * 0.13f);
            setRoadRenderable(MedicalOneRoadRenderable,-0.25f * 0.13f,0f,3.25f * 0.13f);
            setRoadRenderable(MedicalTwoRoadRenderable,-1f * 0.13f,0f,3.25f * 0.13f);//ok
            setRoadRenderable(IndustryRoadRenderable,-0.4f* 0.13f,0f,2.5f * 0.13f);//ok
            setRoadRenderable(ManageRoadRenderable,-0.25f* 0.13f,0f,2.4f * 0.13f);


            Log.d("NavigationImage","Navigation");
        }
        else if(Name.equals("game.png"))
        {
            Log.d("renderModel",Name);
            setModelRenderable(GameRenderable,0f,0f, 0f);
        }
        else if(!Name.equals("navigation.png")){
            Log.d("renderModel",Name);
            setModelRenderable(MedicalALLRenderable,-1f* 0.13f,+0.5f * 0.13f, -1f * 0.13f);
        };
        //setModelRenderable(MedicalOneTagRenderable,1f * 0.13f,0.05f, -0.5f * 0.13f);
        //setModelRenderable(IndustryTagRenderable,2f * 0.13f,0.05f, -0.5f * 0.13f);

        // setModelRenderable(SwitchRenderable,0f,+0.5f * 0.13f, +0.25f * 0.13f);
        //setModelRenderable(IndustryALLRenderable,1f* 0.13f,0.05f, -1f * 0.13f);
        // setModelRenderable(ManageALLRenderable,-1f* 0.13f,0.05f, -1f * 0.13f);

        //setButtonRenderable(DepartmentButtonRenderable,0.3f * 0.13f,0,1f * 0.13f);

        //setModelRenderable(CGUManageRebderable,-3f * image.getExtentX(), 0f, 0.5f * image.getExtentZ());//x是左右，Y
        Log.d("Sizelog", String.valueOf(image.getExtentZ()));
    }

    private void setModelRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
        Node cornerNode;
        Vector3 localPosition = new Vector3();
        localPosition.set(x,y,z);
        cornerNode = new Node();
        cornerNode.setParent(this);
        cornerNode.setLookDirection(Vector3.forward());

//      Vector3 cameraPosition = getScene().getCamera().getWorldPosition();
////      Vector3 cardPosition = cornerNode.getWorldPosition();
////      Vector3 direction = Vector3.subtract(cameraPosition, cardPosition);
////      Quaternion lookRotation = Quaternion.lookRotation(direction, Vector3.up());
////      cornerNode.setWorldRotation(lookRotation);
////      cornerNode.setLookDirection(Vector3.forward());
        cornerNode.setLocalPosition(localPosition);
        cornerNode.setRenderable(renderable.getNow(null));
    }

    private void setTagRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
        Node cornerNode;
        Vector3 localPosition = new Vector3();
        localPosition.set(x,y,z);
        cornerNode = new Node();
        cornerNode.setParent(this);
        cornerNode.setLocalPosition(localPosition);

        //cornerNode.setLookDirection(Vector3.forward());

        cornerNode.setRenderable(renderable.getNow(null));
    }
    private void setRoadRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
        Node cornerNode;
        Vector3 localPosition = new Vector3();
        localPosition.set(x,y,z);
        cornerNode = new Node();
        cornerNode.setParent(this);
        cornerNode.setLocalPosition(localPosition);
        //cornerNode.setLookDirection(Vector3.down(),Vector3.forward());
        cornerNode.setLocalRotation(Quaternion.axisAngle(new Vector3(1, 0, 0), -90f));
        cornerNode.setRenderable(renderable.getNow(null));
    }

    public  void removeAnchor(){
        this.anchor.detach();

    }

    public void initNavigation(ArrayList<buildingModel> list){
        try {
            this.Map.refreshList(list);
        }
        catch (Exception exception)
        {
            Log.d("explode",exception.getMessage());
        }


    }

}
