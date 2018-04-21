package sessionone.tot.com.session_one.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
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
    @BindView(R.id.pb_loader)
    ProgressBar pbLoader;
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
            wvBrowser.setWebViewClient(new AppWebViewClients());
            wvBrowser.loadUrl(url);

            mySwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            wvBrowser.reload();
                            mySwipeRefreshLayout.setRefreshing(false);
                        }
                    }
            );
        }

    }


    public class AppWebViewClients extends WebViewClient{

        private ProgressBar progressBar;

        public AppWebViewClients() {
            this.progressBar =pbLoader;
            progressBar.setVisibility(View.VISIBLE);
            mySwipeRefreshLayout.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.GONE);


        }
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
