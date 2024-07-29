/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ranger.services.uc;

import org.apache.ranger.plugin.policyengine.RangerAccessRequest;
import org.apache.ranger.plugin.policyengine.RangerAccessResult;
import org.apache.ranger.plugin.service.RangerBasePlugin;

/**
 * @author Haneul, Kim
 * @version 3.0.0
 * @since 2024-07-29
 */
public class RangerUCAuthorizer {

  private final RangerBasePlugin plugin;

  public RangerUCAuthorizer(String serviceName) {
    this.plugin = new RangerBasePlugin("unitycatalog", serviceName);
  }

  public void init() {
    plugin.init();
  }

  public boolean isAccessAllowed(RangerAccessRequest request) {
    RangerAccessResult result = plugin.isAccessAllowed(request);
    return result != null && result.getIsAllowed();
  }
}
