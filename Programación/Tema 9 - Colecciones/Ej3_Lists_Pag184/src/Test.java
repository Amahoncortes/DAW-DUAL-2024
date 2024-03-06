public class Test{
    private int stackSize;
    private char[] stackArray;
    private int top;

    public Test(int size){
        this.stackSize = size;
        this.stackArray = new char[stackSize];
        this.top = -1;
    }


    /**
     * Adds new entry to the top of the stack
     * @param entry
     * @throws Exception
     */
    public void push(char entry) throws Exception{
        this.stackArray[++top] = entry;
    }

    /**
     * Borra una entrada de la cima de la pila
     * @return
     * @throws Exception
     */
    public char pop() throws Exception{
    if(this.isStackEmpty()){
    System.out.println("Stack underflow");
    }
    return this.stackArray[top--];
    }

    /**
     * Devuelve la cima de la pila sin borrarla
     * @return
     */
    public int peek(){
        return stackArray[top];
    }


    /**
     * Devuelve verdadero si la pila está llena
     * @return
     */
    public boolean isStackFull(){
        return (top == stackSize -1);
    }


    /**
     * Devuelve verdadero si la pila está vacía
     * @return
     */
    public boolean isStackEmpty(){
        return (top == -1);
    }

    public String reverseWord(String word) throws Exception{
        StringBuilder sb = new StringBuilder();
        int size = word.length();
        for (int i = 0; i < size; i++) {
            push(word.charAt(i));
        }
        while(!isStackEmpty()){
            sb.append(pop());
        }
        return sb.toString();
    }
}