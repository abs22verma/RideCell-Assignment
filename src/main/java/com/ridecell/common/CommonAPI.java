package com.ridecell.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ridecell.utility.Config;
import com.ridecell.utility.CustomException;
import com.ridecell.utility.World;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonAPI {

	private static Logger LOGGER = LogManager.getLogger();

	public static Response getResponse() {
		String apiURL = Config.getResource().getString("api");
		String username = Config.getResource().getString("username");
		String password = Config.getResource().getString("password");
		LOGGER.info("Make GET request : " + apiURL);
		Response response = null;
		try {
			RestAssured.baseURI = apiURL;
			RequestSpecification request = RestAssured.given().auth().preemptive().basic(username, password)
					.contentType(ContentType.JSON);
			response = request.get();
			if (response.getStatusCode() == 200) {
				return response;
			}else {
				LOGGER.info("Status code : "+response.getStatusCode());
			}
		} catch (Exception e) {
			throw new CustomException("Exception while getting api response : " + e);
		}
		return response;
	}

	/*
	 * This mehtod is used for comparing JSON response and Map
	 */
	public static void compareRepo(Response res) {
		JSONArray arr = new JSONArray(res.asPrettyString());

		int n = arr.length();
		LOGGER.info("Number of Repository :: " + n);
		for (int i = 0; i < n; i++) {
			JSONObject repo = arr.getJSONObject(i);

			if (World.getInstance().search(repo.getString("name"))) {
				LOGGER.info(repo.getString("name") + " :: " + World.getInstance().search(repo.getString("name")));
				try {
					World.getInstance().get(repo.getString("name")).equalsIgnoreCase(repo.getString("description"));
				} catch (JSONException e) {
					LOGGER.info("Repo description not available :: " + World.getInstance().get(repo.getString("name")));
				}
			} else {
				throw new CustomException("Repository is not avalaible on UI");
			}
		}
	}

}
