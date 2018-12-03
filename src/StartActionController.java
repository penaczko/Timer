import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartActionController implements  ActionListener{
        Model model;
        JLabel label;

        StartActionController(Model model , JLabel label) {
            this.model = model;
            this.label = label;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.elapsedTimer.isRunning()) {
                model.elapsedTimer.stop();
            }
            model.elapsedTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String elapsedSec = String.valueOf(model.et % 60);
                    String elapsedMin = String.valueOf(model.et / 60);
                    String elapsedHour = String.valueOf(Integer.parseInt(elapsedMin) / 60);
                    if(Integer.parseInt(elapsedSec) < 10) {
                        elapsedSec = "0" + elapsedSec;
                    }
                    if(Integer.parseInt(elapsedMin) < 10) {
                        elapsedMin = "0" + elapsedMin;
                    }
                    if(Integer.parseInt(elapsedHour) < 10) {
                        elapsedHour = "0" + elapsedHour;
                    }

                    label.setText(elapsedHour + " : " + elapsedMin + " : " + elapsedSec);
                    model.et++;
                }
            });

            model.elapsedTimer.start();
        }
}

