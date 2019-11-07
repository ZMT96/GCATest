package zmt.z.gcatest.Api;

public class ApiUtil {

    public static String link="http://forex.cbm.gov.mm/api/";

    public static ApiRequest getApiRequest(){
        return RetrofitClient.getClient(link).create(ApiRequest.class);
    }
}
