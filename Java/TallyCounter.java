import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TallyCounter extends Frame{
    TextField display;
    Button increment, reset;

    TallyCounter(){
        display = new TextField("0");
        display.setBounds(200,100,100,30);

        increment = new Button("+");
        increment.setBounds(205,140,30,20);
        increment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(display.getText());
                display.setText(Integer.toString(++num));
            }
        });

        reset = new Button("Reset");
        reset.setBounds(245,140,50,20);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
            }
        });

        add(display);
        add(increment);
        add(reset);

        setLayout(null);
        setSize(500,500);
        setTitle("Tally Counter");
        setVisible(true);

    }
}

void main(String[] args) {
    new TallyCounter();
}
