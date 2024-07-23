package MaiJavaTools;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import static org.mockito.Mockito.*;
import java.lang.reflect.Field;

public class BitOperationsUtilTest {

    @Mock
    private BitOperationsUtil mockInstance;

    // https://stackoverflow.com/questions/38914433/mocking-a-singleton-with-mockito
    @Before
    public void setUp() {

        mockInstance = mock(BitOperationsUtil.class);

        when(mockInstance.toString()).thenReturn("MockedBitOperationsUtil");

        setMock(mockInstance);
    }
    private void setMock(BitOperationsUtil mock) {
        try {
            Field instance = BitOperationsUtil.class.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, mock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void resetSingleton() throws Exception {
        Field instance = BitOperationsUtil.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }



    @Test
    public void testMockedBitOperationsUtilToString() {

        String s = BitOperationsUtil.getInstance().toString();

        assertEquals("MockedBitOperationsUtil", s);
    }
}
