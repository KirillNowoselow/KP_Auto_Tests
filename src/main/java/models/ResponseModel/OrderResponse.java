package models.ResponseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    public Integer id;
    public Integer petId;
    public Integer quantity;
    public String shipDate;
    public String status;
    public boolean complete;
}
