import com.coforge.ApiHelper;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase
{

    public  static String postReqpath="/api/users";
    public  static String putReqpath="/api/users/2";
    public  static String deleteReqpath="/api/users/2";
    public  static String getReqpath="/api/users/2";

    ApiHelper ap= new ApiHelper();


    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test(priority = 2)
    public  void getReq()
    {
        ap.getReq(getReqpath);
    }
    @Test(priority = 1)
    public  void postReq()
    {
        ap.postReq(postReqpath);
    }
    @Test(priority = 3)
    public  void putReq()
    {
        ap.putRequest(putReqpath);
    }
    @Test(priority = 4)
    public  void deleteReq()
    {
        ap.deleteRequest(deleteReqpath);
    }
}
