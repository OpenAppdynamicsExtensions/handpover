package org.appdynamics.handpover.rest;

import com.sun.jersey.api.client.ClientResponse;
import org.apache.poi.util.IOUtils;
import org.appdynamics.handpover.config.Globals;
import org.appdynamics.handpover.json.Apps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by michi on 23.10.16.
 */
@SuppressWarnings("WeakerAccess")
public class GetAppSettings {
    public static void doGetAppSettings(Apps app) throws Exception{
        ClientResponse response = Base.getClientResponse(Globals.URL + Globals.CONTROLLER_ROOT + Globals.API_APP_EXPORT + app.getId());
        InputStream input = response.getEntityInputStream();

        byte[] byteArray = IOUtils.toByteArray(input);

        FileOutputStream fos = new FileOutputStream(new File(Globals.APP_SETTINGS_FOLDER + app.getName() + Globals.XML_FILE));
        fos.write(byteArray);
        fos.flush();
        fos.close();
    }
}
