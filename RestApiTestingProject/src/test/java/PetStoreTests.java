import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PetStoreTests {


    @Test (description = "Kullanıcı oluşturulması")
    public void CreateUser (){

        String bodyPayload = "{\n" +
                "  \"id\": 2536987,\n" +
                "  \"username\": \"relativity\",\n" +
                "  \"firstName\": \"sevda\",\n" +
                "  \"lastName\": \"yilmaz\",\n" +
                "  \"email\": \"javaforintellij@outlook.com\",\n" +
                "  \"password\": \"123456S.\",\n" +
                "  \"phone\": \"5862352255\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        RestAssured.given().body(bodyPayload).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user");

    }


    @Test (description = "Kullanıcı adı ile kullanıcı arama")
    public void GetUserInfo (){

        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/relativity");
    }

    @Test (description = "Kullanıcı bilgileri güncelleme")
    public void UpdateUserInfo(){

        String bodyPayload = "{\n" +
                "  \"id\": 456321,\n" +
                "  \"username\": \"tryit\",\n" +
                "  \"firstName\": \"irmak\",\n" +
                "  \"lastName\": \"ece\",\n" +
                "  \"email\": \"irmak@iu.com\",\n" +
                "  \"password\": \"123456E.\",\n" +
                "  \"phone\": \"9884522363\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        RestAssured.given().body(bodyPayload).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/relativity");
    }

    @Test (description = "Kullanıcı silme")
    public void UserDelete (){

        RestAssured.given().contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/relativity");
    }

    @Test (description = "Kayıtlı kullanıcı ile login olma")
    public void LoginUser (){

        Map<String, Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("username", "tryit");
        queryParamsMap.put("password", "123456E.");

        RestAssured.given().queryParams(queryParamsMap).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login");
    }

    @Test (description = "Login kullanıcı ile logout olma")
    public void LogoutUser(){

        RestAssured.get("https://petstore.swagger.io/v2/user/logout");

    }
}
