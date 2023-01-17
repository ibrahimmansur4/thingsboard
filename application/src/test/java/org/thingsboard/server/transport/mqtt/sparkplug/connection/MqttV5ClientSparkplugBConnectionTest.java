/**
 * Copyright © 2016-2022 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.mqtt.sparkplug.connection;

import org.eclipse.paho.mqttv5.common.MqttException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.thingsboard.server.dao.service.DaoSqlTest;

/**
 * Created by nickAS21 on 12.01.23
 */
@DaoSqlTest
public class MqttV5ClientSparkplugBConnectionTest extends AbstractMqttV5ClientSparkplugConnectionTest {

    @Before
    public void beforeTest() throws Exception {
        beforeSparkplugTest();
    }

    @After
    public void afterTest() throws MqttException {
        if (client.isConnected()) {
            client.disconnect();
        }
    }

    @Test
    public void testClientWithCorrectAccessToken() throws Exception {
        processClientWithCorrectNodeAccessTokenTest();
    }

    @Test
    public void testClientWithCorrectAccessTokenWithNDEATH() throws Exception {
        processClientWithCorrectNodeAccessTokenWithNdeathTest();
    }

    @Test
    public void testClientWithCorrectAccessTokenCreatedOneDevice() throws Exception {
        processClientWithCorrectAccessTokenCreatedDevices(1);
    }

    @Test
    public void testClientWithCorrectAccessTokenCreatedTwoDevice() throws Exception {
        processClientWithCorrectAccessTokenCreatedDevices(2);
    }

}
