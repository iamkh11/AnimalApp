package com.example.animalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] names = {"cat","rabbit","bat","crocodile","frog","horse","lion","mouse","panda","rabbit","tigre"};
    int[] images = {R.drawable.cat,R.drawable.rabbit,R.drawable.bat,R.drawable.crocodile,R.drawable.frog,R.drawable.horse,R.drawable.lion,R.drawable.mouse,R.drawable.panda,R.drawable.rabbit,R.drawable.tigre };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(names,images,this);

        gridView.setAdapter(customAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = names[i];
                int selectedImage = images[i];

                startActivity(new Intent(MainActivity.this,ClickedItemActivity.class).putExtra("name",selectedName).putExtra("image",selectedImage));



            }
        });
    }

    public class CustomAdapter extends BaseAdapter{
        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                view = layoutInflater.inflate(R.layout.row_images, viewGroup, false);

            }

            TextView tvName = view.findViewById(R.id.tvName);
            ImageView imageView = view.findViewById(R.id.imageView);


            tvName.setText(imageNames[i]);
            imageView.setImageResource(imagesPhoto[i]);



            return view;
        }
    }


}
