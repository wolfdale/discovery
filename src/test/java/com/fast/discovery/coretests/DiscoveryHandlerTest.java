package com.fast.discovery.coretests;

import com.fast.discovery.core.DiscoveryHandler;
import com.fast.discovery.dto.Acknowledgement;
import com.fast.discovery.dto.ServiceRegistry;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @Desc - Discovery Core logic tests.
 * @Author -
 */
public class DiscoveryHandlerTest {
    @Autowired
    DiscoveryHandler discoveryHandler;
    @Test
    public void serviceRegistrationPositiveAckTest(){
        ServiceRegistry sRegistry = new ServiceRegistry();
        sRegistry.setInstanceId("UniqueInstanceId");
        ServiceRegistry.InstanceInfo insInfo = new ServiceRegistry.InstanceInfo();
        insInfo.setServiceName("Dummy Micro-Service");
        sRegistry.setInstanceInformation(insInfo);
        Acknowledgement ack = discoveryHandler.serviceRegistration(sRegistry);
        assertTrue(ack.isAck());
    }

}
