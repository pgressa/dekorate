/**
 * Copyright 2018 The original authors.
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
 * 
**/

package io.dekorate.knative.decorator;

import io.dekorate.knative.config.AutoScalerClass;
import io.dekorate.kubernetes.decorator.NamedResourceDecorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.knative.serving.v1.ServiceFluent;

public class ApplyLocalAutoscalingClassDecorator extends NamedResourceDecorator<ServiceFluent<?>> {

  private static final String AUTOSCALING_CLASS = "autoscaling.knative.dev/class";
  private static final String AUTOSCALING_CLASS_SUFFIX = ".autoscaling.knative.dev";

  private final AutoScalerClass clazz;

  public ApplyLocalAutoscalingClassDecorator(String name, AutoScalerClass clazz) {
		super("Service", name);
		this.clazz = clazz;
	}

	@Override
	public void andThenVisit(ServiceFluent<?> service, ObjectMeta resourceMeta) {
    service.editMetadata()
      .addToAnnotations(AUTOSCALING_CLASS, clazz.name().toLowerCase() + AUTOSCALING_CLASS_SUFFIX)
      .endMetadata();
	}
}
