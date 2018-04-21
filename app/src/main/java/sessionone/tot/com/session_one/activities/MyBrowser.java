package sessionone.tot.com.session_one.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sessionone.tot.com.session_one.R;
import sessionone.tot.com.session_one.utils.InternetConnectionCheck;

public class MyBrowser extends AppCompatActivity {

    @BindView(R.id.wv_browser)
    WebView wvBrowser;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);
        ButterKnife.bind(this);
        loadWebsite();
    }

    private void loadWebsite() {

        if (!InternetConnectionCheck.checkInternetConnection(this)){
            tvEmpty.setVisibility(View.VISIBLE);
            wvBrowser.setVisibility(View.GONE);
        }else{

            String url ="https://google.com/";
            wvBrowser.getSettings().setJavaScriptEnabled(true);
            wvBrowser.getSettings().setBuiltInZoomControls(true);
            wvBrowser.getSettings().setDisplayZoomControls(false);
            wvBrowser.setWebViewClient(new WebViewClient());
            wvBrowser.loadUrl(url);

            mySwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            wvBrowser.reload();
                        }
                    }
            );
        }

    }
}
