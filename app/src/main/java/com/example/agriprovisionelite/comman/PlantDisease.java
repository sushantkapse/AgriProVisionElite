package com.example.agriprovisionelite.comman;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.ml.DiseaseDetection;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PlantDisease extends AppCompatActivity {



    TextView result,demoText,classified,clickhere;
    ImageView imageView,arrowImage;
    ImageButton picture;
    int imageSize=224;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_disease);

        result=findViewById(R.id.result);
        imageView=findViewById(R.id.imageView);
        picture=findViewById(R.id.button);
        demoText=findViewById(R.id.demoText);
        clickhere=findViewById(R.id.click_here);
        classified=findViewById(R.id.clssified);
        arrowImage=findViewById(R.id.demoArrow);



        demoText.setVisibility(View.VISIBLE);
        clickhere.setVisibility(View.GONE);
        arrowImage.setVisibility(View.VISIBLE);
        classified.setVisibility(View.GONE);
        result.setVisibility(View.GONE);





        picture.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api= Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent,1);

                }else {

                    requestPermissions(new String[]{Manifest.permission.CAMERA},100);
                }





            }
        });


    }













    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1 && resultCode==RESULT_OK){
            Bitmap image=(Bitmap) data.getExtras().get("data");
            int dimension=Math.min(image.getWidth(),image.getHeight());
            image= ThumbnailUtils.extractThumbnail(image,dimension,dimension);

            imageView.setImageBitmap(image);


            demoText.setVisibility(View.GONE);
            clickhere.setVisibility(View.VISIBLE);
            arrowImage.setVisibility(View.GONE);
            classified.setVisibility(View.VISIBLE);
            result.setVisibility(View.VISIBLE);

            image=Bitmap.createScaledBitmap(image,imageSize,imageSize,false);
            try {
                classifyImage(image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }




        super.onActivityResult(requestCode, resultCode, data);
    }


    private void classifyImage(Bitmap image) throws IOException {

        try {

//pendingggggggggggggggggg

          DiseaseDetection model=DiseaseDetection.newInstance(getApplicationContext());
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer=ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());
            int[] intValue=new int[imageSize * imageSize];
            image.getPixels(intValue,0,image.getWidth(),0,0,image.getWidth(),image.getHeight());
            int pixel=0;
            for (int i=0;i<imageSize;i++){
                for (int j=0;j<imageSize;j++){
                    int val=intValue[pixel++];
                    byteBuffer.putFloat(((val >> 16) & 0xFF)*(1.f/255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF)*(1.f/255.f));
                    byteBuffer.putFloat((val & 0xFF)*(1.f/255.f));

                    }

            }
            inputFeature0.loadBuffer(byteBuffer);

            DiseaseDetection.Outputs outputs=model.process(inputFeature0);
            TensorBuffer outputFeaturesO=outputs.getOutputFeature0AsTensorBuffer();
            float[] confidence=outputFeaturesO.getFloatArray();
            int maxPos=0;
            float maxConfidence=0;
            for (int i=0;i<confidence.length;i++){
                if (confidence[i]>maxConfidence){
                    maxConfidence=confidence[i];
                    maxPos=i;
                }
            }


    String[] classes={"Tomato Late blight","Tomato healthy","Tomato Early blight","Tomato Bacterial spot","Tomato Tomato YellowLeaf Curl_Virus","Tomato Tomato mosaic virus","Tomato Target Spot","Potato Late blight","Potato healthy","Potato Early blight","Pepper bell healthy","Pepper bell Bacterial spot"};
            result.setText(classes[maxPos]);
            result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com//search?q="+result.getText())));
                }
            });

            model.close();


        } catch (Exception e) {


        }

    }





}































