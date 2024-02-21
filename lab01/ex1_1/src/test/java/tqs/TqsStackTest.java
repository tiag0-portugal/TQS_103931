package tqs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TqsStackTest {

    private TqsStack<Integer> st;


    @BeforeEach 
    public void init(){
        st = new TqsStack<Integer>();
        st.push(6);
        st.push(32);
        st.push(11);
    }


    @Test
    @DisplayName("Push Test")
    public void pushtest() {
        st.push(52);
        Assertions.assertEquals(52,st.peek());
    }


    @Test
    @DisplayName("Add Test")
    public void addtest() {
        st.add(52);
        st.pop();
        st.pop();
        st.pop();
        Assertions.assertEquals(52,st.peek());
    }

    @Test
    @DisplayName("Pop Test")
    public void poptest() {
        Assertions.assertEquals(11,st.pop());
    }


    @Test
    @DisplayName("Peek test")
    public void peektest() {
        Assertions.assertEquals(11,st.peek());
    }


    @Test
    @DisplayName("Size test")
    public void sizetest() {
        Assertions.assertEquals(3,st.size());
    }


    @Test
    @DisplayName("isEmpty test")
    public void isEmptytest() {
        Assertions.assertEquals(false,st.isEmpty());
    }
}
