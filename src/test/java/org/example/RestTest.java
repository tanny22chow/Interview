package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {



    @Test(enabled = false)
    public void m1(){
        String s1=given().get("").then().extract().asString();
        given().body("").post("").then().extract().as(String.class);
        given().spec( new RequestSpecBuilder().setProxy("").build()).get().then().extract().as(String.class);


        JsonPath path=new JsonPath(s1);
        path.get("");

    }
    @Test
    public void m2() {
        int[] nums = {2, 0, -4, 2, 0, 1, 0, 9};
        int r=nums.length-1;
        int i=0;
        while(i<r){
            if(nums[i]==0&& nums[r]!=0){
                nums[i]=nums[r];
                nums[r]=0;
                r--;
            }
            if(nums[i]==0&& nums[r]==0){
                r--;i--;
            }
            i++;
        }
        for(int a:nums){
            System.out.println(a);
        }
    }
}
