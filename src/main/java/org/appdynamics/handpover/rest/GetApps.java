package org.appdynamics.handpover.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import org.appdynamics.handpover.config.Globals;
import org.appdynamics.handpover.export.Excel;
import org.appdynamics.handpover.export.Folder;
import org.appdynamics.handpover.json.Apps;

import java.util.List;

/**
 * Created by michi on 28.08.16.
 */
public class GetApps implements Runnable {
    public void run() {
        try {
            doGetApps();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doGetApps() throws Exception {
        ClientResponse response;
        List<Apps> appList;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Apps>> mapType = new TypeReference<List<Apps>>() {};

        response = Base.getClientResponse(Globals.URL + Globals.CONTROLLER_ROOT + Globals.API_APP_LIST + Globals.API_OUTPUT);
        String output = response.getEntity(String.class);
        appList = objectMapper.readValue(output, mapType);

        if (!output.isEmpty()) {
            Folder.createFolder(Globals.APP_SETTINGS_FOLDER);
            Excel excel = new Excel();
            excel.createFile(Globals.APPS_FILE);
            for (Apps app : appList) {
                GetAppSettings.doGetAppSettings(app);
                GetBts.doGetBusinessTransactions(app);
                GetTiers.doGetTiers(app);
                GetNodes.doGetNodes(app);
            }
            Globals.PROGRESS = Globals.PROGRESS + 40;
        }


    }

}
