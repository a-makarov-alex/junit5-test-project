package api_requests;

import config.ConfigProvider;
import config.model.UserConfig;
import io.qameta.allure.Step;

/**
 * Может использоваться как хранилище информации, которая должна быть доступна во всех api запросах
 */
public class BaseRequest implements ConfigProvider {
    /**
     * Пример использования
     */
    private final UserConfig someValuableInfo = getCredsProps().someValuableInfo();

    /**
     * Получение токена через обычный HTTP запрос (в киклок, например)
     */
    @Step
    protected String getUserAuthToken(String username, String password) {
        // return given(RestAssuredSpecification.STAND.getSpec()).when().post().then().... etc
        return "accessToken";
    }
}
