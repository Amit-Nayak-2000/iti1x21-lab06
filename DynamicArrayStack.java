public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        if(capacity < DEFAULT_INC){
            elems = (E[]) new Object[DEFAULT_INC];
            top = 0;
        }
        else{
            elems = (E[]) new Object[capacity];
            top = 0;
        }
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        if((top > DEFAULT_INC && ((getCapacity() - top) == DEFAULT_INC - 1))){
            E saved = elems[--top];
            elems[top] = null;

            int decrementNum = getCapacity() - DEFAULT_INC ;;
            if(decrementNum < DEFAULT_INC){
                decrementNum = DEFAULT_INC;
            }
            E[] temp = (E[]) new Object[decrementNum];

            for(int i = 0; i < (decrementNum); i++){
                temp[i] = elems[i];
            }

            elems = (E[]) new Object[decrementNum];
            for(int i = 0; i < (decrementNum); i++){
                elems[i] = temp[i];
            }
            
            return saved;
        }
        else{
            E saved = elems[ --top ];

            elems[ top ] = null; 

            return saved;

        }
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        if(top == getCapacity()){
            E[] temp = (E[]) new Object[getCapacity()];

            for(int i = 0; i < getCapacity(); i++){
                temp[i] = elems[i];
            }

            int oldIndex = getCapacity();
            int topCount = getCapacity() - 1;
            elems = (E[]) new Object[getCapacity() + DEFAULT_INC];
            

            for(int i = 0; i < oldIndex; i++){
                elems[i] = temp[i];
            }

            elems[top++] = element;
        }
        else{
            elems[top++] = element;
        }
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        while(isEmpty() == false){
            E temp = pop();
        }
    }

}
