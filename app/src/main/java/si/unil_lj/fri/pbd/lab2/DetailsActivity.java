package si.unil_lj.fri.pbd.lab2;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            System.out.println("DetailsActivity : land");
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        DetailsFragment details = new DetailsFragment();
        details.setArguments(getIntent().getExtras());
        System.out.println("DetailsActivity : " + getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, details).addToBackStack(null).commit();

    }
}
