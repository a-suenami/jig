package org.dddjava.jig.domain.model.declaration.annotation;

import org.dddjava.jig.domain.model.declaration.method.MethodDeclaration;
import org.dddjava.jig.domain.model.declaration.type.TypeIdentifier;

/**
 * メソッドにつけられたアノテーション
 */
public class MethodAnnotation {

    final Annotation annotation;
    final MethodDeclaration methodDeclaration;

    public MethodAnnotation(Annotation annotation, MethodDeclaration methodDeclaration) {
        this.annotation = annotation;
        this.methodDeclaration = methodDeclaration;
    }

    public TypeIdentifier annotationType() {
        return annotation.annotationType;
    }

    public MethodDeclaration methodDeclaration() {
        return methodDeclaration;
    }

    public AnnotationDescription description() {
        return annotation.description;
    }
}
