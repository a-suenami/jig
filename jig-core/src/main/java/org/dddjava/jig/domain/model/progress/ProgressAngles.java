package org.dddjava.jig.domain.model.progress;

import org.dddjava.jig.domain.model.declaration.annotation.MethodAnnotations;
import org.dddjava.jig.domain.model.declaration.annotation.TypeAnnotations;
import org.dddjava.jig.domain.model.declaration.method.MethodDeclaration;
import org.dddjava.jig.domain.model.declaration.method.MethodDeclarations;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 進捗一覧
 */
public class ProgressAngles {
    public List<ProgressAngle> list;

    public ProgressAngles(MethodDeclarations declarations, TypeAnnotations typeAnnotations, MethodAnnotations methodAnnotations) {
        this.list = declarations.list().stream()
                .map(m -> new ProgressAngle(m, typeAnnotations, methodAnnotations))
                .collect(Collectors.toList());
    }

    public String progressOf(MethodDeclaration methodDeclaration) {
        return list.stream()
                .filter(angle -> angle.matches(methodDeclaration))
                .findAny()
                .map(ProgressAngle::asText).orElse("");
    }
}
