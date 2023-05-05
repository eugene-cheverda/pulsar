package org.apache.pulsar.client.impl.conf;

import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.testng.annotations.Test;

/**
 * Unit tests for {@link ProducerConfigurationData}.
 */
public class ProducerConfigurationDataTest {
    @Test
    public void testProducerConfigurationDataSerializedWithoutIgnoredTransientFields() throws JsonProcessingException {
        ProducerConfigurationData producerConfigurationData = new ProducerConfigurationData();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String serializedConf = objectMapper.writeValueAsString(producerConfigurationData);
        assertThat(serializedConf).doesNotContain("messageCrypto");
    }
}
