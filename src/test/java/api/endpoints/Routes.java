package api.endpoints;
//fron swagger website https://petstore.swagger.io/
//create  for user url is https://petstore.swagger.io/#/user/createUsersWithListInput
//https://petstore.swagger.io/#/user/getUserByName for get user
//https://petstore.swagger.io/#/user/deleteUser  
//https://petstore.swagger.io/#/user/updateUser
    // here we are just maintaing the url's
public class Routes
{
	public static String baseUrl="https://petstore.swagger.io/";
	
	//for User module
	public static String userposturl=baseUrl+"/user";
	public static String usergeturl=baseUrl+"/user/{username}";
	public static String userupdateurl=baseUrl+"/user/{username}";
	public static String userdeleteurl=baseUrl+"/user/{username}";
	
	//for Store module
	public static String storeposturl=baseUrl+"/store/order";
	public static String storegetturl=baseUrl+"/store/{orderId}";
	public static String storegetreturnurl=baseUrl+"/store/inventory";
	public static String storedeleteurl=baseUrl+"/store/orderId";
	
	//for pet module
	public static String petposturl=baseUrl+"/pet/{petId}";
    public static String petupdateurl=baseUrl+"/pet";
    public static String petgeturl=baseUrl+"/pet/{petId}";
    public static String petdeleteurl=baseUrl+"/pet/{petId}";

}
