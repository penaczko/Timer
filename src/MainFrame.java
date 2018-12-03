import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class MainFrame extends JFrame {
    JLabel label = new JLabel("Time: ");
    JLabel clock = new JLabel(new GetTimeController().getTime());
    JPanel panel = new JPanel();
    JLabel elapsedTime = new JLabel("Elapsed time: ");
    JLabel elapsedTimeAction = new JLabel("00 : 00 : 00");
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");
    JButton delete = new JButton("Delete");
    Model model;

    public MainFrame(Model model) {
        super("Clock");
        setBounds(400 , 400 , 250 , 400);
        this.model = model;

        initComponents();

        setDefaultCloseOperation(3);
    }

    public void initComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());

        this.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout
                .createParallelGroup(CENTER)
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(label)
                                .addComponent(clock)
                )
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(elapsedTime)
                                .addComponent(elapsedTimeAction)
                )
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(start)
                                .addComponent(stop)
                                .addComponent(delete)
                )

        );

        layout.setVerticalGroup(layout
                .createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(CENTER)
                                .addComponent(label , 0, 200, Short.MAX_VALUE)
                                .addComponent(clock)
                )
                .addGroup(
                        layout.createParallelGroup(CENTER)
                                .addComponent(elapsedTime , 100, 200, Short.MAX_VALUE)
                                .addComponent(elapsedTimeAction)
                )
                .addGroup(
                        layout.createParallelGroup(CENTER)
                                .addComponent(start)
                                .addComponent(stop)
                                .addComponent(delete)
                )
        );

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartActionController(model , elapsedTimeAction).actionPerformed(e);
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.elapsedTimer.stop();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.et = 0;
                elapsedTimeAction.setText("00 : 00 : 00");
                model.elapsedTimer.stop();
            }
        });

        Timer timer = new Timer(1000 ,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.setText(new GetTimeController().getTime());
            }
        });


        timer.start();

        setResizable(false);

        this.getContentPane().add(panel);
        pack();
    }
}
