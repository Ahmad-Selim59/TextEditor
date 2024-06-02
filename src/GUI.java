import javax.swing.*;

public class GUI {

    JFrame window;
    JTextArea area;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colourMenu;
    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea(){
        area = new JTextArea();
        scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);

    }

    public void createMenuBar(){
        menuBar = new JMenuBar();

        window.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        formatMenu = new JMenu("Format");
        menuBar.add(formatMenu);

        colourMenu = new JMenu("Colour");
        menuBar.add(colourMenu);

    }


}
