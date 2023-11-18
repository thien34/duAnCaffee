package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class Model_Menu {

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/com/raven/icon/" + icon + ".png"));
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
