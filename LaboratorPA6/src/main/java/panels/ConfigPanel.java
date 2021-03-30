package panels;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JSpinner sizeField;
    JComboBox<Color> colorCombo;
    JComboBox shapesCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        JLabel sizeLabel = new JLabel("Size number:");
        JLabel sidesLabel = new JLabel("Number of sides:");

        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sizeField = new JSpinner(new SpinnerNumberModel(0,0,100,1));

        sidesField.setValue(6);
        sizeField.setValue(20);

        Color[] colors = {Color.white, Color.red, Color.blue, Color.green};
        colorCombo = new JComboBox<>(colors);
        colorCombo.setMaximumRowCount(colors.length);
        colorCombo.setRenderer(new MyCellRenderer());
        colorCombo.setEditable(true);

        String[] shapes = {"Circle", "RegularPolygon", "Rectangle", "Drawing"};
        shapesCombo = new JComboBox(shapes);

        add(sizeLabel);
        add(sizeField);
        add(shapesCombo);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

    public int getSides(){
        return (Integer) sidesField.getValue();
    }


    static class MyCellRenderer extends JButton implements ListCellRenderer {
        public MyCellRenderer() {
            setOpaque(true);

        }
        boolean bool=false;
        @Override
        public void setBackground(Color bg) {
            if(!bool)
            {
                return;
            }

            super.setBackground(bg);
        }
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,

                boolean isSelected,
                boolean cellHasFocus)
        {

            bool=true;
            setText("COLOR");
            setBackground((Color)value);
            bool=false;
            return this;
        }
    }
}

