package steps;
import io.qameta.allure.Step;
import models.RequestModel.*;
import models.RequestModel.PetResponse;
import models.ResponseModel.AnswerResponse;
import models.ResponseModel.OrderResponse;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StepsApiPetStore {
    @Step("Добаление питомца")
    public void addPet(PetRequest petRequest) {
        PetResponse petResponse = given()
            .body(petRequest)
            .when()
            .post("/pet")
            .then()
                .statusCode(200).log().all()
            .extract().response().body().as(PetResponse.class);
        Assert.assertEquals(petRequest.getId(), petResponse.getId());
    }

    @Step("Получение питомцев со статусом")
    public void getPetStatus(String status) {
         List<PetResponse> petsResponse = given()
                .when()
                .get("/pet/findByStatus?status="+status)
                .then()
                .statusCode(200).log().all()
                .extract().response().body().jsonPath().getList("data", PetResponse.class);
    }

    @Step("Добавление заказа")
    public void postOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = given()
                .body(orderRequest)
                .when()
                .post("/store/order")
                .then()
                .statusCode(404).log().all()
                .extract().response().body().as(OrderResponse.class);
        Assert.assertEquals(orderRequest.getId(), orderResponse.getId());
    }

    @Step("Получение заказа по id")
    public void getOrderById(Integer orderId) {
        given()
                .when()
                .get("/store/order/"+orderId)
                .then()
                .statusCode(200).log().all()
                .extract().response().body().as(AnswerResponse.class);
    }

    @Step("Вход в систему")
    public void lodinUser(String username, String password) {
        AnswerResponse answer = given()
                .when()
                .get("/user/login?username="+username+"&password="+password)
                .then()
                .statusCode(200).log().all()
                .extract().response().body().as(AnswerResponse.class);
        Assert.assertEquals(200, answer.getCode());
    }

    @Step("Создание пользователя")
    public void createUser(UserRequest user) {
        AnswerResponse answer = given()
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(200).log().all()
                .extract().response().body().as(AnswerResponse.class);
        Assert.assertEquals(user.getId(), Integer.parseInt(answer.getMessage()));
    }

    @Step("Удаление пользователя")
    public void deleteUser(String userName) {
        AnswerResponse answer = given()
                .when()
                .delete("/user/"+userName)
                .then()
                .statusCode(200).log().all()
                .extract().response().body().as(AnswerResponse.class);
        Assert.assertEquals(userName, answer.getMessage());
    }

    @Step("Получения инвентаря домашних животных")
    public void getStatusInventory() {
        given()
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200).log().all();
    }
}