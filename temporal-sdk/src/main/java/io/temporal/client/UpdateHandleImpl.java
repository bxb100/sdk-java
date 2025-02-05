/*
 * Copyright (C) 2022 Temporal Technologies, Inc. All Rights Reserved.
 *
 * Copyright (C) 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Modifications copyright (C) 2017 Uber Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this material except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.temporal.client;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.common.Experimental;
import java.util.concurrent.CompletableFuture;

@Experimental
final class UpdateHandleImpl<T> implements UpdateHandle<T> {

  private final String id;
  private final WorkflowExecution execution;
  private final CompletableFuture<T> future;

  UpdateHandleImpl(String id, WorkflowExecution execution, CompletableFuture<T> future) {
    this.id = id;
    this.execution = execution;
    this.future = future;
  }

  @Override
  public WorkflowExecution getExecution() {
    return execution;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public CompletableFuture<T> getResultAsync() {
    return future;
  }
}
