package swing;

import event.TableActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditer extends DefaultCellEditor {

    private final TableActionEvent event;

    public TableActionCellEditer(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelActionAdd panelActionAdd = new PanelActionAdd();
        panelActionAdd.setBackground(Color.WHITE);
        panelActionAdd.initEvent(event, row);
        return panelActionAdd;
    }

}
