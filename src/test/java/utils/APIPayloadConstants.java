package utils;
import org.json.JSONObject;
public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Angelina\",\n" +
                "  \"emp_lastname\": \"Jolie\",\n" +
                "  \"emp_middle_name\": \"MS\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2005-07-02\",\n" +
                "  \"emp_status\": \"sad\",\n" +
                "  \"emp_job_title\": \"annoyer\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Angelina");
        obj.put("emp_lastname","Jolie");
        obj.put("emp_middle_name","MS");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","2005-07-02");
        obj.put("emp_status","sad");
        obj.put("emp_job_title","annoyer");
        return obj.toString();
    }

    public static String createEmployeeJsonPayloadDynamic
            (String fn, String ln, String mn, String gender,
             String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fn);
        obj.put("emp_lastname", ln);
        obj.put("emp_middle_name", mn);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }

}
