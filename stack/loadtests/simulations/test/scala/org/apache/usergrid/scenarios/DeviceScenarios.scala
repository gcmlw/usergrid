/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 package org.apache.usergrid

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
 *
 * Creates a new device
 *
 * Expects:
 *
 * authToken The auth token to use when creating the application
 * orgName The name of the org
 * appName The name of the app
 * notifierName The name of the created notifier
 *
 * Produces:
 *
 * deviceName the name of the device created
 *
 */
object DeviceScenarios {

  /**
   * Create a device
   */
  val postDeviceWithNotifier = exec(http("Create device with notifier")
    .post("/devices")
    .body(StringBody("{\"name\":\"${entityName}\"," +
      "\"deviceModel\":\"Fake Device\"," +
      " \"deviceOSVerion\":\"Negative Version\", " +
      "\"${notifier}.notifier.id\":\"${entityName}\"}"))
    .check(status.is(200)))

  val postDeviceWithNotifier400ok = exec(http("Create device with notifier")
    .post("/devices")
    .body(StringBody("{\"name\":\"${entityName}\"," +
    "\"deviceModel\":\"Fake Device\"," +
    " \"deviceOSVerion\":\"Negative Version\", " +
    "\"${notifier}.notifier.id\":\"${entityName}\"}"))
    .check(status.in(200 to 400)))

  /**
   * TODO: Add a device to a user, which would expect a user in the session
   */



}