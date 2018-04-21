package sessionone.tot.com.session_one.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by PC on 4/21/2018.
 */

public class InternetConnectionCheck {

    public static boolean checkInternetConnection(Context context) {

        ConnectivityManager con_manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
