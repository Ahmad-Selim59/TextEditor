import java.awt.*;

public class Format_Functions {
    GUI gui;
    Font arial, cmsn, tnr;

    String selectedFont;
    public Format_Functions(GUI gui){
        this.gui = gui;

    }

    public void wordWrap(){
        if (gui.wordWrapOn == false){
            gui.wordWrapOn = true;
            gui.area.setLineWrap(true);
            gui.area.setWrapStyleWord(true);
            gui.iWrap.setText("Wrap text: on");
        } else if(gui.wordWrapOn == true){
            gui.wordWrapOn = false;
            gui.area.setLineWrap(false);
            gui.area.setWrapStyleWord(false);
            gui.iWrap.setText("Wrap text: off");
        }
    }

    public void font(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        cmsn = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        tnr = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch (selectedFont){
            case "Arial":
                gui.area.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.area.setFont(cmsn);
                break;
            case "Times New Roman":
                gui.area.setFont(tnr);
                break;
        }
    }
}
