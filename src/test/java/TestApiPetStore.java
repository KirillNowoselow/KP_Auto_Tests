import io.qameta.allure.Story;
import models.RequestModel.*;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestApiPetStore extends BaseTest {
    @Story("POST")
    @Test(testName = "Тест добавления питомца", description = "Тест добавления питомца")
    public void checkAddPet() {
        Category category = new Category(1, "string");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag(0, "string"));
        PetRequest petRequest = new PetRequest(12, category, "collie", photoUrls, tags, "available");
        STEPS_API_PET_STORE.addPet(petRequest);
    }

    @Story("GET")
    @Test(testName = "Тест получения питомцев со статусом sold", description = "Тест получения питомцев со статусом sold")
    public void checkGetPetStatus() {
        STEPS_API_PET_STORE.getPetStatus("sold");
    }

    @Story("POST")
    @Test(testName = "Тест добавления заказа", description = "Тест добавления заказа")
    public void checkPostOrder() {
        OrderRequest orderRequest = new OrderRequest(4, 1,0,"2023-12-21T14:59:19.911Z","placed",true);
        STEPS_API_PET_STORE.postOrder(orderRequest);
    }

    @Story("GET")
    @Test(testName = "Тест получения заказа по id", description = "Тест получения заказа по id")
    public void checkGetOrderById() {
        STEPS_API_PET_STORE.getOrderById(1);
    }

    @Story("GET")
    @Test(testName = "Тест входа в систему", description = "Тест входа в систему")
    public void checkLoginUser() {
        STEPS_API_PET_STORE.lodinUser("xa4ipur4ik", "123");
    }

    @Story("POST")
    @Test(testName = "Тест создания пользователя", description = "Тест создания пользователя")
    public void checkCreateUser() {
        UserRequest user = new UserRequest(7,"Tihon","Homishen", "string", "string@mail.ru", "adsf", "89120434433", 0);
        STEPS_API_PET_STORE.createUser(user);
    }

    @Story("DELETE")
    @Test(testName = "Тест удаления пользователя", description = "Тест удаления пользователя")
    public void checkDeleteUser() {
        UserRequest user = new UserRequest(7,"Tihon","Homishen", "string", "string@mail.ru", "adsf", "89120434433", 0);
        STEPS_API_PET_STORE.createUser(user);
        STEPS_API_PET_STORE.deleteUser("Tihon");
    }

    @Story("GET")
    @Test(testName = "Тест получения инвентаря домашних животных", description = "Тест получения инвентаря домашних животных")
    public void checkGetStatusInventory() {
        STEPS_API_PET_STORE.getStatusInventory();
    }
}
