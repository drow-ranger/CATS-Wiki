package xyz.deonico.catswiki.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.deonico.catswiki.R;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.linearLayoutTop)
    LinearLayout linearLayoutTop;
    @BindView(R.id.ivProfile)
    ImageView ivProfile;

    @BindView(R.id.tvGithub)
    TextView tvGithub;
    @BindView(R.id.tvWebsite)
    TextView tvWebsite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String base_image_url = "https://catapi.deonico.xyz/img/profile/";
        String base_github_url = "https://github.com/";
        String base_domain_url = "https://deonico.xyz";

        String github = "drow-ranger";
        String website = "deonico.xyz";

        Picasso.get().
                load(base_image_url+"me_and_my_cat.jpg").
                error(R.drawable.catnotfound).
                into(ivProfile);

        Picasso.get().
                load(base_image_url+"cat_header.jpg").
                error(R.drawable.gradientbackground).
                into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        linearLayoutTop.setBackground(new BitmapDrawable(bitmap));
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        linearLayoutTop.setBackground(new BitmapDrawable(String.valueOf(R.drawable.gradientbackground)));
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });

        tvGithub.setText(github);
        tvGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(base_github_url+github);
            }
        });

        tvWebsite.setText(website);
        tvWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(base_domain_url);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 0) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void openURL(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
    }
}
