package panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    final JFileChooser fileChooser = new JFileChooser();
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent event){
        int returnedFile = fileChooser.showSaveDialog(ControlPanel.this);
        if(returnedFile == JFileChooser.APPROVE_OPTION){
            try{
                ImageIO.write(frame.canvas.image,"png",fileChooser.getSelectedFile());
            }catch (IOException err) {
                System.err.println(err);
            }

        }
    }
    private void load(ActionEvent event) {
        BufferedImage img = null;
        int returnedFile = fileChooser.showOpenDialog(ControlPanel.this);
        if(returnedFile == JFileChooser.APPROVE_OPTION){

            try {
                img = ImageIO.read(fileChooser.getSelectedFile());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            frame.canvas.graphics.drawImage(img,0,0,null);
            frame.canvas.update(getGraphics());
        }
    }
    private void reset(ActionEvent event) {
            this.frame.canvas.resetCanvas();
    }
    private void exit(ActionEvent event) {
            System.exit(0);
    }
}

