package org.appdynamics.handpover.config;

/**
 * Created by michi on 15.08.16.
 */
@SuppressWarnings("unused")
public class Globals {
    public static String URL;
    public static float PROGRESS = 0;

    public static final String CONTROLLER_HTTP = "http://";
    public static final String CONTROLLER_HTTPS = "https://";
    public static final String CONTROLLER_HTTP_PORT = "80";
    public static final String CONTROLLER_HTTPS_PORT = "443";
    public static final String CONTROLLER_HTTP_DEFAULT_PORT = "8090";
    public static final String CONTROLLER_HTTPS_DEFAULT_PORT = "8181";
    public static final String CONTROLLER_ROOT = "/controller";
    public static final String CONTROLLER_ADMIN = "admin";

    public static final String COLON = ":";
    public static final String PIPE = "|";
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String ROOT = "/";
    public static final String DOT = ".";
    public static final String OPENING_SBRACKETS = "[";
    public static final String CLOSING_SBRACKETS = "]";
    public static final String AT = "@";
    public static final String REST_AUTH_METHOD = "Basic ";
    public static final String REST_AUTH_KEY = "Authorization";
    public static final String COOKIE_CSRF = "X-CSRF-TOKEN";
    public static final String COOKIE_JSESSION = "JSESSIONID";
    public static final String AUDIT_TIMESTAMP = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String AUDIT_TIMESTAMP_END = "-0000";

    public static final String API_LOGIN = "/auth?action=login";
    public static final String API_APP_EXPORT = "/ConfigObjectImportExportServlet?applicationId=";
    public static final String API_AUDIT = "/ControllerAuditHistory";
    public static final String API_CONTROLLER_CONFIG = "/rest/configuration";
    public static final String API_DASHBOARD_LIST = "/restui/dashboards/list2";
    public static final String API_GET_USER = "/restui/user/getUser";
    public static final String API_DASHBOARD_EXPORT = "/CustomDashboardImportExportServlet?dashboardId=";
    public static final String API_APP_LIST = "/rest/applications";
    public static final String API_BT_LIST = "/business-transactions";
    public static final String API_TIER_LIST = "/tiers";
    public static final String API_NODE_LIST = "/nodes";
    public static final String API_BACKEND_LIST = "/backends";
    public static final String API_OUTPUT = "?output=JSON";
    public static final String API_AUDIT_START = "?startTime=";
    public static final String API_AUDIT_END = "&endTime=";
    public static final String API_CONTROLLER_LOGS = "/FileUploadServlet?action=CONTROLLER_LOGS";
    public static final int API_AUDIT_DAYS = -30;

    public static final String URL_ENABLE_ACCOUNTS = "?enableAccounts=true";
    public static final String URL_HOME = "#/location=AD_HOME_OVERVIEW";

    public static final String AUDIT_FILE = "audit.xlsx";
    public static final String SETTINGS_FILE = "settings.xlsx";
    public static final String APPS_FILE = "apps.xlsx";
    public static final String JSON_FILE = ".json";
    public static final String XML_FILE = ".xml";
    public static final String CONTROLLER_LOG_FILES = "controller-logs.zip";
    public static final String PHANTOMJS_LOG_FILE = "phantomjsdriver.log";
    public static final String OUTPUT_FOLDER = "output/";
    public static final String DASHBOARD_FOLDER = OUTPUT_FOLDER + "dashboards/";
    public static final String APP_SETTINGS_FOLDER = OUTPUT_FOLDER + "app_settings/";
    public static final String EXCEL_FOLDER = OUTPUT_FOLDER + "excel/";
    public static final String SCREENSHOT_FOLDER = OUTPUT_FOLDER + "excel/";
    public static final String OUTPUT_FILE = "output.zip";
    public static final String EXCEL_CONTROLLER_SETTINGS = "controller_settings";
    public static final String EXCEL_CONTROLLER_AUDIT = "controller_audit";
    public static final String EXCEL_BTS = "_bts";
    public static final String EXCEL_TIERS = "_tiers";
    public static final String EXCEL_NODES = "_nodes";
    public static final String NAME = "Name";
    public static final String ID = "ID";

    public static final String ERROR_HTTP = "Some Connectivity Issue - HTTP error code ";
    public static final String ERROR_FOLDER = "Could not create output folder";
    public static final String ERROR_NO_ADMIN = "Your are not admin. Please use an admin user for the AppDynamics Controller.";
    public static final String ERROR = "Error";
    public static final String DONE = "Done";
    public static final String DONE_MESSAGE = "Output can be found at: ";
}
