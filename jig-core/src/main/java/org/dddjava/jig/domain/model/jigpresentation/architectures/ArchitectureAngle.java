package org.dddjava.jig.domain.model.jigpresentation.architectures;

import org.dddjava.jig.domain.model.jigdocument.*;
import org.dddjava.jig.domain.model.jigmodel.analyzed.AnalyzedImplementation;
import org.dddjava.jig.domain.model.jigmodel.architecture.Architecture;
import org.dddjava.jig.domain.model.jigmodel.architecture.ArchitectureFactory;
import org.dddjava.jig.domain.model.jigmodel.relation.RoundingPackageRelations;
import org.dddjava.jig.domain.model.jigsource.bytecode.TypeByteCodes;

import java.util.StringJoiner;

/**
 * アーキテクチャの切り口
 */
public class ArchitectureAngle {

    AnalyzedImplementation analyzedImplementation;
    ArchitectureFactory architectureFactory;

    public ArchitectureAngle(AnalyzedImplementation analyzedImplementation, ArchitectureFactory architectureFactory) {
        this.analyzedImplementation = analyzedImplementation;
        this.architectureFactory = architectureFactory;
    }

    public DiagramSources dotText(JigDocumentContext jigDocumentContext) {
        TypeByteCodes typeByteCodes = analyzedImplementation.typeByteCodes();

        Architecture architecture = architectureFactory.architecture();
        RoundingPackageRelations architectureRelation = RoundingPackageRelations.form(typeByteCodes, architecture);

        if (architectureRelation.worthless()) {
            return DiagramSource.empty();
        }

        DocumentName documentName = jigDocumentContext.documentName(JigDocument.ArchitectureDiagram);

        StringJoiner graph = new StringJoiner("\n", "digraph {", "}")
                .add("subgraph clusterArchitecture {")
                .add(Node.DEFAULT)
                .add(new Node("domain").asText())
                .add(new Node("presentation").asText())
                .add(new Node("application").asText())
                .add(new Node("infrastructure").asText())
                .add("}")
                .add("label=\"" + documentName.label() + "\";")
                .add("node [shape=box,style=filled,fillcolor=whitesmoke];");
        RelationText relationText = architectureRelation.toRelationText();
        graph.add(relationText.asText());
        return DiagramSource.createDiagramSource(documentName, graph.toString());
    }
}
