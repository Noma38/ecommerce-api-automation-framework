package tests;

import api.UserAPI;
import base.BaseTest;
import io.restassured.response.Response;
import utils.DataProviderClass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Listeners(utils.ExtentListener.class)
public class UserCRUDTest extends BaseTest {

	@Test(dataProvider = "userData", dataProviderClass = DataProviderClass.class)
	public void testCRUDFlow(String firstName, String lastName) {

	    // CREATE
	    Map<String, Object> body = new HashMap<>();
	    body.put("firstName", firstName);
	    body.put("lastName", lastName);

	    Response createRes = UserAPI.createUser(body);
	    Assert.assertEquals(createRes.getStatusCode(), 201);

        // 
        // int userId = createRes.jsonPath().getInt("id");
        
            // API (dummyjson) is fake
        // Delete may not behave perfectly so that's why i hardcode it
        
        int userId = 1;


        // ===== GET =====
        Response getRes = UserAPI.getUser(userId);

        Assert.assertEquals(getRes.getStatusCode(), 200);
        Assert.assertEquals(getRes.jsonPath().getInt("id"), userId);

        // ===== UPDATE =====
        Map<String, Object> updateBody = new HashMap<>();
        updateBody.put("firstName", "UpdatedName");

        Response updateRes = UserAPI.updateUser(userId, updateBody);

        Assert.assertEquals(updateRes.getStatusCode(), 200);
        Assert.assertEquals( updateRes.jsonPath().getString("firstName"),"UpdatedName");

        // ===== DELETE =====


        Response deleteRes = UserAPI.deleteUser(userId);

        Assert.assertEquals(deleteRes.getStatusCode(), 200);
    }
}