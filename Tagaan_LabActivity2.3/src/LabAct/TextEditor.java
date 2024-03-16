package LabAct;

public class TextEditor {
    
    private String text;
    
    public TextEditor(){
    }

    public TextEditor (String initialText) {
        text = initialText;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String initialText) {
        text = initialText;
    }
    
    public void append(String newText) {
        text = text + newText;
    }
    
    public void delete(int n) {
        if(n >= 0 && n <= text.length()) {
            text = text.substring(0, text.length() - n);
        }       
    }
}
