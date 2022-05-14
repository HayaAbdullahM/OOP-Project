import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;
import java.awt.image.BufferedImage;

public class MovieWidget extends JPanel {

    JLabel title = new JLabel();
    JLabel desc = new JLabel();
    JLabel id = new JLabel();
    JLabel type = new JLabel();
    JLabel typeValue = new JLabel();
    JLabel date = new JLabel();
    JLabel time = new JLabel();
    JLabel duration = new JLabel();
    JLabel imageLabel = new JLabel();

    MovieWidget(Movie m) {

        setLayout(null);
        BufferedImage img;

        try {
            img = ImageIO.read(new URL(
                    m.imgLink));
            imageLabel.setBackground(Color.WHITE);
            imageLabel.setBounds(10, 10, 190, 207);
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon(img).getImage().getScaledInstance(190, 207, Image.SCALE_DEFAULT));
            imageLabel.setIcon(imageIcon);
        } catch (Exception e) {

        }

        title.setText(m.title);
        title.setBounds(210, 40, 243, 27);
        title.setForeground(Color.white);
        title.setFont(new Font("MV Boli", Font.BOLD, 28));

        desc.setText(m.genre);
        desc.setBounds(210, 65, 400, 27);
        desc.setForeground(Color.white);
        desc.setFont(new Font("MV Boli", Font.BOLD, 18));

        duration.setText("Duration : " + m.duration + " Minutes");
        duration.setBounds(210, 100, 400, 27);
        duration.setForeground(Color.white);
        duration.setFont(new Font("MV Boli", Font.BOLD, 16));

        id.setText("NO : " + m.id);
        id.setBounds(210, 170, 400, 27);
        id.setForeground(Color.white);
        id.setFont(new Font("MV Boli", Font.BOLD, 18));

        type.setText("Type");
        type.setBounds(500, 40, 400, 27);
        type.setForeground(Color.white);
        type.setFont(new Font("MV Boli", Font.BOLD, 18));

        typeValue.setText(m.type);
        typeValue.setBounds(500, 70, 400, 27);
        typeValue.setForeground(Color.white);
        typeValue.setFont(new Font("MV Boli", Font.BOLD, 18));

        time.setText("Show Time : " + m.showTime);
        time.setBounds(400, 140, 400, 27);
        time.setForeground(Color.white);
        time.setFont(new Font("MV Boli", Font.BOLD, 16));

        date.setText("Date : " + m.showDate);
        date.setBounds(400, 170, 400, 27);
        date.setForeground(Color.white);
        date.setFont(new Font("MV Boli", Font.BOLD, 16));

        // ! Adding

        add(imageLabel);
        add(title);
        add(desc);
        add(id);
        add(type);
        add(typeValue);
        add(time);
        add(date);
        add(duration);

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(650, 227));
        setBackground(Color.BLACK);
    }

}
