import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
public class Requst {
    @Test
    public void GetUser(){
        Response response = get("https://api.vk.com/method/users.get?user_ids=76229304&fields=bdate&access_token=4592952e05c8d82268e37e0141180392de6065dd40ae03f6be5289bc9cc3096b621cfb9e06cc778e3b03a&v=5.103");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(200, response.statusCode());

    }

    @Test
    public void GetSubscriptions(){
        Response response = get("https://api.vk.com/method/users.getSubscriptions?extended=1&access_token=4592952e05c8d82268e37e0141180392de6065dd40ae03f6be5289bc9cc3096b621cfb9e06cc778e3b03a&v=5.103");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void GetFollowers(){
        Response response = get("https://api.vk.com/method/users.getFollowers?access_token=4592952e05c8d82268e37e0141180392de6065dd40ae03f6be5289bc9cc3096b621cfb9e06cc778e3b03a&v=5.103");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(200, response.statusCode());
    }
}
