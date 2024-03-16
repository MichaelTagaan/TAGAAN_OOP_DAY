package LabAct;

import java.util.Stack;

public class AdvancedTextEditor extends TextEditor {
    
    private final Stack<String> undoStack;
    
    public AdvancedTextEditor(String text){
        super(text);
        undoStack = new Stack<>();
    }
    
    public void undo() {
        if(undoStack.isEmpty() == false) {
            setText(undoStack.pop());
        }
    }
    
    @Override
    
    public void append(String newText) {
        undoStack.push(getText());
        super.append(newText);
    }
    
    @Override
    
    public void delete(int n) {
        undoStack.push(getText());
        super.delete(n);
    }

}
