package lv.javaguru.junit.workshop.lesson_2;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MockTest {

    @Test
    public void mockitoTest() {
        List<Integer> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(5);
        assertEquals(list.size(), 5);

        list.add(1);
        Mockito.verify(list).add(1);

        List<Integer> list2 = Mockito.mock(List.class);

        Mockito.verifyZeroInteractions(list2);



    }

}
