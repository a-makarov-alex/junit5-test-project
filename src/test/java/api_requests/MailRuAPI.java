package api_requests;

import config.model.UserConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import restAssured.RestAssuredSpecification;

public class MailRuAPI extends BaseRequest {
    public final String AUTH_TOKEN;

    public MailRuAPI() {
        UserConfig user = getCredsProps().keycloakUser();
        AUTH_TOKEN = getUserAuthToken(user.getUsername(), user.getPassword());
    }

    /**
     * Можно реализовать любым удобным способом
     */
    public MailRuAPI(UserConfig userConfig) {
        AUTH_TOKEN = getUserAuthToken(userConfig.getUsername(), userConfig.getPassword());
    }

    /**
     * Пример запроса
     */
    public String getMailPage() {
        RequestSpecification request = RestAssured.given(RestAssuredSpecification.STAND.getSpec()).auth().oauth2(AUTH_TOKEN);
                //.when().get()
                //.then().extract().as(SOME_CLASS.class);
        return "Ответ от запроса getMailPage()";
    }
}
