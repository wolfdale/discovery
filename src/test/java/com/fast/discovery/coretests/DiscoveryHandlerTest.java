package com.fast.discovery.coretests;

import com.fast.discovery.core.DiscoveryHandler;
import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import com.fast.discovery.utility.Utilities;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Desc - Discovery Core logic tests.
 * @Author -
 */
public class DiscoveryHandlerTest {

/*    @Test
    @Ignore
    public void serviceRegistrationPositiveAckTest(){
        DiscoveryHandler discoveryHandler = new DiscoveryHandler();
        ServiceRegistry sRegistry = new ServiceRegistry();
        sRegistry.setInstanceId("UniqueInstanceId");
        ServiceRegistry.InstanceInfo insInfo = new ServiceRegistry.InstanceInfo();
        insInfo.setServiceName("Dummy Micro-Service");
        sRegistry.setInstanceInformation(insInfo);
        Acknowledgement ack = discoveryHandler.serviceRegistration(sRegistry);
        assertTrue(ack.isAck());
    }
    @Test
    @Ignore
    public void serviceRegistrationPositiveMsgTest(){
        DiscoveryHandler discoveryHandler = new DiscoveryHandler();
        ServiceRegistry sRegistry = new ServiceRegistry();
        sRegistry.setInstanceId("UniqueInstanceId-1");
        ServiceRegistry.InstanceInfo insInfo = new ServiceRegistry.InstanceInfo();
        insInfo.setServiceName("Dummy Micro-Service");
        sRegistry.setInstanceInformation(insInfo);
        Acknowledgement ack = discoveryHandler.serviceRegistration(sRegistry);
        assertEquals(ack.getMsg(), Utilities.SERVICE_REGISTERED);
    }

    @Test
    @Ignore
    public void serviceRegistrationNegativeAckTest(){
        DiscoveryHandler discoveryHandler = new DiscoveryHandler();
        ServiceRegistry s1Registry = new ServiceRegistry();
        s1Registry.setInstanceId("UniqueInstanceId-2");
        ServiceRegistry.InstanceInfo insInfo1 = new ServiceRegistry.InstanceInfo();
        insInfo1.setServiceName("Dummy Micro-Service");
        s1Registry.setInstanceInformation(insInfo1);
        Acknowledgement ackS1 = discoveryHandler.serviceRegistration(s1Registry);
        assertTrue(ackS1.isAck());
        ServiceRegistry s2Registry = new ServiceRegistry();
        s1Registry.setInstanceId("UniqueInstanceId-2");
        ServiceRegistry.InstanceInfo insInfo2 = new ServiceRegistry.InstanceInfo();
        insInfo2.setServiceName("Dumb Micro-Service");
        s1Registry.setInstanceInformation(insInfo2);
        Acknowledgement ackS2 = discoveryHandler.serviceRegistration(s1Registry);
        assertFalse(ackS2.isAck());
    }

    @Test
    @Ignore
    public void serviceRegistrationNegativeMsgTest(){
        DiscoveryHandler discoveryHandler = new DiscoveryHandler();
        ServiceRegistry s1Registry = new ServiceRegistry();
        s1Registry.setInstanceId("UniqueInstanceId-3");
        ServiceRegistry.InstanceInfo insInfo1 = new ServiceRegistry.InstanceInfo();
        insInfo1.setServiceName("Dummy Micro-Service");
        s1Registry.setInstanceInformation(insInfo1);
        Acknowledgement ackS1 = discoveryHandler.serviceRegistration(s1Registry);
        assertEquals(ackS1.getMsg(), Utilities.SERVICE_REGISTERED);
        ServiceRegistry s2Registry = new ServiceRegistry();
        s1Registry.setInstanceId("UniqueInstanceId-3");
        ServiceRegistry.InstanceInfo insInfo2 = new ServiceRegistry.InstanceInfo();
        insInfo2.setServiceName("Dumb Micro-Service");
        s1Registry.setInstanceInformation(insInfo2);
        Acknowledgement ackS2 = discoveryHandler.serviceRegistration(s1Registry);
        assertEquals(ackS2.getMsg(), Utilities.SERVICE_ALREADY_REGISTERED);
    }*/
}
