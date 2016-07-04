package cl.ceeinf.ligababy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class nueva_foto extends AppCompatActivity implements OnClickListener{

    Button btn;
    ImageView img;
    Intent i;
    final static int cons = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_foto);

        init();
    }

    private void init() {
        btn = (Button)findViewById(R.id.btnCaptura);
        btn.setOnClickListener(this);

        img = (ImageView)findViewById(R.id.imagen);
    }

    @Override
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id){
            case R.id.btnCaptura:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cons);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode,resultCode,data);
            if (resultCode == Activity.RESULT_OK){
                Bundle ext = data.getExtras();
                bmp = (Bitmap)ext.get("data");
                img.setImageBitmap(bmp);
            }
    }
}
