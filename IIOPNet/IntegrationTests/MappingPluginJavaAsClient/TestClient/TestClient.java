import junit.framework.*;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;
import Ch.Elca.Iiop.IntegrationTests.MappingPlugin.*;
import java.util.ArrayList;


/**
 * Integration test for IIOP.NET.
 *
 */
public class TestClient extends TestCase {

    private TestService m_testService;

    public static void main (String[] args) {
        junit.textui.TestRunner.run (suite());
    }
    protected void setUp() throws Exception {
        Context ic = new InitialContext();
        Object objRef = ic.lookup("test");
        m_testService = (TestService) PortableRemoteObject.narrow(objRef, TestService.class);
    }

    protected void tearDown() {
        m_testService = null;     
    }

    public static Test suite() {
        return new TestSuite(TestClient.class);
    }

        
    private void CheckArrayListElems(ArrayList resultList, Object expectedValues, int expectedNrOfElems) {
        assertEquals(expectedNrOfElems, resultList.size());
        for (int i = 0; i < expectedNrOfElems; i++) {
            assertEquals(expectedValues, resultList.get(i));
        }
    }

    public void testDoubleArrayList() throws Exception {
        double val = 2.3;
        int nrOfElems = 5;
        ArrayList result = m_testService.CreateDoubleList(val, nrOfElems);
        CheckArrayListElems(result, new Double(val), nrOfElems);
        result.add(new Double(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Double(val), nrOfElems + 1);
        result.add(new Double(val + 1));
        ArrayList result3 = m_testService.EchoList(result);
        assertEquals(new Double(val + 1), result3.get(result3.size() - 1));
    }

    public void testFloatArrayList() throws Exception {
        float val = 3.3F;
        int nrOfElems = 5;
        ArrayList result = m_testService.CreateFloatList(val, nrOfElems);
        CheckArrayListElems(result, new Float(val), nrOfElems);
        result.add(new Float(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Float(val), nrOfElems + 1);
    }
        
    public void testByteArrayList() throws Exception {
        byte val = 4;
        int nrOfElems = 4;
        ArrayList result = m_testService.CreateByteList(val, nrOfElems);
        CheckArrayListElems(result, new Byte(val), nrOfElems);
        result.add(new Byte(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Byte(val), nrOfElems + 1);
    }

    public void testInt16ArrayList() throws Exception {
        short val = 8;
        int nrOfElems = 4;
        ArrayList result = m_testService.CreateShortList(val, nrOfElems);
        CheckArrayListElems(result, new Short(val), nrOfElems);
        result.add(new Short(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Short(val), nrOfElems + 1);
    }

    public void testInt32ArrayList() throws Exception {
        int val = 82997;
        int nrOfElems = 4;
        ArrayList result = m_testService.CreateIntList(val, nrOfElems);
        CheckArrayListElems(result, new Integer(val), nrOfElems);
        result.add(new Integer(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Integer(val), nrOfElems + 1);
    }

    public void testBooleanArrayList() throws Exception {
        boolean val = true;
        int nrOfElems = 4;
        ArrayList result = m_testService.CreateBooleanList(val, nrOfElems);
        CheckArrayListElems(result, new Boolean(val), nrOfElems);
        result.add(new Boolean(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Boolean(val), nrOfElems + 1);
    }

    public void testEmptyArrayList() throws Exception {
        ArrayList arg = new ArrayList();
        ArrayList result = m_testService.EchoList(arg);
        assertEquals(0, result.size());
    }
        
    public void testCharArrayList() throws Exception {
        char val = 'a';
        int nrOfElems = 4;
        ArrayList result = m_testService.CreateCharList(val, nrOfElems);
        CheckArrayListElems(result, new Character(val), nrOfElems);
        result.add(new Character(val));
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, new Character(val), nrOfElems + 1);
    }        

    public void testByRefArrayList() throws Exception {
        int nrOfElems = 4;
        ArrayList result = m_testService.CreateByRefTypeList(nrOfElems);
        assertEquals(nrOfElems, result.size());
        for (int i = 0; i < nrOfElems; i++) {
//            Assertion.AssertEquals(true, result[i].GetType().IsMarshalByRef);
//            Assertion.AssertEquals(true, RemotingServices.IsTransparentProxy(result[i]));
        }
        ArrayList result2 = m_testService.EchoList(result);
        assertEquals(nrOfElems, result2.size());
        for (int i = 0; i < nrOfElems; i++) {
//            Assertion.AssertEquals(true, result2[i].GetType().IsMarshalByRef);
//            Assertion.AssertEquals(true, RemotingServices.IsTransparentProxy(result2[i]));
        }
    }

    public void testValTypeArrayList() throws Exception {
        String msg = "msg";
        int nrOfElems = 10;
        TestSerializableClassB1Impl val = new TestSerializableClassB1Impl();
        val.Msg = msg;
        ArrayList result = m_testService.CreateValTypeList(msg, nrOfElems);
        CheckArrayListElems(result, val, nrOfElems);
        result.add(val);
        ArrayList result2 = m_testService.EchoList(result);
        CheckArrayListElems(result2, val, nrOfElems + 1);
    }


}