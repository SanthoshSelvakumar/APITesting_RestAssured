package resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	static RequestSpecification req;
	ResponseSpecification res;
	public static RequestSpecification requestSpecification() throws IOException
	{if(req==null)
	{
		PrintStream log=new PrintStream(new FileOutputStream("Logging.txt"));
		return req=new RequestSpecBuilder().setBaseUri(globalValue("baseURL")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();}
	return req;
	}
	public ResponseSpecification responseSpecification()
	{
	return res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
	public static String globalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
}
