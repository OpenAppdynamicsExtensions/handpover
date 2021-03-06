package org.appdynamics.handpover.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import org.apache.commons.io.IOUtils;
import org.appdynamics.handpover.config.Globals;
import org.appdynamics.handpover.export.Folder;
import org.appdynamics.handpover.json.DashboardList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by michi on 31.10.16.
 */
public class GetDashboards implements Runnable{
    @Override
    public void run() {
        try {
            doGetDashboardList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doGetDashboardList() throws Exception{
        ClientResponse response;
        List<DashboardList> dashboardList;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<DashboardList>> mapType = new TypeReference<List<DashboardList>>() {};

        response = Base.getClientResponse(Globals.URL + Globals.CONTROLLER_ROOT + Globals.API_DASHBOARD_LIST);
        String output = response.getEntity(String.class);
        Folder.createFolder(Globals.DASHBOARD_FOLDER);

        dashboardList = objectMapper.readValue(output, mapType);

        for (DashboardList dashboard : dashboardList) {
            GetDashboards.doGetDashboard(dashboard);
        }
        Globals.PROGRESS = Globals.PROGRESS + 10;
    }

    private static void doGetDashboard(DashboardList dashboard) throws Exception{
        ClientResponse response;

        response = Base.getClientResponse(Globals.URL + Globals.CONTROLLER_ROOT + Globals.API_DASHBOARD_EXPORT + dashboard.getId());

        InputStream input = response.getEntityInputStream();

        byte[] byteArray = IOUtils.toByteArray(input);

        FileOutputStream fos = new FileOutputStream(new File(Globals.DASHBOARD_FOLDER + dashboard.getId() + Globals.JSON_FILE));
        fos.write(byteArray);
        fos.flush();
        fos.close();
    }

}
