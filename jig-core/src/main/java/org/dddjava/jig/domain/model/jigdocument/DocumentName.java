package org.dddjava.jig.domain.model.jigdocument;

public class DocumentName {

    JigDocument jigDocument;
    String fileName;
    String label;

    DocumentName(JigDocument jigDocument, String fileName, String label) {
        this.jigDocument = jigDocument;
        this.fileName = fileName;
        this.label = label;
    }

    public static DocumentName of(JigDocument jigDocument, String diagramLabel) {
        return new DocumentName(jigDocument, jigDocument.fileName(), diagramLabel);
    }

    public DocumentName withSuffix(String suffix) {
        return new DocumentName(this.jigDocument, this.fileName + suffix, this.label);
    }

    public String withExtension(String extension) {
        return fileName + "." + extension;
    }

    public String label() {
        return label;
    }
}
