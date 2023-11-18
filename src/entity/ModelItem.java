package entity;

import javax.swing.Icon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ModelItem {

    private int itemID;
    private String itemName;
    private String description;
    private double price;
    private String brandName;
    private Icon image;
}
