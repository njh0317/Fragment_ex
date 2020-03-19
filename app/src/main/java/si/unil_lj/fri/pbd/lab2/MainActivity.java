package si.unil_lj.fri.pbd.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(String data)
    {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }





}
