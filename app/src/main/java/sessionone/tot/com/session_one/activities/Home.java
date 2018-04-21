package sessionone.tot.com.session_one.activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sessionone.tot.com.session_one.R;

public class Home extends AppCompatActivity {

    AnimationDrawable animationControler;
    @BindView(R.id.imageView)
    ImageView ivAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        customAnimation();
    }

    private void customAnimation() {

        ivAnim.setImageResource(R.drawable.frameanimation);
        animationControler=(AnimationDrawable)ivAnim.getDrawable();
        animationControler.start();

    }

    @OnClick(R.id.btn_web_view)
    void openWebView() {
        startActivity(new Intent(Home.this, MyBrowser.class));
    }

    @OnClick(R.id.btn_store_data)
    void openStoreData() {
        startActivity(new Intent(Home.this, StoreData.class));
    }

    @OnClick(R.id.btn_view_data)
    void openViewData() {
        startActivity(new Intent(Home.this, ViewData.class));

    }
}

