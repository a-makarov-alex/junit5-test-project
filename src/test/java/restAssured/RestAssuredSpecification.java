package restAssured;

import config.ConfigProvider;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

/**
 * Задает методы (и наверное переменные?), актуальные для конкретного окружения
 * можно использовать, когда есть несколько нужных урлов: киклока и стенда, например.
 */
public enum RestAssuredSpecification implements ConfigProvider {

    KEYCLOAK {
        @Override
        public RequestSpecification getSpec() {
            return new RequestSpecBuilder()
                    .setBaseUri(getEnvProps().keycloakUrl())
                    .addFilter(new AllureRestAssured())
                    .log(LogDetail.ALL)
                    .build();
        }
    },
    STAND {
        @Override
        public RequestSpecification getSpec() {
            return new RequestSpecBuilder()
                    .setBaseUri(getEnvProps().standUrl())
                    .addFilter(new AllureRestAssured())
                    .log(LogDetail.ALL)
                    .build();
        }
    };

    public abstract RequestSpecification getSpec();
}
