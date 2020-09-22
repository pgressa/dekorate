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

package io.dekorate.jaeger.doc;

import io.sundr.builder.annotations.Pojo;
import io.sundr.codegen.annotations.AnnotationSelector;
import io.sundr.codegen.model.Attributeable;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;

@VelocityTransformations(value = @VelocityTransformation(value = "/annotation-doc.vm", outputPath = "annotation-table.org", gather = true), annotations = {
    @AnnotationSelector(value = Pojo.class)
})
public class JaegerAnnotationsTableGenerator {

  private Object DEFAULT_VALUE = Attributeable.DEFAULT_VALUE;
}
